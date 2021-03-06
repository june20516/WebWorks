package controller;

import java.io.IOException;
import java.util.HashMap;
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
 * Servlet implementation class Main
 */
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Main() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		String id = (String)session.getAttribute("id");
		if(id == null || id.equals("") ) {
			response.sendRedirect("login");
		}else {
		List<String> header = ContentsDto.getHeader();
		Dao.getInstance().getContents();
		HashMap<String,Content> contents = ContentsDto.getContents();
		session.setAttribute("contentHeader", header);
		session.setAttribute("contents", contents);
		request.getRequestDispatcher("main").forward(request, response);
		}
	}
}

