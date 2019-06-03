<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정하기</title>
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

#crtTitle {
width: 1000px;
	font-family: sans-serif;
	font-size: small;
}
</style>
</head>
<body>
<script type="text/javascript">
	$(function(){ 
		$("#smContent").click(function(){
			  $("#title").val(
				$("#crtTitle").val()  
			  );
			  $("#text").val(
				$("#crtText").val()
			  );
		  })
	});
</script>
<c:if test="${sessionScope.id }!=${param.writerId }">
		<script>alert('본인이 작성한 게시글만 수정 가능합니다');</script>
		<jsp:forward page="Read?no=${param.ctnNo }"></jsp:forward>
	</c:if>



<h2>글 수정</h2>
<table style="width:90%">
<tr>
<th><label for="crtTitle">제&nbsp;목</label></th>
<th><input type="text" name="crtTitle" id="crtTitle" value="${param.existingTitle }" /></th>
</tr>
<tr>
<td colspan="2"><label for="crtText">내&nbsp;&nbsp;용</label></td>
</tr>
<tr>
<td colspan="2">
<textarea id="crtText" rows="30" cols="120"  >${param.existingText }</textarea>
</td>
</tr>
</table>

<form action=Correct.do method="post"> 
<input type="hidden" name="title" id="title" />
<input type="hidden" name="text" id="text" />
<input type="hidden" name="crtNo" id="crtNo" value="${param.ctnNo }")/>
<input type="submit" id="smContent" value="수정" />
</form>
<a href="Main" class="btn">목록으로</a>

</body>
</html>

