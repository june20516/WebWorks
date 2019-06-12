<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/new.css">
</head>
<body>
	<div id="commentContainer">
		${sessionScope.id }
		<form action="Modify.do" method="post">
			<input type="hidden" id="sessionId" value="${sessionScope.id}">
			<input type="hidden" name="bId" value="${contentView.bId}"> 
			<input type="hidden" name="bName" value="${contentView.bName}">
			<table>
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>내용</td>
			<td>날짜</td>
		</tr>
		<c:forEach items="${list}" var="dto">
			<tr>
				<td>${dto.bId}</td>
				<td>${dto.bName}</td>
				<td style="text-align: left;"><c:forEach begin="1" end="${dto.bIndent}">-</c:forEach>
				<c:choose>
						<c:when test="${dto.bIndent>0 }">
							<a href="ContentView.do?bId=${dto.bId}">re:${dto.bTitle}</a>
						</c:when>
						<c:otherwise>
							<a href="ContentView.do?bId=${dto.bId}">${dto.bTitle}</a>						
						</c:otherwise>
					</c:choose>
				 </td>
				<td>${dto.bDate}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5"><a href="writeView" class="btn">글작성</a></td>
		</tr>
	</table>
		</form>
	</div>
</body>
</html>