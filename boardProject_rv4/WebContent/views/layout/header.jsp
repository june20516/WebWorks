<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:set var="path" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no" />
<title>2조 게시판</title>
<link rel="stylesheet" href="${path}/resources/css/reset.css" />
<link rel="stylesheet" href="${path}/resources/css/common.css" />
<link rel="stylesheet" href="${path}/resources/css/sub.css" />
<script src="${path }/resources/js/jquery-1.9.1.js"></script>
<script src="${path }/resources/js/jquery-ui.min.js"></script>
<script src="${path }/resources/js/run.js"></script>
</head>
<body>
	<div class="wrap">
		
	<div class="header">
		<div class="header_inner">
			<c:choose>
				<c:when test="${id == null}">
					<a href="${path}/views/login/login.jsp" class="btn">로그인</a>
					<a href="${path}/views/signup/signup.jsp" class="btn">회원가입</a>
				</c:when>
				<c:otherwise>
					<a href="#" class="user"><span>${id }</span>님 환영합니다.</a>
					<a href="${path}/logout.do" class="btn">로그아웃</a>
				</c:otherwise>
			</c:choose>
		</div>
	</div><!-- //header -->
