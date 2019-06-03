package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.Dao;

/**
 * Servlet implementation class Delete
 */
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String id = (String) session.getAttribute("id");
		if (id == null || id.equals("")) {
			response.sendRedirect("login");
		}
		String writer = request.getParameter("writerId");
		System.out.println("글쓴이 : " +writer);
		System.out.println("세션 아이디 : " + id);
		if (id.equals( writer)) {
			int contentNo = Integer.parseInt(request.getParameter("no"));
			System.out.println("글번호 : " +contentNo);
			Dao dao = Dao.getInstance();
			dao.deleteContent(contentNo);
			request.setAttribute("message", "<script>alert('삭제되었습니다');</script>");
		}else {
			request.setAttribute("message", "<script>alert('권한 없음');</script>");
		}
		response.sendRedirect("Main");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
