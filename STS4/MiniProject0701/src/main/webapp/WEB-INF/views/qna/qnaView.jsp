<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../commonHeader.jsp"  %>
<meta charset="UTF-8">
<title>Q&A - ${qna.qTitle}</title>
<script src="http://code.jquery.com/jquery-Latest.js"></script>
<!-- include libraries(jQuery, bootstrap) -->

<script
	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>

<!-- include summernote css/js -->
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Gamja+Flower|Noto+Serif+KR&display=swap"
	rel="stylesheet">

<script type="text/javascript">


$(function() {
	$("#qnaCorrect").click(function() {
		document.form1.action = "/qnaUp"
		document.form1.submit();
	})
});
$(function() {
	$("#qnaDelete").click(function() {
		if(confirm("삭제하시겠습니까?")){
			document.form1.action = "/qnaDelete"
			document.form1.submit();
		}
	})
});
</script>
<style type="text/css">
	input{
	background-color: transparent;
	border: 0 solid black; 
	text-align: center; 
	outline: none;
	font-size: 20px;
	}
</style>
</head>
<body>
	<%@include file="../commonNav.jsp"  %>
	
	<form name="form1" method="post">
	<h2>${qna.qTitle}</h2>
	<hr/>
	<p id="qnaProperty">
	<input type="hidden" name="qNo" value="${qna.qNo }"> 
	<input type="text" readonly="readonly" name="member_id" value="${qna.member_id }">
	<input type="text" readonly="readonly" name="qTitle" id="qTitle" value="${qna.qTitle }">
	<input type="text" readonly="readonly" name="email" id="email" value="${qna.email }"> 
	<input type="text" readonly="readonly" name="qDate" id="qDate" value="${qna.qDate }">
	</p>
	<hr/>
	<textarea hidden="hidden" name="qContents" id="qContents">${qna.qContents }</textarea>
	<p>${qna.qContents }</p>
	<hr/>
	<button id="qnaCorrect">수정</button>
	<button id="qnaDelete">삭제</button>
	</form>
</body>
</html>