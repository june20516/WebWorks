<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>login</title>
	<link rel="stylesheet" href="${path}/resources/css/reset.css">
	<link rel="stylesheet" href="${path}/resources/css/login.css">
	<script src="${path }/resources/js/jquery-1.9.1.js"></script>
	<script src="${path }/resources/js/jquery-ui.min.js"></script>
	<script src="${path }/resources/js/run.js"></script>
</head>
<body>
	<div class="login_wrap">
		<h1 class="l_top">LOGIN</h1>
		<form class="l_main" action="/boardProject/lc.do" method="post">
			<p><input type="text" value="11111111" id="id" class="login_focus" name="id" placeholder="아이디" autocomplete="off"/><span>아이디 입력</span></p>
			<p><input type="password" id="pw" value="1234123412" class="login_focus" name="pw" placeholder="비밀번호" autocomplete="off"/><span>비밀번호 입력</span></p>
			<input type="submit" value="LOG IN" class="btn">
		</form>
		<div class="l_bottom">
			<a href="${path}/views/signup/signup.jsp">회원가입</a>
		</div>
	</div>
</body>
</html>