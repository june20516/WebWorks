<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>액션태그3</title>
</head>
<body>
	<jsp:useBean id="cust2" class="pojo.bean.Custom" scope="request"/>
	<jsp:setProperty property="name" name="cust2"/>
	<jsp:setProperty property="age" name="cust2"/>
	<jsp:forward page="intagresult.jsp"/>
</body>
</html>