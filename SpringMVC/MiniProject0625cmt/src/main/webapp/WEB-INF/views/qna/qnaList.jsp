<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Q&A</title>
</head>
<body>
	<h1 align="center">질문 게시판</h1>
	<hr />
	<table border="1">
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>글쓴이</th>
			<th>날짜</th>
		</tr>
		<c:forEach var="qna" items="${qnas }">
			<tr>
				<td>${qna.qNo}</td>
				<td><a href="/qnaView?qNo=${qna.qNo}">${qna.qTitle}</a></td>
				<td>${qna.writer}</td>
				<td>${qna.qDate}</td>
			</tr>
		</c:forEach>
	</table>
	<input type="button" id="qnaWrite" value="질문하기">
	<label for="qnaSearchText"> 검 색 </label>
	<input type="text" name="qnaSearch" id="qnaSearchText">
	<input type="button" id="qnaSearchBtn" value="찾기">
</body>
</html>