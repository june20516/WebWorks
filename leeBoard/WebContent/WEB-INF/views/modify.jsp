<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="resources/js/members.js" charset="UTF-8"></script>
<link rel="stylesheet" href="resources/css/new.css">
</head>
<body>
	<div>
	${message }<br>
	<form action="ModifyOk.do" method="post" name="regForm">
		아이디 : ${sessionScope.id}<br/>
		비밀번호 : <input type="password" name="pw" size="20"><br>
		비밀번호 확인 : <input type="password" name="pwCheck" size="20"><br>
		이름 : <input type="text" name="name" size="20"><br>
		<input type="button" value="정보 수정" id="registerCheck2">
		<a href="main" class="btn">취소</a>
	</form>
	</div>
</body>
</html>