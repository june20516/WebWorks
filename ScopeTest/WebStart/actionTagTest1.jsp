<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>액션태그 테스트 페이지</title>
</head>
<body>
	여기는 뭔가?
	<jsp:forward page="index.jsp">
		<jsp:param value="123" name="k"/>
		<jsp:param value="${12+90 }" name="age"/>
	</jsp:forward>
</body>
</html>