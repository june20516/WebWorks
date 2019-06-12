package controller.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.BDao;
import model.dto.BDto;

public class BList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BDao dao = BDao.getInstance();
		String countParam = request.getParameter("pageCount");
		String pageNumParam = request.getParameter("pageNum");
		int pageCount = countParam==null ? 5 : Integer.parseInt(countParam);
		int pageNum = pageNumParam==null ? 1 : Integer.parseInt(pageNumParam);
		ArrayList<BDto> dtos = dao.list(pageCount, pageNum);
		request.setAttribute("totalCount", dao.totalCount());
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("list", dtos);
		request.getRequestDispatcher("list").forward(request, response);
	}
}

