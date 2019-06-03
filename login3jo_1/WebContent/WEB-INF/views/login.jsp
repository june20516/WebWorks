<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.btn{
	display: inline-block;
    font-size: 14px;
    border: 1px solid #999;
    padding: 2px 5px;
    box-sizing: border-box;
    background: #f4f4f4;
    text-decoration: none;
    color: #000;
	}
</style>
</head>
<body>
	<div style="width:500px; margin:0 auto; text-align:center;">
	${message}<br>
	<br>
	<form action="LoginOk.do" method="post">
		아이디 : <input type="text" name="id" value="${requestScope.id}"><br>
		비밀번호 : <input type="password" name="pw"><br>
		<input type="submit" value="로그인">&nbsp;<a href="join" class="btn">회원가입</a>
	</form>
	</div>
	</body>
</html>