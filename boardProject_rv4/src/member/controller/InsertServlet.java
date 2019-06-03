package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.MemberDAO;


/**
 * Servlet implementation class InsertServlet
 */
public class InsertServlet extends HttpServlet {
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
      response.setCharacterEncoding("UTF-8");
      PrintWriter out = response.getWriter();
      MemberDAO dao = new MemberDAO();
      int i = dao.confirmId(request.getParameter("id"));
      System.out.println(i+" = i의 값입니다.");
      if(i == 1){
         System.out.println("회원가입 아이디 이미 존재");
         out.println("<script>alert('중복된 아이디 입니다.'); window.location.href='/boardProject/views/signup/signup.jsp' </script>");
      }else{
      if(i == 2){
         System.out.println("값 넣을 예정");
         String id = request.getParameter("id");
         String pw = request.getParameter("pw");
         String name = request.getParameter("name");
         String tel1 = request.getParameter("tel1");
         String tel2 = request.getParameter("tel2");
         String tel3 = request.getParameter("tel3");
         String birth1 = request.getParameter("birth1");
         String birth2 = request.getParameter("birth2");
         String birth3 = request.getParameter("birth3");
         String sex = request.getParameter("sex");
         String email = request.getParameter("email");
         
         dao.insertMember(id, pw, name, tel1, tel2, tel3, birth1, birth2, birth3, sex, email);
         System.out.println("가입 성공, 축하");
         out.println("<script>alert('회원가입을 축하합니다.'); window.location.href='/boardProject/views/login/login.jsp' </script>");
      }else{
         System.out.println("가입 실패");
         out.println("<script>alert('회원가입에 실패했습니다.'); window.location.href='/boardProject/views/signup/signup.jsp' </script>");
      }   
      
      
      
      
      }
   }
}