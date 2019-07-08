<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
	href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/lang/summernote-ko-KR.js"></script><!-- google web font -->
<!-- google web font -->	
<link
	href="https://fonts.googleapis.com/css?family=Gamja+Flower|Noto+Serif+KR&display=swap"
	rel="stylesheet">

<script>
	$(function() {
		$("#summernote").summernote(
				{	//툴바 세팅
					toolbar: [
					    ['style', ['bold', 'italic', 'underline', 'clear']],
					    ['fontname',['fontname']],
					    ['font', ['strikethrough', 'superscript', 'subscript']],
					    ['fontsize', ['fontsize']],
					    ['color', ['color']],
					    ['para', ['ul', 'ol', 'paragraph']],
					    ['insert', ['link', 'picture', 'video']],
					    ['view', ['help']]
					  ],
					lang : 'ko-KR',
					fontNames : [ 'Nanum Gothic', 'Nanum Myeongjo',
							'Gamja Flower', 'Noto Serif KR' ],
					fontNamesIgnoreCheck : [ 'Gamja Flower', 'Noto Serif KR' ],
					placeholder : '질문을 입력하세요..',
					callbacks: {
						onImageUpload: function(files, editor, welEditable) {
				            for (var i = files.length - 1; i >= 0; i--) {
				            	sendFile(files[i], this);
				            }
				        }
					}
		});
		
		//질문하기 버튼으로 진입했을 때, qNo가 없는 경우 0으로 생성하여 submit해주기
		$("#go").click(function() {
			if (!$("#qNo").val()) {
				$("#qNo").val("0");
			}
		})
	});
	
	function sendFile(file, el) {
		var form_data = new FormData();
      	form_data.append('file', file);
      	$.ajax({
        	data: form_data,
        	type: "POST",
        	url: 'image',
        	cache: false,
        	contentType: false,
        	enctype: 'multipart/form-data',
        	processData: false,
        	success: function(img_name) {
          		$(el).summernote('editor.insertImage', img_name);
        	}
      	});
    }
	
</script>



<title>Insert title here</title>
</head>
<body>

	<form action="qnaRegister" method="post">
		<input type="hidden" id="qNo" name="qNo" value="${qnABean.qNo }">
		글쓴이:<input type="text" name="member_id" value="${qnABean.member_id }"><br>
		<label for="qTitle">제목:</label><input type="text" name="qTitle"
			value="${qnABean.qTitle }"><br> <label for="qContents">내용:</label>
		<textarea name="qContents" id="summernote">${qnABean.qContents }</textarea>
		<br> 이메일:<input type="text" name="email" value="${qnABean.email }"> 
		<input type="submit" value="등록" id="go">
	</form>

</body>
</html>