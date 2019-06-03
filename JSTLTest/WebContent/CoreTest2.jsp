<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="true">
		true일 때
		</c:if>
	<c:if test="false">
		false일 때
		</c:if><br>
	<c:if test="${4<7}" var="fourVsSeven1">
		4<7은 true<br>
		</c:if><br>
	<c:if test="${4>7}" var="fourVsSeven2">
		4>7은 false<br>
		</c:if>
		첫번째 test 결과 ${fourVsSeven1}<br>
		두번째 test 결과 ${fourVsSeven2}<br>
		
		<c:forEach items="${list}" var="aWord">
		<c:choose>
			<c:when test="${aWord=='어렵고'}">
			어렵다
			</c:when>
			<c:when test="${aWord=='빠릅니다'}">
			빠르다
			</c:when>
			<c:otherwise>
			에휴
			</c:otherwise>
	</c:choose>
	</c:forEach>
</body>
</html>