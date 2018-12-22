package cn.edu360.servlet;

import cn.edu360.beans.City;
import cn.edu360.beans.Province;
import cn.edu360.beans.User;
import cn.edu360.beans.UserInfo;
import cn.edu360.dao.CityDao;
import cn.edu360.dao.ProvinceDao;
import cn.edu360.dbutils.DBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * 处理用户个人信息的Servlet
 */
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserInfoServlet() {
		super();
	}

	/**
	 * 处理userinfo.jsp页面中显示个人信息与编辑个人信息的service
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("account");
		String methodName = request.getParameter("md");
		if(user==null){
			request.getRequestDispatcher("userinfo.jsp").forward(request, response);
		}else{
			if ("edit".equals(methodName)) {
				doEdit(request, response, user);
			} else if ("update".equals(methodName)) {
				User us = doUpate(request, response, user);
				session.removeAttribute("account"); 
				session.setAttribute("account", us);
				showUserInfo(request, response, user);
			} else {
				showUserInfo(request, response, user);
			}
		}
	}

	/**
	 * 处理userinfoedit.jsp页面上的保存操作，将编辑好的信息保存至userinfo数据库中，并刷新个人资料页面
	 * 
	 * @param request
	 * @param response
	 * @param user
	 * @return 
	 */
	private User doUpate(HttpServletRequest request, HttpServletResponse response, User user) {
		String email = request.getParameter("userinfoemail");
		String sex = request.getParameter("userinfosex");
		int age = Integer.parseInt(request.getParameter("userinfoage"));
		String qq = request.getParameter("userinfoqq");
		String phone = request.getParameter("userinfophone");
		String description = request.getParameter("userinfodescription");
		String provId = request.getParameter("prov");
		ProvinceDao provinceDao = new ProvinceDao();
		Province queryProvinceById = provinceDao.queryProvinceById(provId);
		 String CityId = request.getParameter("city");
		CityDao cityDao = new CityDao();
		City queryCityById = cityDao.queryCityById(CityId);
		String location = queryProvinceById.getName()+queryCityById.getName()+request.getParameter("userinfolocation");
		QueryRunner queryRunner = new QueryRunner(DBUtils.getDataSource());
		String sql = "update userinfo set sex=?,age=?,qq=?,phone=?,description=?,location=? where account=?";
		String sql1 = "update user set email = ? where account = ?";
		try {
			queryRunner.update(sql, sex, age, qq, phone, description, location, user.getAccount());
			queryRunner.update(sql1, email,user.getAccount());
			user.setEmail(email);
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 在个人资料页面显示信息的方法
	 * 
	 * @param request
	 * @param response
	 * @param user
	 */
	private void showUserInfo(HttpServletRequest request, HttpServletResponse response, User user) {
		UserInfo us = queryUserInfo(request, response, user);
		request.setAttribute("jspuserinfo", us);
		try {
			request.getRequestDispatcher("userinfo.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * userinfo.jsp页面请求编辑页面的处理方法，跳转到userinfoedit.jsp页面上 并将数据库已有的个人信息显示到当前页面上
	 * 
	 * @param request
	 * @param response
	 * @param user
	 */
	private void doEdit(HttpServletRequest request, HttpServletResponse response, User user) {
		UserInfo us = queryUserInfo(request, response, user);
		ProvinceDao provinceDao = new ProvinceDao();
		List<Province> allProvince = provinceDao.queryAllProvince();
		request.setAttribute("jsprovince", allProvince);
		request.setAttribute("jspuserinfo", us);
		try {
			request.getRequestDispatcher("userinfoedit.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据当前session中保存的account用户去userinfo表中查询当前个人资料 并将其返回一个userinfo对象
	 * 
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 */
	private UserInfo queryUserInfo(HttpServletRequest request, HttpServletResponse response, User user) {
		QueryRunner queryRunner = new QueryRunner(DBUtils.getDataSource());
		String sql = "select * from userinfo where account = ?";
		try {
			return queryRunner.query(sql, new BeanHandler<UserInfo>(UserInfo.class), user.getAccount());
			// request.setAttribute("jspuserinfo", us);
			// request.getRequestDispatcher("userinfo.jsp").forward(request,
			// response);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
