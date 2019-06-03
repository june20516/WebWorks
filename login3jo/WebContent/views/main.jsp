<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%--<%
		if (session.getAttribute("ValidMem") == null) {
	%>
	<jsp:forward page="login" />   --%>
	<%  
		
		String name = (String) session.getAttribute("name");
		String id = (String) session.getAttribute("id");
	%>
	${temp }
	<h1>${name }님 안녕하세요</h1>
	<form action="Logout.do" method="post">
		<input type="submit" value="로그아웃">&nbsp;<input type="button" value="회원정보수정" onclick="location='modify'">
	</form>
</body>
</html>