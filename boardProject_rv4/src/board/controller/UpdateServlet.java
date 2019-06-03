package board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDAO;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      request.setCharacterEncoding("UTF-8");

      BoardDAO dao = BoardDAO.instance;
      String title = request.getParameter("title");
      String content = request.getParameter("content");
      int num = Integer.parseInt(request.getParameter("num"));

      dao.update(title, content, num);
      System.out.println(num);
      System.out.println(title);
      System.out.println(content);
   
      
      request.getRequestDispatcher("index.jsp").forward(request, response);
   }


}