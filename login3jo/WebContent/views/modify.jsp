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
		아이디 : ${id }<br />
		비밀번호 : <input type="password" name="pw" size="20"><br/>
		비밀번호 확인 : <input type="password" name="pwCheck" size="20"><br/>
		이름 : <input type="text" name="name" size="20"><br/>
		<input type="button" value="수정" onclick="updateInfoConfirm()">&nbsp;<input type="reset" value="취소" onclick="location='main'">
	</form>
</body>
</html>