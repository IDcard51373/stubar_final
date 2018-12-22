package cn.edu360.servlet;

import cn.edu360.beans.City;
import cn.edu360.dao.CityDao;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * 处理userinfoedit.jsp页面的省市二级联动的Servlet
 */
public class CityAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CityAjax() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String provId = request.getParameter("provId");
		CityDao cityDao = new CityDao();
		List<City> allCityByProvId = cityDao.queryCityByProvId(provId);
		String jsonString = JSONObject.toJSONString(allCityByProvId);
		//System.out.println(jsonString);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println(jsonString);
	}

}
