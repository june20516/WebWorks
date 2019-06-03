package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.MemberDAO;
import member.model.MemberDTO;

/**
 * Servlet implementation class LoginCheckServlet
 */
public class LoginCheckServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      response.getWriter().append("Served at: ").append(request.getContextPath());
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("UTF-8");
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out= response.getWriter();
      
      
      System.out.println("lc ");
      HttpSession session = request.getSession();
      
      String id = request.getParameter("id");
      String pw = request.getParameter("pw");
      session.setAttribute("id", id);

      System.out.println(request.getParameter("pw"));
      System.out.println(pw);
      MemberDAO dao = new MemberDAO();
      int checkNum = dao.userCheck(id, pw);
      if(checkNum == -1){
         out.println("<script>alert('아이디가 존재하지 않습니다.'); window.location.href='/boardProject/views/login/login.jsp' </script>");
         System.out.println("아이디가 존재하지 않습니다..");
      }else if(checkNum == 0){
         out.println("<script>alert('비밀번호가 일치하지 않습니다.'); window.location.href='/boardProject//views/login/login.jsp'</script>");
         System.out.println("비밀번호가 일치하지 않습니다.");
      }else if(checkNum == 1){
         MemberDTO dto = dao.getMember(id);
         
         if(dto == null){
      } else {
      response.sendRedirect("index.jsp");
         }
      }
   }
}