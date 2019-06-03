<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	${message }
	<h1>${name }님 안녕하세요</h1>
	
	<!-- 테이블이 들어갈 p를 만든다
	테이블 헤더를 만든다
	DAO에서 값을 가져온다
	배열에 넣기
	서블릿에서	P에 뿌리기
	-->
	
	<p id="mainTable"></p>
	
	<form action="Logout.do" method="post">
		<input type="submit" value="로그아웃">&nbsp;
		<input type="button" value="회원정보수정" onclick="location='modify'">
	</form>
</body>
</html>