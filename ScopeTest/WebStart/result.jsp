<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>scope test result page</title>
</head>
<body>
	<%=request.getAttribute("key1") %><br>
	<%=pageContext.findAttribute("key1") %><br>
	<%=pageContext.findAttribute("key2") %><br>
	<%=pageContext.findAttribute("key3") %><br>
	<%=application.getAttribute("key3") %><br>
	${key1 }<br>
	${key2 }<br>
	${key3 }<br>
	
</body>
</html>