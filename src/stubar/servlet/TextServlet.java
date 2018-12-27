package stubar.servlet;

import stubar.beans.Invitation;
import stubar.beans.Review;
import stubar.beans.User;
import stubar.dbutils.DBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 处理个人帖子的servlet
 */
public class TextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TextServlet() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("account");
		String methodName = request.getParameter("md");
		if (user == null) {
			request.getRequestDispatcher("textshow.jsp").forward(request, response);
		} else {
			if ("edit".equals(methodName)) {
				doEditText(request, response);
			} else if ("read".equals(methodName)) {
				doRead(request, response);
			} else if ("postcomment".equals(methodName)) {
				doPostComment(request, response);
				doRead(request, response);
			} else {
				if ("update".equals(methodName)) {
					doUpateText(request, response);
				} else if ("postext".equals(methodName)) {
					doPostTest(request, response, user);
				} else if ("delete".equals(methodName)) {
					doDeleteText(request, response);
				}
				showText(request, response, user);
			}
		}
	}

	/**
	 * 根据onetext.jsp页面传过来的关于评论的相关信息更新review数据库表
	 * 
	 * @param request
	 * @param response
	 */
	private void doPostComment(HttpServletRequest request, HttpServletResponse response) {
		String paid = request.getParameter("pid");
		String pobserver = request.getParameter("postobserver");
		String ptextcomment = request.getParameter("textcomment");
		Date date = new Date();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String fmtstr = fmt.format(date);
		QueryRunner queryRunner = new QueryRunner(DBUtils.getDataSource());
		String sql = "insert into review(aid,observer,comment,ctime) values(?,?,?,?)";
		try {
			queryRunner.update(sql, paid,pobserver,ptextcomment,fmtstr);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据提交过来的文章id获取当前需要显示的文章，并将当前在数据库中查找到的内容绑定到请求中提交给onetext.jsp页面
	 * 
	 * @param request
	 * @param response
	 */
	private void doRead(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("pid");
		QueryRunner queryRunner = new QueryRunner(DBUtils.getDataSource());
		String sql = "select * from invitation where id = ?";
		String sql1 = "select * from review where aid = ? order by id desc";
		try {
			Invitation invitation = queryRunner.query(sql, new BeanHandler<Invitation>(Invitation.class), id);
			List<Review> review = queryRunner.query(sql1, new BeanListHandler<Review>(Review.class), id);
			request.setAttribute("jspinvitation", invitation);
			request.setAttribute("jspreview", review);
			request.getRequestDispatcher("onetext.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据textshow.jsp提交过来的帖子ID删除相应的帖子，并重新刷新页面
	 * 
	 * @param request
	 * @param response
	 */
	private void doDeleteText(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("pid");
		QueryRunner queryRunner = new QueryRunner(DBUtils.getDataSource());
		String sql = "delete from invitation where id = ?";
		try {
			queryRunner.update(sql, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据posttext.jsp页面提交过来的标题和正文向数据库中插入一条该用户的帖子信息
	 * 
	 * @param request
	 * @param response
	 * @param user
	 */
	private void doPostTest(HttpServletRequest request, HttpServletResponse response, User user) {
		String title = request.getParameter("texttitle");
		String article = request.getParameter("textarticle");
		Date date = new Date();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String fmtstr = fmt.format(date);
		QueryRunner queryRunner = new QueryRunner(DBUtils.getDataSource());
		String sql = "insert into invitation(account,title,article,time) values(?,?,?,?)";
		try {
			queryRunner.update(sql, user.getAccount(), title, article, fmtstr);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据textedit.jsp提交过来的修改后的数据更新invitation数据库
	 * 
	 * @param request
	 * @param response
	 */
	private void doUpateText(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("pid");
		String title = request.getParameter("texttitle");
		String article = request.getParameter("textarticle");
		Date date = new Date();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String fmtstr = fmt.format(date);
		QueryRunner queryRunner = new QueryRunner(DBUtils.getDataSource());
		String sql = "update invitation set title=?,article=?,time=? where id = ?";
		try {
			queryRunner.update(sql, title, article, fmtstr, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 处理textshow.jsp点击编辑后跳转到textedit.jsp的方法
	 * 
	 * @param request
	 * @param response
	 */
	private void doEditText(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("pid");
		QueryRunner queryRunner = new QueryRunner(DBUtils.getDataSource());
		String sql = "select * from invitation where id = ?";
		try {
			Invitation invitation = queryRunner.query(sql, new BeanHandler<Invitation>(Invitation.class), id);
			request.setAttribute("jspinvitation", invitation);
			request.getRequestDispatcher("textedit.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 向textshow.jsp中显示当前登录用户所有发布的主题
	 * 
	 * @param request
	 * @param response
	 * @param user
	 */
	private void showText(HttpServletRequest request, HttpServletResponse response, User user) {
		List<Invitation> list = queryInvitation(request, response, user);
		request.setAttribute("jsptextlist", list);
		try {
			request.getRequestDispatcher("textshow.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 在数据库中的invitation表中查找当前登录者的所有发布主题，并返回
	 * 
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 */
	private List<Invitation> queryInvitation(HttpServletRequest request, HttpServletResponse response, User user) {
		QueryRunner queryRunner = new QueryRunner(DBUtils.getDataSource());
		String sql = "select * from invitation where account = ? order by id desc";
		try {
			return queryRunner.query(sql, new BeanListHandler<Invitation>(Invitation.class), user.getAccount());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
