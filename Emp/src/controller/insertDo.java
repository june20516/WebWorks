package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.EmpDBC;
import model.bean.Employee;

/**
 * Servlet implementation class insertDo
 */
@WebServlet("/insertDo")
public class insertDo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Employee emp;
	private EmpDBC empDBC = new EmpDBC(); 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertDo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String result = ""; 
		emp = new Employee(request.getParameter("empName"), request.getParameter("job"), request.getParameter("deptName"), Integer.parseInt(request.getParameter("salary")));
		if(empDBC.insertEmp(emp)) {
			result = "DB에 정상 입력 되었습니다.";
		} else {
			result = "DB 입력에 문제가 발생했습니다.";
		}
		
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		request.setAttribute("result", result);
		request.getRequestDispatcher("resultDone.jsp").forward(request, response);
	}

}
