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
					<td>��ȣ</td>
					<td>${contentView.bId}</td>
				</tr>
				<tr>
					<td>��ȸ��</td>
					<td>${contentView.bHit}</td>
				</tr>
				<tr>
					<td>�̸�</td>
					<td>${contentView.bName}</td>
				</tr>
				<tr>
					<td>����</td>
					<td><input type="text" name="bTitle" value="${contentView.bTitle}" style="width: 98%;"></td>
				</tr>
				<tr>
					<td>����</td>
					<td><textarea rows="10" name="bContent" style="width: 98%;">${contentView.bContent}</textarea></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="����">
						<a href="Delete.do?bId=${contentView.bId}" class="btn">����</a>
						<a href="ReplyView.do?bId=${contentView.bId}" class="btn">�亯</a>
						<a href="List.do" class="btn">��Ϻ���</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>