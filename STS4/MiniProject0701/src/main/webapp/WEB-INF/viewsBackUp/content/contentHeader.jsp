<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div id="menuBar">
	<a href="/?menu=1">동요</a> <a href="/?menu=2">동화</a> <a href="/?menu=3">TV프로그램</a><br>
	<a href="qnaList">qna게시판</a><br> <a href="login">로그인</a>&nbsp;&nbsp;<a
		href="logout">로그아웃</a>&nbsp;&nbsp;<a href="join">회원가입</a>
	<c:if test="${sessionScope.userLoginInfo.name!=null }" >
	<h5>${sessionScope.userLoginInfo.name}님,안녕하세요</h5>
	</c:if>
	
</div>
<hr />