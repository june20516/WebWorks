<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>3조 게시판</title>
<style type="text/css">
.btn {
	display: inline-block;
	font-size: 14px;
	border: 1px solid #999;
	padding: 2px 5px;
	box-sizing: border-box;
	background: #f4f4f4;
	text-decoration: none;
	color: #000;
}
table {
  
  border-collapse: collapse;

}
table, th, td {
	font-family: arial, sans-serif;
  border: 1px solid black;
  border-collapse: collapse;
  
}
td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
</head>
<body>

	<div style="width: 500px; margin: 0 auto; text-align: center;">
		<c:if test="${sessionScope.id }==''||${sessionScope.id }==null">
		<jsp:forward page="login"></jsp:forward>
		</c:if>
		${message }<br> <br>
		<h1>${sessionScope.name }님안녕하세요.</h1>

		<a href="write" class="btn">글 쓰기</a>
		<table style="width:100%">
			<tr>
				<c:forEach items="${contentHeader }" var="col">
					<th>${col }</th>
				</c:forEach>
			</tr>
			<c:forEach items="${contents }" var="content">
				<tr>
					<td>${content.key }</td>
					<td class="contentTitle"><a href="Read?no=${content.key }">${content.value.title }</a></td>
					<td>${content.value.date }</td>
					<td>${content.value.name }</td>
				</tr>
			</c:forEach>
			</table>

		<form action="Logout.do" method="post">
			<input type="submit" value="로그아웃">&nbsp;<a href="modify"
				class="btn">회원정보수정</a>
		</form>
	</div>
</body>
</html>