<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>request.getParameter()test.jsp</title>
</head>
<body>
<font size="5">
입력하신 Id는 <%=request.getParameter("id") %>이고 <br></br>
암호는 <%=request.getParameter("password") %>입니다. 
</font>
<br>ELtag로 확인해보기<br>
아이디 : ${id} ${param.id }<br>
암호 : ${password} ${param.password }<br>

</body>
</html>