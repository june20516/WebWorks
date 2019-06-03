<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회 원 가 입</title>
</head>
<body>
	<form action="memberRegist" method="post">
		<div>
			<label for="id">아 이 디</label><br> <input type="text" name="id" />
		</div>
		<div>
			<label for="name">이 름</label><br> <input type="text" name="name" />
		</div>
		<div>
			<label for="birth">생 년 월 일</label><br> <input type="date" name="birth" />
		</div>
		<div>
			<input type="submit" value="가 입" /><br>
		</div>
	</form>
</body>
</html>