<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Q&A</title>
<link rel="stylesheet" href="resources/boardboot/css/bootstrap.css">

<script src="http://code.jquery.com/jquery-Latest.js"></script>
<script type="text/javascript">
	$(function() {
		$('#qnaRegister').click(function() {
			location.href = "qnaWriter"
		})
	});
</script>
</head>
<body>
	<%@ include file="../content/contentHeader.jsp"%>
	<div class="container">
		<table class="table table-hover">
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>글쓴이</th>
				<th>날짜</th>
			</tr>
			<c:forEach var="qna" items="${qnaList}">
				<tr>
					<td>${qna.qNo}</td>
					<td><a href="/qnaView?qNo=${qna.qNo}">${qna.qTitle}</a></td>
					<td>${qna.member_id}</td>
					<td>${qna.qDate}</td>
				</tr>
			</c:forEach>
		</table>
	<div class="text-right">
		<input type="button" class="btn btn-primary btn-sm"
			id="qnaRegister" value="질문하기"><br> 
			</div>
			<div class="text-center">
			<label
			for="qnaSearchText"> 검 색 </label> <input type="text" name="qnaSearch"
			id="qnaSearchText"> <input type="button"
			class="btn btn-primary btn-sm" id="qnaSearchBtn" value="찾기">
	</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="resources/boardboot/js/bootstrap.js"></script>
</body>
</html>