package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.MemberDao;
import model.dto.MemberDto;

public class LoginOk extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("EUC-KR");

		HttpSession session = request.getSession();

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		MemberDao dao = MemberDao.getInstance();
		int checkNum = dao.userCheck(id, pw);
		if (checkNum == -1) {
			System.out.println("아이디가 존재하지 않습니다.");
			//response.sendRedirect("login");
			request.setAttribute("temp", "아이디가 존재하지 않습니다.");
			request.getRequestDispatcher("login").forward(request, response);
		} else if (checkNum == 0) {
			System.out.println("비밀번호가 틀립니다.");
			//response.sendRedirect("login");
			request.setAttribute("temp", "비밀번호가 틀립니다.");
			request.getRequestDispatcher("login").forward(request, response);
		} else if (checkNum == 1) {
			MemberDto dto = dao.getMember(id);

			if (dto == null) {
				System.out.println("존재하지 않는 회원입니다.");
				//response.sendRedirect("login");
				request.setAttribute("temp", "존재하지 않는 회원입니다.");
				request.getRequestDispatcher("login").forward(request, response);
			} else {
				String name = dto.getName();
				session.setAttribute("id", id);
				session.setAttribute("name", name);
				session.setAttribute("ValidMem", "yes");
				response.sendRedirect("main");
			}
		}
	}
}