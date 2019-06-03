<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error view.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>abc</title>
</head>
<body>
	<%=request.getParameter("id") %><br>	//작동하지 않을 때는 null
	<% out.println(request.getParameter("id")); %>
	${param.id}	//작동하지 않았을 때는 빈칸
</body>
</html> 