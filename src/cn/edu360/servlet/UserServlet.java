package cn.edu360.servlet;

import cn.edu360.beans.User;
import cn.edu360.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 处理用户请求登录和处理的Servlet
 *
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserServlet() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String flag = request.getParameter("flag");
		String account = request.getParameter("account");
		String password = request.getParameter("pwd");
		String email = request.getParameter("email");
		UserDao user = new UserDao();
		if ("register".equals(flag)) {
			int register = user.register(account, password, email);
			if (register == 0) {
				// 注册失败
				// response.sendRedirect("register.html");
				request.getRequestDispatcher("failToRegister.html").forward(request, response);
			} else {
				// 注册成功
				 request.getRequestDispatcher("indexServlet.do?f=register").forward(request, response);
//				response.sendRedirect("indexServlet.do?f=register");
			}
		} else {
			HttpSession session = request.getSession();
			User u = (User) session.getAttribute("account");
			if (null != u) {
				response.getWriter().append("<h1 style=\'color: red\'>" + u.getEmail() + "已经登录过了，无需重复登录!</h1>");
			} else {
				User us = user.login(account, password);
				if (null != us) {
					// session.invalidate();
					session.setAttribute("account", us);
					request.getRequestDispatcher("indexServlet.do?f=login").forward(request, response);
				} else {
					request.getRequestDispatcher("indexServlet.do?f=failtologin").forward(request, response);
					// response.sendRedirect("index.jsp");
				}
			}
		}

	}

}
