package a.b.c;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class mappingTestServlet
 */
public class mappingTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mappingTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
	 PrintWriter out = response.getWriter().append("No Jsp : ").append(request.getContextPath()); 
	 }
	 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");	//읽어내기위한 request 의 encoding 은 get 이전에 
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		System.out.println(id + password);
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");	// 보내기 위한 response의 encoding은 forward 이전에

		
		//welcome.jsp를 호출, id님안녕하세요. 환영메세지 출력
//		response.sendRedirect("Welcome.jsp"); //접속을 끊고 다시 재설정
		request.setAttribute("id", id+password+(new Date()));
		request.getRequestDispatcher("Welcome.jsp").forward(request, response);	// 그대로 이어서 보냄
	}

}
