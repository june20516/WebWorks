<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<link rel="stylesheet" href="resources/css/new.css">
</head>
<body>
	<div>
	${message }<br>
	<form action="JoinOk.do" method="post" name="regForm">
		���̵� : <input type="text" name="id" size="20"><br>
		��й�ȣ : <input type="password" name="pw" size="20"><br>
		��й�ȣ Ȯ�� : <input type="password" name="pwCheck" size="20"><br>
		�̸� : <input type="text" name="name" size="20"><br>
		<input type="button" value="ȸ������" id="registerCheck">
		<input type="button" id="cancel1Btn" value="���">
	</form>
	</div>
<script type="text/javascript" src="resources/js/members.js" charset="UTF-8"></script>
</body>
</html>