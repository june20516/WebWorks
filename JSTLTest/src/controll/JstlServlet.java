package controll;

import java.io.IOException;
import java.lang.annotation.Repeatable;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Jstl
 */

public class JstlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    /**
     * Default constructor. 
     */
    public JstlServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	java.util.List<String> list = new ArrayList<String>();
	list.add("수업이");
	list.add("너무");
	list.add("어렵고");
	list.add("빠릅니다");
	list.add(".");
	request.setAttribute("list", list);
	
	request.getRequestDispatcher("CoreTest2.jsp").forward(request, response);
	
	}

	

}
