<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<h1>allUser ..</h1>

	<table>
		<c:forEach var="user" items="${users }">
			<tr>
				<td>${user.name }</td>
				<td>${user.id }</td>
				<td>${user.email }</td>
				<td>${user.pw }</td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>