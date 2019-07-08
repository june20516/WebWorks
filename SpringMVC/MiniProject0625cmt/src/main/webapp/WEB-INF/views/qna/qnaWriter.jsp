
김진광
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
	href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.js"></script>

<script>
	$(function() {
		$("#summernote").summernote({
			fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New','굴림','고딕'],
			fontNamesIgnoreCheck: ['굴림','고딕']
		});
	});
</script>



<title>Insert title here</title>
</head>
<body>

	<form action="qnaWrite">
		글쓴이:<input type="text" name="writer"><br> 제목:<input
			type="text" name="qTitle"><br> 내용:
		<textarea name="qContents" id="summernote"></textarea>
		<br> 이메일:<input type="text" name="email"> 어:<input
			type="text" name="qAttachments"><br> <input
			type="submit" value="등록">
	</form>

	<button></button>
</body>
</html>