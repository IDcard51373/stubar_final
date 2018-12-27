package stubar.servlet;

import stubar.beans.Invitation;
import stubar.dbutils.DBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * 处理首页动态显示的Servlet
 */
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public IndexServlet() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Invitation> allText = findAllText1();
		List<Invitation> allText2 = findAllText2();
		for (Invitation invitation : allText) {
			if(invitation.getArticle().length() > 140){
				invitation.setArticle(invitation.getArticle().substring(0, 140)+"......");
			}
		}
		String flag = request.getParameter("f");
		if("index".equals(flag)){
			request.setAttribute("jspAllText", allText);
			request.getRequestDispatcher("protal.jsp").forward(request, response);
		}else if("register".equals(flag)){
			request.setAttribute("jspAllText", allText);
			request.getRequestDispatcher("registersuccess.jsp").forward(request, response);
		}else if("login".equals(flag)){
			request.setAttribute("jspAllText", allText);
			request.getRequestDispatcher("loginsuccess.jsp").forward(request, response);
		}else if("failtologin".equals(flag)){
			request.setAttribute("jspAllText", allText);
			request.getRequestDispatcher("loginfail.jsp").forward(request, response);
		}else{
			request.setAttribute("jspAllText", allText2);
			request.getRequestDispatcher("bbsindex.jsp").forward(request, response);
		}
		
	}

	/**
	 * 查询数据库中前十存储的文章
	 * @return 
	 */
	private List<Invitation> findAllText1() {
		QueryRunner queryRunner = new QueryRunner(DBUtils.getDataSource());
		String sql = "select * from invitation  order by id desc limit 5";
		try {
			List<Invitation> list = queryRunner.query(sql, new BeanListHandler<Invitation>(Invitation.class));
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 查询数据库中存储的文章
	 * @return 
	 */
	private List<Invitation> findAllText2() {
		QueryRunner queryRunner = new QueryRunner(DBUtils.getDataSource());
		String sql = "select * from invitation order by id desc";
		try {
			List<Invitation> list = queryRunner.query(sql, new BeanListHandler<Invitation>(Invitation.class));
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
