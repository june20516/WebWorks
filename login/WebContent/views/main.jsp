<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	${message }
	<h1>${name }�� �ȳ��ϼ���</h1>
	
	<!-- ���̺��� �� p�� �����
	���̺� ����� �����
	DAO���� ���� �����´�
	�迭�� �ֱ�
	��������	P�� �Ѹ���
	-->
	
	<p id="mainTable"></p>
	
	<form action="Logout.do" method="post">
		<input type="submit" value="�α׾ƿ�">&nbsp;
		<input type="button" value="ȸ����������" onclick="location='modify'">
	</form>
</body>
</html>