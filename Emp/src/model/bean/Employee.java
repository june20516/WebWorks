package model.bean;

public class Employee {
	private static int count = 0;
	private int empNo;
	private String empName;
	private String job;
	private String deptName;
	private int deptNo;
	private int salary;

	public Employee(String empName, String job, String deptName, int salary) {
		setEmpNo();
		this.empName = empName;
		this.job = job;
		this.deptName = deptName;
		setDeptNo();
		this.salary = salary;
	}
	
	public int getEmpNo() {
		return empNo;
	}
	
	public void setEmpNo() {
		count++;
		this.empNo = count;
	}
	
	public String getEmpName() {
		return empName;
	}
	
	public String getJob() {
		return job;
	}
	
	public String getDeptName() {
		return deptName;
	}
	
	public int getDeptNo() {
		return deptNo;
	}
	
	public void setDeptNo() {
		this.deptNo = Dept.valueOf(this.deptName).deptNo; 
	}
	
	public int getSalary() {
		return salary;
	}
	
	
}

enum Dept {
	총무부(10), 영업부(20), 개발부(30);
	
	int deptNo;
	
	private Dept(int no) {
		this.deptNo = no;
	}
}
