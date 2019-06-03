

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import usrs.Member;

/**
 * Servlet implementation class MemberRegisterServlet
 */
public class MemberRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String birth = request.getParameter("birth");
		
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");	
		Member member = registMember(id,name,birth);
		request.setAttribute("usr", member);
//		request.setAttribute("usrName", member.getName());
		
		request.getRequestDispatcher("Welcome").forward(request, response);
	}
	
	protected Member registMember(String id, String name, String birth) {
		return new Member(id,name,birth);
	}

}
