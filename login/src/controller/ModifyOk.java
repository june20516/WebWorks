package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.Dao;
import model.dto.MemberDto;

public class ModifyOk extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("EUC-KR");
		HttpSession session = request.getSession();

		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		session.setAttribute("name", name);
		MemberDto dto = new MemberDto(pw, name);

		String id = (String)session.getAttribute("id");
		dto.setId(id);
		Dao dao = Dao.getInstance();
		int ri = dao.updateMember(dto);

		if (ri == 1) {
			System.out.println("������ �����Ǿ����ϴ�.");
			request.setAttribute("temp", "������ �����Ǿ����ϴ�.");
			//response.sendRedirect("main");
			request.getRequestDispatcher("main").forward(request, response);
		} else {
			System.out.println("������������");
			request.setAttribute("temp", "���� ���� ���� �Ͽ����ϴ�.");
			//response.sendRedirect("modify");
			request.getRequestDispatcher("modify").forward(request, response);
		}
	}
}
