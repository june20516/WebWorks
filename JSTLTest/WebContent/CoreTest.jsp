<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:out value="core tag c:out test"></c:out>
	<br>
	<c:out value="<%=20/5%>"></c:out>
	<br>
	<c:forEach items="${list}" var="aWord">
		${aWord}<br>
	</c:forEach>
	<br>/////////////////////////////
	<c:forEach items="${list}" var="name">
		${name }
		<c:if test="${name == '어렵고'}">
			있다
		</c:if>
		<c:if test="${name} == '어렵고'">
			있다
		</c:if>
	</c:forEach>




</body>
</html>