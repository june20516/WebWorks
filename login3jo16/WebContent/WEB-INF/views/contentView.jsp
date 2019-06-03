<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<link rel="stylesheet" href="resources/css/new.css">
<script>
	function goPage(bId,cContent) {
		var f = document.contentView;
		f.bId.value;
		f.cContent.value;
		f.action = "Comment.do"
		f.method="post"
		f.submit();
	};
</script>
</head>
<body>
	<div>
		${sessionScope.id }
		<form action="Modify.do" name="contentView" method="post">
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
					<td><input type="text" name="bTitle"
						value="${contentView.bTitle}" style="width: 98%;"></td>
				</tr>
				<tr>
					<td>����</td>
					<td><textarea rows="10" name="bContent" style="width: 98%;">${contentView.bContent}</textarea></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="����"> 
					<input type="button" id="deleteBtn" value="����"> 
					<input type="button" id="replyBtn" value="�亯"> 
					<input type="button" id="listBtn" value="��Ϻ���"></td>
				</tr>
				<tr>
					<td>���</td>
					<td><textarea rows="3" name="cContent" style="width: 98%;"></textarea></td>
				</tr>
				<tr>
					<td colspan="2"><a href="javascript:goPage('bId','cContent');" class="btn">��۴ޱ�</a>
					</td>
				</tr>
			</table>
		</form>
		<table>
			<tr>
				<td>��ȣ</td>
				<td>�̸�</td>
				<td>��۳���</td>
				<td>��¥</td>
			</tr>
			<c:forEach items="${cList}" var="cDto">
				<tr>
					<td>${cDto.cId}</td>
					<td>${cDto.cName}</td>
					<td style="text-align: left;"><c:forEach begin="1" end="${cDto.cIndent}">&nbsp;</c:forEach> 
						<c:choose>
							<c:when test="${cDto.cIndent>0 }">
								<a href="ReComment.do?cId=${cDto.cId}">re:${cDto.cContent}</a>
							</c:when>
							<c:otherwise>
								<a href="ReComment.do?cId=${cDto.cId}">${cDto.cContent}</a>
							</c:otherwise>
						</c:choose></td>
					<td>${cDto.cDate}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
<script type="text/javascript" src="resources/js/members.js" charset="UTF-8"></script>
</body>
</html>