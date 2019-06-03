package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.Dao;
import model.dto.Content;
import model.dto.ContentsDto;

/**
 * Servlet implementation class Read
 */
public class Read extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Read() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		String id = (String) session.getAttribute("id");
		if (id == null || id.equals("")) {
			response.sendRedirect("login");
		} else {
			List<String> header = ContentsDto.getHeader();
			Dao.getInstance().getContents();
			try {
				int contentNo = Integer.parseInt(request.getParameter("no"));
				Content content = ContentsDto.getContents().get(contentNo+"");
				session.setAttribute("contentHeader", header);
				session.setAttribute("content", content);
			} catch (NumberFormatException nfe) {
				nfe.getLocalizedMessage();
				request.setAttribute("message", "잘못된 접근");
			}
			request.getRequestDispatcher("read").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
