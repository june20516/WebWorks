package scope;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.bean.Custom;

/**
 * Servlet implementation class TestServlet
 */
public class TestServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// scope data insert ==> setAttribute("key", object value);
		
		// request scope
			request.setAttribute("key1", "value1");
			request.setAttribute("key", "value1");
			
		// session scope
			HttpSession session = request.getSession();
			session.setAttribute("key2", new Date());
			session.setAttribute("date", new Date());
			session.setAttribute("key", "value2");
		
		// application scope
			ServletContext application = request.getServletContext();
			List<String> list = new ArrayList();
			list.add("kim");
			list.add("park");
			application.setAttribute("key3", list);
			application.setAttribute("list", list);
			application.setAttribute("key", "value3");
		
		//response.sendRedirect("result.jsp");
			
			Map<String, Custom>map = new HashMap<String, Custom>();
			Custom cust1 = new Custom();
			cust1.setName("��ȣ");
			cust1.setAge(20);
			
			map.put("cust1", cust1);
			request.setAttribute("map", map);
			
			request.getRequestDispatcher("result2.jsp").forward(request, response);
		
	}

}
