<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/members.js" charset="UTF-8"></script>
</head>
<body>
	${temp }
	<form action="ModifyOk.do" method="post" name="regForm">
		���̵� : ${id }<br />
		��й�ȣ : <input type="password" name="pw" size="20"><br/>
		��й�ȣ Ȯ�� : <input type="password" name="pwCheck" size="20"><br/>
		�̸� : <input type="text" name="name" size="20"><br/>
		<input type="button" value="����" onclick="updateInfoConfirm()">&nbsp;<input type="reset" value="���" onclick="location='main'">
	</form>
</body>
</html>