<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%--<%
		if (session.getAttribute("ValidMem") != null) {
	%>
	<script>
		alert("로그인 되어있습니다.");
		history.back();
	</script>
	<%
		}
	%>     --%>
	${temp}
	<form action="LoginOk.do" method="post">
		아이디 : <input type="text" name="id" value="<%if (session.getAttribute("id") != null)out.println(session.getAttribute("id"));%>"><br />
		비밀번호 : <input type="password" name="pw"><br /> 
		<input type="submit" value="로그인">&nbsp;<input type="button" value="회원가입" onclick='location="join"'>
	</form>
</body>
</html>