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
		<h1>${sessionScope.name }�� �ȳ��ϼ���.</h1>
		<a href="List.do" class="btn">�Խ�������</a>
		<a href="Logout.do" class="btn">�α׾ƿ�</a>
		<a href="modify" class="btn">ȸ����������</a>
	</div>
</body>
</html>