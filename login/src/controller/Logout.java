package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		System.out.println("로그아웃 되었습니다.");
		//response.sendRedirect("login");
		request.setAttribute("temp", "로그 아웃 되었습니다.");
		request.getRequestDispatcher("login").forward(request, response);
	}

}
