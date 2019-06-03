package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.BDao;

public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		String bId = request.getParameter("bId");
		BDao dao = BDao.getInstance();
		String bName = dao.contentView(bId).getbName();
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		if(id==null||!(bName.equals(id))) {
			request.setAttribute("message","�˸�â : �α����� ���� �ʾҰų� ���̵� �޶� �ۻ����� ���� ���Ͽ����ϴ�.");
			request.getRequestDispatcher("login").forward(request, response);
			return;
		}
		dao.delete(bId);
		request.getRequestDispatcher("BList.do").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
