<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>scope test result page</title>
</head>
<body>
	<%=request.getAttribute("key1") %><br>
	<%=pageContext.findAttribute("key1") %><br>
	<%=pageContext.findAttribute("key2") %><br>
	<%=pageContext.findAttribute("key3") %><br>
	${key }<br>
	${key2.month+1 }맞나?<br>
	${date.month+1 }맞나?<br>
	${list[0] }, ${list["0"] }<br>
	
	${map.cust1.name }는
	${map.cust1.age }살입니다
	
	<input type="text" disabled="disabled" value="${map.cust1.name }">
	
	<br>
	${pageContext.request.contextPath }
	
	
	
</body>
</html>