package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDAO;


/**
 * Servlet implementation class BdeleteServlet
 */
public class BdeleteServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doAction(request, response);
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doAction(request, response);
   
   }
   protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
   
      request.setCharacterEncoding("UTF-8");
      
      response.setContentType("text/html; charset=UTF-8");
      response.setCharacterEncoding("UTF-8");
      
      int num = Integer.parseInt(request.getParameter("num"));
      System.out.println("서블릿:"+num);
      
      BoardDAO dao = BoardDAO.instance;

      dao.delete(num);
      System.out.println("del");
      response.sendRedirect("index.jsp");
      
   }
   
}