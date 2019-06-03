package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.Dao;

/**
 * Servlet implementation class Correct
 */
public class Correct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		String id = (String) session.getAttribute("id");
		if (id == null || id.equals("")) {
			response.sendRedirect("login");
		}
		Dao dao = Dao.getInstance();
		int no = Integer.parseInt(request.getParameter("crtNo"));
		String title = request.getParameter("title");
		String content = request.getParameter("text");
		if(dao.correctContent(title, content, no)) {
			response.getWriter().print("<script>alert('수정되었습니다');</script>");
			response.sendRedirect("Read?no="+no);
		}else {
			response.getWriter().print("<script>alert('! ERROR : 수정 실패!');</script>");
		}
	}

}
