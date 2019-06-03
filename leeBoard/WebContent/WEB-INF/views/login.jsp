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
		아이디 : <input type="text" name="id" value="${requestScope.id}"><br>
		비밀번호 : <input type="password" name="pw"><br>
		<input type="submit" value="로그인">
		<a href="join" class="btn">회원가입</a>
		<a href="List.do" class="btn">게시판으로</a>
		</span>
		<span id="logoutPart">
		<a href="Logout.do" class="btn">로그아웃</a>
		<a href="List.do" class="btn">게시판으로</a>
		</span>
	</form>
	</div>
	</body>
</html>