<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/new.css">
</head>
<body>
	<div>
	<form action="Search.do" method="post">
		<select name="opt">
			<option value="bTitle">����</option>
			<option value="bContent">����</option>
			<option value="bName">�ۼ���</option>
		</select>
		<input type="text" name="keywork">
		<input type="submit" value="�˻�">
	</form>
	</div>
</body>
</html>