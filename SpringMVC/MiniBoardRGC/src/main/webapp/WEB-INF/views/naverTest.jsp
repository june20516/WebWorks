<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>naver test</title>
<script src="https://code.jquery.com/jquery-Latest.js"></script>
<script type="text/javascript"
	src="/resources/editor/js/HuskyEZCreator.js"></script>

<script type="text/javascript">
$(function() {
	
	var obj = [];
	nhn.husky.EZCreator.createInIFrame({
		oAppRef:obj,
		elPlaceHolder:"editor",
		sSkinURI:"./resources/editor/SmartEditor2Skin.html",
		htParams:{
			bUseToolbar : true,
			bUseMoseChanger:true,
			bUseVerticalResizer:true,
		}
	});
	
	$('#insertTest').click( function() {
		obj.getById["editor"].exec("UPDATE_CONTENTS_FIELD",[]);
		$('#insertTestForm').submit();
	});
	
	
});
</script>

</head>
<body>

	<form action="insertTest" id="insertTestForm" method="post"
		enctype="multipart/form-data">
		<textarea name="editor" id="editor" rows="100%" cols="100"></textarea>
		<br>
		<!-- <input type="file" multiple="multiple"><br> -->
		<input type="button" id="insertTest" value="등록">

	</form>
</body>
</html>