<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<!-- include libraries(jQuery, bootstrap) -->
<link
	href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script
	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>

<!-- include summernote css/js -->
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js">
	
</script>
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/lang/summernote-ko-KR.js"></script>
<!-- google web font -->
<link
	href="https://fonts.googleapis.com/css?family=Gamja+Flower|Noto+Serif+KR&display=swap"
	rel="stylesheet">

<script type="text/javascript" src="resources/script/qnaWriter.js"></script>

<style>
body {
  padding-top: 70px;
  padding-bottom: 30px;
}
</style>


<title>질문 올리기</title>
</head>
<body>
	<%@ include file="../content/contentHeader.jsp"%>
	<article>
		<div class="container" role="main">

			<form action="qnaRegister" role="form" method="post">
				<div class="mb-3">
					<input type="hidden" id="qNo" name="qNo" value="${qnABean.qNo }">
					<label for="member_id">글쓴이:</label> 
					<input type="text" class="form-control" name="member_id" value="${qnABean.member_id }">
				</div>
				<div class="mb-3">
				<label for="qTitle">제목:</label><input type="text" class="form-control" name="qTitle"
					value="${qnABean.qTitle }">
		</div>
		<div class="mb-3">
		<label for="qContents">내용:</label>
		<textarea name="qContents" class="form-control" id="summernote"><c:out
				value="${qnABean.qContents}" /></textarea>
				</div>
				<div class="mb-3">
				<label for="email">이메일:</label>
		 <input type="text" class="form-control" name="email"
			value="${qnABean.email }"> 
			</div>
			<div class="text-center">
			<input type="submit" class="btn btn-sm btn-primary" value="등록"
			id="go">
				</div>
		</form>
		</div>
	</article>
</body>
</html>