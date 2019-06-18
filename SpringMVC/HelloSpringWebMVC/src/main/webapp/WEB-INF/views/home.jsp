<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</P>
	<br>
	<form action="login.do" method="post">
		<label for="id">id</label> <input type="text" name="id" id="id" /><br>
		<label for="pw">pw</label> <input type="password" name="pw" id="pw"/>
		<input type="submit" value="로그인" />
	</form>

	<!-- 
<h2> User List </h2>

<table>
<thead>
<tr>
<th>id</th>
<th>name</th>
<th>email</th>
</tr>
</thead>
<tbody>
<c:forEach var="user" items="${userList }">
<tr>
<td>${user.id }</td>
<td>${user.name }</td>
<td>${user.email }</td>
</tr>
</c:forEach>
</tbody>
</table>
 -->
</body>
</html>
