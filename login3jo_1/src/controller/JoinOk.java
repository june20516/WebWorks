package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.Dao;
import model.dto.MemberDto;

public class JoinOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		MemberDto dto = new MemberDto(id, pw, name);

		response.setCharacterEncoding("UTF-8");
		Dao dao = Dao.getInstance();
		if (dao.confirmId(dto.getId())) {
			request.setAttribute("message", "�˸�â : ���̵� �̹� ���� �մϴ�. �ٽ� �����ϼ���.");
			request.getRequestDispatcher("join").forward(request, response);
		} else {
			if (dao.insertMember(dto)) {
				request.setAttribute("id", dto.getId());
				request.setAttribute("message", "�˸�â : ȸ�������� �����Ͽ����ϴ�.");
				request.getRequestDispatcher("login").forward(request, response);
			} else {
				request.setAttribute("message", "�˸�â : ȸ�������� ���� �Ͽ����ϴ�. �ٽ� �����ϼ���.");
				request.getRequestDispatcher("login").forward(request, response);
			}
		}
	}
}
