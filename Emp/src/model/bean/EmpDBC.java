package model.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpDBC {
	Connection conn = DBConnection.getConnection();
	PreparedStatement pSm;
	
	/**
	 * 
	 * @param emp
	 * @return is inserted 
	 */
	public boolean insertEmp(Employee emp) {
		//empNo, empName, job, deptName, deptNo, salary
		String sql = "insert into Emp4 values(?,?,?,?,?,?)";
		try {
			pSm = conn.prepareStatement(sql);
			pSm.setInt(1, emp.getEmpNo());
			pSm.setString(2, emp.getEmpName());
			pSm.setString(3, emp.getJob());
			pSm.setString(4, emp.getDeptName());
			pSm.setInt(5, emp.getDeptNo());
			pSm.setInt(6, emp.getSalary());
			
			pSm.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getLocalizedMessage());
			return false;
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean checkUsrInfo() {
		return false;
	}
	
	private ResultSet selectEmpData() {
		return null;
	}
}
