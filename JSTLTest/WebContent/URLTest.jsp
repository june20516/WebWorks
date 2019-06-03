<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
		Date today = new Date();
	pageContext.setAttribute("today", today);
	%>
	
	<c:url value="http://www.naver.com" var="naverURL"/>
	naver : <a href="${naverURL }">이동</a><br><br>
	naver : <a href=http://www.naver.com>a태그형식</a>
	
	
	<c:url var="next" value="urlTestResult.jsp">
		<c:param name="someURL" value="URLTest.jsp"/>
		<c:param name="today" value="${today }"/>
		</c:url>
	<br><br>
	next로 가기 : <a href="${next}">이동 ~ </a>
	
	
	
	
</body>
</html>