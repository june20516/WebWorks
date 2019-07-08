<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<%@ include file="../commonHeader.jsp" %>

<!-- include libraries(jQuery, bootstrap) -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

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

<!-- CSS -->

<!-- Custom styles for this template -->
<link href="css/juniornaver-homepage.css" rel="stylesheet">

<title>질문 올리기</title>
</head>
<body>
<%@include file="../commonNav.jsp"  %>

	<form action="qnaRegister" method="post">
		<input type="hidden" id="qNo" name="qNo" value="${qnABean.qNo }">
		글쓴이:<input type="text" name="member_id" value="${qnABean.member_id }"><br>
		<label for="qTitle">제목:</label><input type="text" name="qTitle"
			value="${qnABean.qTitle }"><br> <label for="qContents">내용:</label>
		<textarea  name="qContents" id="summernote"><c:out value="${qnABean.qContents }" /></textarea>
		<br> 이메일:<input type="text" name="email" value="${qnABean.email }"> 
		<input type="submit" value="등록" id="go">
	</form>

</body>
</html>