package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDAO;
import board.model.BoardDTO;

/**
 * Servlet implementation class BListServlet
 */
public class BListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String opt=  request.getParameter("opt");
		String keywork=  request.getParameter("keywork");
		if(keywork==null) {
			keywork="";
		}else {
			keywork.trim();
		}
		List<BoardDTO> dtos = null;
		if(keywork.isEmpty()) {
		
		
		 dtos = BoardDAO.instance.getDTOAll();
		}else {
			dtos = BoardDAO.instance.getDTOAll(opt,keywork);
		}
		request.setAttribute("dtos", dtos);
		
	
		
		request.getRequestDispatcher("/views/board/list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		System.out.println(request.getParameter("opt"));
		System.out.println(request.getParameter("keywork"));
		
		
		
	}

}
