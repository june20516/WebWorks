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
	<h1>${name }�� �ȳ��ϼ���</h1>
	<form action="Logout.do" method="post">
		<input type="submit" value="�α׾ƿ�">&nbsp;<input type="button" value="ȸ����������" onclick="location='modify'">
	</form>
</body>
</html>