<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/new.css">
</head>
<body>
	<input type="hidden" id="sessionId" value="${sessionScope.id}">
	<div>
		<p>${sessionScope.id}</p>
		${message }<br>
		<h1>${sessionScope.name }님 안녕하세요.</h1>
		<a href="List.do" class="btn">게시판으로</a>
		<a href="Logout.do" class="btn">로그아웃</a>
		<a href="modify" class="btn">회원정보수정</a>
	</div>
</body>
</html>