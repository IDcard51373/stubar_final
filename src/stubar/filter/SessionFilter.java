package stubar.filter;

import stubar.beans.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionFilter implements Filter {

	public SessionFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		String currentAccount = req.getParameter("account");
		User u = (User)session.getAttribute(currentAccount);
		String uri = req.getRequestURI();
		if(uri.endsWith(".jsp")||uri.endsWith(".js")||uri.endsWith("userInfoServlet.do")||uri.endsWith(".css")||uri.endsWith("logoutServlet.do")||uri.endsWith("userServlet.do")||uri.endsWith("register.html")||uri.endsWith(".jpg")||uri.endsWith(".eot")||uri.endsWith(".svg")||uri.endsWith(".ttf")||uri.endsWith(".woff")||uri.endsWith(".woff2")){
			chain.doFilter(request, response);
		}else{
			if(null == u){
				request.getRequestDispatcher("index.jsp").forward(request, response);
				return;
			}else{
				chain.doFilter(request, response);
			}
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
