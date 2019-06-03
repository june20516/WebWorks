<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Create Employee Info </title>
</head>
<body>
	<!-- 번호, 이름, 직무, 부서코드, 근무부서, 연봉 -->
	<h1>사원 정보 입력</h1>
	<form action="insertDo" method="post">
	<!--
	<label for= "empNo">번호</label>
	<input type="text" name="empNo" />
	-->
	<label for= "empName">이름</label>
	<input type="text" name="empName" /><br>
	<label for= "job">직무</label>
	<input type="text" name="job" /><br>
	<label for= "deptName">근무부서</label>
	<select name="deptName">
	<option>총무부
	<option>영업부
	<option>개발부
	</select><br>
	<label for= "salary">연봉</label>
	<input type="text" name="salary" /><br>
	<h2>
	<input type="submit" value="사원 정보 생성" />
	</h2>
	</form>
</body>
</html>