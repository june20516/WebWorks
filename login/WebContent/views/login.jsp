<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	${message}
	<form action="LoginOk.do" method="post">
		���̵� : <input type="text" name="id" value="<%if (session.getAttribute("id") != null)out.println(session.getAttribute("id"));%>"><br />
		��й�ȣ : <input type="password" name="pw"><br /> 
		<input type="submit" value="�α���">&nbsp;<input type="button" value="ȸ������" onclick='location="join"'>
	</form>
</body>
</html>