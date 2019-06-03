package controll;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class CoreTestHasMap
 */
@WebServlet("/CoreTestHasMap")
public class CoreTestHasMap extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoreTestHasMap() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "두리안1");
		map.put("2", "두리안2");
		map.put("3", "두리안3");
		map.put("4", "두리안4");
		
		request.setAttribute("map", map);
		request.getRequestDispatcher("CoreTest3.jsp").forward(request, response);
		
	}

	

}
