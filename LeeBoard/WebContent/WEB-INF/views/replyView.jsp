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
		<form action="Reply.do" method="post">
			<input type="hidden" name="bId" value="${replyView.bId}"> 
			<input type="hidden" name="bName" value="${replyView.bName}"> 
			<input type="hidden" name="bGroup" value="${replyView.bGroup}"> 
			<input type="hidden" name="bStep" value="${replyView.bStep}"> 
			<input type="hidden" name="bIndent" value="${replyView.bIndent}">
			<table>
				<tr>
					<td>��ȣ</td>
					<td>${replyView.bId}</td>
				</tr>
				<tr>
					<td>��ȸ��</td>
					<td>${replyView.bHit}</td>
				</tr>
				<tr>
					<td>�̸�</td>
					<td>${replyView.bName}</td>
				</tr>
				<tr>
					<td>����</td>
					<td><input type="text" name="bTitle"
						value="${replyView.bTitle}" style="width: 98%;"></td>
				</tr>
				<tr>
					<td>����</td>
					<td><textarea rows="10" name="bContent" style="width: 98%;">${replyView.bContent}</textarea></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="�亯�ޱ�">
					<a href="List.do" class="btn">��Ϻ���</a></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>