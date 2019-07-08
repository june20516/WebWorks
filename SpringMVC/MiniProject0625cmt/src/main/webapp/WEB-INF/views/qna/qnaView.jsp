<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Q&A - ${qna.qTitle}</title>
</head>
<body>
	
	<h1 align="center">질문 게시판</h1>
	<h2>${qna.qTitle}</h2>
	<hr/>
	<p id="qnaProperty">
	<span id="writer">${qna.writer } </span>
	<span id="email">${qna.email } </span>
	<span id="qDate">${qna.qDate } </span>
	</p>
	<hr/>
	<p id="qnaContent">
	${qna.qContents}
	</p>
	<hr/>
	<input type="button" id="qnaCorrect" value="수정">
	<input type="button" id="qnaDelete" value="삭제">

</body>
</html>