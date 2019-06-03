<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>scope test</title>
</head>
<body>
	Hello, ${list }<br>
	${param.k }, ${param.age }<br>
	<input type="text" value="${param.k + param.age}"><br>
	<input type="text" value="${param.k } + ${param.age}"><br>
	
	<%
		session.invalidate();
	%>
</body>
</html>