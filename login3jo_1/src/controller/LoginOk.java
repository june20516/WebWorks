package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.Dao;
import model.dto.MemberDto;

public class LoginOk extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		Dao dao = Dao.getInstance();
		if (dao.userCheck(id, pw)) {
			MemberDto dto = dao.getMember(id);
			session.setAttribute("id", id);
			session.setAttribute("name", dto.getName());
			response.sendRedirect("Main");
		} else {
			request.setAttribute("message", "<script>alert('아이디 및 비밀번호를 확인해주세요');</script>");
			request.getRequestDispatcher("login").forward(request, response);
		}
	}
}