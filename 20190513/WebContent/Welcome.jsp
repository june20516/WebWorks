<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>
	<%=request.getParameter("id") %>님 안녕하세요. <br>
	${param.id }님 안녕하세요. <br>
	${id }님
</body>
</html>