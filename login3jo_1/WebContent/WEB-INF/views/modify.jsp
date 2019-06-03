<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="resources/js/members.js" charset="UTF-8"></script>
<style type="text/css">
.btn{
	display: inline-block;
    font-size: 14px;
    border: 1px solid #999;
    padding: 2px 5px;
    box-sizing: border-box;
    background: #f4f4f4;
    text-decoration: none;
    color: #000;
	}
</style>
</head>
<body>
	<div style="width:500px; margin:0 auto; text-align:center;">
	${message }<br>
	<br>
	<form action="ModifyOk.do" method="post" name="regForm">
		아이디 : ${sessionScope.id }<br/>
		비밀번호 : <input type="password" name="pw" size="20"><br>
		비밀번호 확인 : <input type="password" name="pwCheck" size="20"><br>
		이름 : <input type="text" name="name" size="20"><br>
		<input type="button" value="정보 수정" id="registerCheck2">&nbsp;<a href="main" class="btn">취소</a>
	</form>
	</div>
</body>
</html>