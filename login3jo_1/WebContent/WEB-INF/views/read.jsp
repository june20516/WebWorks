<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>3조 게시판 - ${content.title }</title>
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
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
</head>
<body>
${message}
<script type="text/javascript">
$(function(){
	
	if($('#writerId').val()!=$('#sessionId').val()){
		$('#ctnCorrectBtn').hide();
		$('#ctnDeleteBtn').hide();
	}
	
	$('#ctnCorrectBtn').click(function(){
		$('#existingTitle').val(
				$('#ctnTitle').text()
		);
		$('#existingText').val(
				$('#ctnText').text()
		);
	});
	
    $('#ctnDeleteBtn').click(function(){
    	 if (confirm("정말 삭제하시겠습니까?")) {
       location.href = 'Delete.do?no='+$("#ctnNo").text()+'&writerId='+$("#writerId").val();
    		  }
    });
    
    $('#mainBtn').click(function(){
       location.href = 'Main';
    });
});
</script>
		<table style="width:100%">
			<tr>
				<c:forEach items="${contentHeader }" var="col">
					<th>${col }</th>
				</c:forEach>
			</tr>
				<tr>
					<td id="ctnNo">${content.no }</td>
					<td id="ctnTitle">${content.title }</td>
					<td id="ctnDate">${content.date }</td>
					<td id="ctnName">${content.name }</td>
				</tr>
			<tr>
					<td colspan=4>내&nbsp;&nbsp;&nbsp;&nbsp;용</td>
				</tr>
				<tr>
					<td id="ctnText" colspan=4><pre>${content.text }</pre></td>
				</tr>
			</table>
			<form action="correct" method="post">
			<input type="hidden" name="existingTitle" id="existingTitle" value="">
			<input type="hidden" name="existingText" id="existingText" value="">
			<input type="hidden" name="ctnNo" id="ctnNo" value="${content.no }">
			<input type="hidden" name="writerId" id="writerId" value="${content.id }">
			<input type="hidden" name="sessionId" id="sessionId" value="${sessionScope.id }">
			<input type="submit" id="ctnCorrectBtn" value="수정"/>
		</form>
			<button id="ctnDeleteBtn">삭제</button>
			<button id="mainBtn">목록으로</button>


</body>
</html>