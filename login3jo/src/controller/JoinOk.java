package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.MemberDao;
import model.dto.MemberDto;

public class JoinOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("EUC-KR");
		HttpSession session = request.getSession();

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		MemberDto dto = new MemberDto(id, pw, name);

		response.setCharacterEncoding("EUC-KR");
		MemberDao dao = MemberDao.getInstance();
		if (dao.confirmId(dto.getId()) == MemberDao.MEMBER_EXISTENT) {
			System.out.println("���̵� �̹� ������, �ٽ� ȸ������â����");
			//response.sendRedirect("join");
			request.setAttribute("temp", "���̵� �̹� ���� �մϴ�.");
			request.getRequestDispatcher("login").forward(request, response);
		} else {
			int ri = dao.insertMember(dto);
			if (ri == MemberDao.MEMBER_JOIN_SUCCESS) {
				System.out.println("ȸ�����Լ���, �α���â����");
				session.setAttribute("id", dto.getId());
				//response.sendRedirect("login");
				request.setAttribute("temp", "ȸ�������� �����Ͽ����ϴ�.");
				request.getRequestDispatcher("login").forward(request, response);
			} else {
				System.out.println("ȸ�����Խ���. �α���â����");
				//response.sendRedirect("login");
				request.setAttribute("temp", "ȸ�������� ���� �Ͽ����ϴ�.");
				request.getRequestDispatcher("login").forward(request, response);
			}
		}
	}
}
