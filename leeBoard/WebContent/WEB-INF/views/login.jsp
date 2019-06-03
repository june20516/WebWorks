<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<link rel="stylesheet" href="resources/css/new.css">
<script type="text/javascript">
	$(function() {
		var sessionId = $('#sessionId').val();
		if (sessionId=="") {
			$('#logoutPart').hide();
		} else {
			$('#loginPart').hide();
		}
	});
</script>
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
		<a href="join" class="btn">ȸ������</a>
		<a href="List.do" class="btn">�Խ�������</a>
		</span>
		<span id="logoutPart">
		<a href="Logout.do" class="btn">�α׾ƿ�</a>
		<a href="List.do" class="btn">�Խ�������</a>
		</span>
	</form>
	</div>
	</body>
</html>