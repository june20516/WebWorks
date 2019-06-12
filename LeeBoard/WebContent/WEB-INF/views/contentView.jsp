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
		${sessionScope.id }
		<form id="contentViewForm" action="Modify.do" method="post">
			<input type="hidden" id="sessionId" value="${sessionScope.id}">
			<input type="hidden" name="bId" value="${contentView.bId}"> 
			<input type="hidden" name="bName" value="${contentView.bName}">
			<table>
				<tr>
					<td>번호</td>
					<td>${contentView.bId}</td>
				</tr>
				<tr>
					<td>조회수</td>
					<td>${contentView.bHit}</td>
				</tr>
				<tr>
					<td>이름</td>
					<td>${contentView.bName}</td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" name="bTitle" value="${contentView.bTitle}" style="width: 98%;"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea rows="10" name="bContent" style="width: 98%;">${contentView.bContent}</textarea></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="수정">
						<a href="Delete.do?bId=${contentView.bId}" class="btn">삭제</a>
						<a href="ReplyView.do?bId=${contentView.bId}" class="btn">답변</a>
						<a href="List.do" class="btn">목록보기</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>