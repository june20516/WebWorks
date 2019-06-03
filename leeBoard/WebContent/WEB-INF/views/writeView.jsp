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
		<form action="Write.do" method="post">
			<table>
				<tr>
					<td>이름</td>
					<td>${sessionScope.id }</td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" name="bTitle" style="width: 98%;"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea name="bContent" rows="10" style="width: 98%;"></textarea></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="입력">
					<a href="List.do" class="btn">목록보기</a></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>