<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage = "error view.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
</head>
<body>
		안녕하세요?
		<form action="abc.jsp" >
		<label for="id">아이디 : </label>
		<input name="id" type="text" value="아이디 입력"><br>
		<input type="submit">
		</form>
		<form action="abc.jsp" >
		<label for="id">예외처리 실험해보기 </label>
		<%=4 / 0 %>
		<input type="submit">
		</form>
</body>
</html>