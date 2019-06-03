package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDAO;
import board.model.BoardDTO;
import board.model.CommentDTO;

/**
 * Servlet implementation class BListServlet
 */
public class BViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		int num = Integer.parseInt(request.getParameter("num"));
		
		System.out.println(num);
		BoardDAO dao = BoardDAO.instance;
		BoardDTO dto = dao.getView(num);
		BoardDTO dtop = dao.prev(num);
		BoardDTO dton = dao.next(num);
		
		request.setAttribute("dto", dto);
		request.setAttribute("dtop", dtop);
		request.setAttribute("dton", dton);
		
		
		
		List<CommentDTO> 댓글Dto=dao.댓글가져옴(num);//dto.getNum());
		
		request.setAttribute("reDto", 댓글Dto);
		
		request.getRequestDispatcher("views/board/view.jsp").forward(request, response);
		//response.sendRedirect("/views/board/view.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		
		
		
	}

}
