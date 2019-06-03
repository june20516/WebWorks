package scope;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TestServlet
 */
public class TestServlet extends HttpServlet {
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
			
		// session scope
			HttpSession session = request.getSession();
			session.setAttribute("key2", new Date());
		
		// application scope
			ServletContext application = request.getServletContext();
			List<String> list = new ArrayList<String>();
			list.add("kim");
			list.add("park");
			application.setAttribute("key3", list);
		
		response.sendRedirect("result.jsp");
		
	}

}
