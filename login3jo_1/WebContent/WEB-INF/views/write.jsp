<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 쓰기</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<style type="text/css">
.btn {
	display: inline-block;
	font-size: 14px;
	border: 1px solid #999;
	padding: 2px 5px;
	box-sizing: border-box;
	background: #f4f4f4;
	text-decoration: none;
	color: #000;
}
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
  text-align: center; 
}

tr:nth-child(even) {
  background-color: #dddddd;
}

textarea {
	background-color: powderblue;
	font-family: sans-serif;
	font-size: medium;
	
}

#wrTitle {
width: 1000px;
	font-family: sans-serif;
	font-size: small;
}
</style>
</head>
<body>
<script type="text/javascript">
$(function(){ 
	$("#wrTitle").click(function(){
		$(this).val("");
	})
	$("#wrText").click(function(){
		$(this).text("");
	})
	
	  $("#smContent").click(function(){
		  $("#title").val(
			$("#wrTitle").val()		  
		  );
		  $("#text").val(
			$("#wrText").val()		  
		  );
	  })
});
</script>




<h2>글 쓰기</h2>
<table style="width:90%">
<tr>
<th><label for="wrTitle">제&nbsp;목</label></th>
<th><input type="text" name="wrTitle" id="wrTitle" value="제목을 입력하세요" /></th>
</tr>
<tr>
<td colspan="2"><label for="wrText">내&nbsp;&nbsp;용</label></td>
</tr>
<tr>
<td colspan="2">
<textarea name="wrText" id="wrText" rows="30" cols="120"  >내용을 입력하세요</textarea>
</td>
</tr>
</table>

<form action=Write.do method="post"> 
<input type="hidden" name="title" id="title" />
<input type="hidden" name="text" id="text" />
<input type="submit" id="smContent" value="등록" />
</form>
<a href="Main" class="btn">목록으로</a>
</body>
</html>

