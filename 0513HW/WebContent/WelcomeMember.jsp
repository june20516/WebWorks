
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="usrs.Member" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>
	<font size="5">
		<!-- ${usrName}님 안녕하세요. <br> -->
		<% Member a = (Member)request.getAttribute("usr");
		out.print(a.getName());
		%>님 안녕하세요.<br>
		
		생일은 <% out.print(a.getBirthByFormat());
		 %>이시네요.<br>
		 
		나이는 <% out.print(a.getAge()); %>입니다.
	</font>
</body>
</html>