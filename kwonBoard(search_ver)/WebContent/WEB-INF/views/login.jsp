<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<link rel="stylesheet" href="resources/css/new.css">
</head>
<body>
	<div>
	<p>${sessionScope.id }</p>
	${message}<br>
	<form action="LoginOk.do" method="post">
		<input type="hidden" id="sessionId" value="${sessionScope.id}">
		<span id="loginPart">
		���̵� : <input type="text" name="id" value="${requestScope.id}"><br>
		��й�ȣ : <input type="password" name="pw"><br>
		<input type="submit" value="�α���">
		<input type="button" id="joinUsBtn" value="ȸ������">
		<input type="button" id="listBtn" value="�Խ�������">
		</span>
		<span id="logoutPart">
		<input type="button" id="logoutBtn" value="�α׾ƿ�">
		<input type="button" id="list2Btn" value="�Խ�������">
		</span>
	</form>
	</div>
<script type="text/javascript" src="resources/js/members.js" charset="UTF-8"></script>
</body>
</html>