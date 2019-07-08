<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="loginProcess" method="post">
		<label for="nickName">Nickname </label><input type="text" name="nickName"
			value="${memberBean.nickName}" placeholder="아이디 입력~"><br> <label for="password">pw
		</label><input type="password" name="password" placeholder="비밀번호 입력~"><br>
		<input type="submit" value="로그인" />
	</form>

</body>
</html>