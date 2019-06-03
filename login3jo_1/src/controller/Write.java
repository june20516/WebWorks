package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.Dao;

/**
 * Servlet implementation class Write
 */
public class Write extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		String id = (String) session.getAttribute("id");
		if (id == null || id.equals("")) {
			response.sendRedirect("login");
		} else {
			Dao dao = Dao.getInstance();
			String title = request.getParameter("title");
			String content = request.getParameter("text");
			if (dao.wrightContent(title, content, id)) {
				response.getWriter().print("<script>alert('글이 등록되었습니다.');</script>");
				response.sendRedirect("Main");
			} else {
				response.getWriter().print("<script>alert('! ERROR : 등록 실패 !');</script>");
				response.sendRedirect("Main");
			}
			;

		}
	}
}
