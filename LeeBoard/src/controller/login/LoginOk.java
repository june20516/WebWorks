package controller.login;

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
		if (dao.userCheck(id, pw)) {
			MemberDto dto = dao.getMember(id);

			if (dto == null) {
				request.setAttribute("message", "�˸�â : �������� �ʴ� ȸ���Դϴ�.");
				request.getRequestDispatcher("login").forward(request, response);
			} else {
				session.setAttribute("id", id);
				session.setAttribute("name", dto.getName());
				response.sendRedirect("main");
			}
		} else {
			request.setAttribute("message", "�˸�â : �߸� �Է��Ͽ��ų� ȸ���� �ƴմϴ�.");
			request.getRequestDispatcher("login").forward(request, response);
		}
	}
}