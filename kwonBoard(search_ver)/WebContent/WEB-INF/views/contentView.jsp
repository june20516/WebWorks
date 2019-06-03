<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<link rel="stylesheet" href="resources/css/new.css">
</head>
<body>
	<div>
		${sessionScope.id }
		<form action="Modify.do" method="post">
			<input type="hidden" id="bId" name="bId" value="${contentView.bId}"> 
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
						<input type="button" id="deleteBtn" value="����">
						<input type="button" id="replyBtn" value="�亯">
						<input type="button" id="listBtn" value="��Ϻ���">
					</td>
				</tr>
			</table>
		</form>
	</div>
<script type="text/javascript" src="resources/js/members.js" charset="UTF-8"></script>
</body>
</html>