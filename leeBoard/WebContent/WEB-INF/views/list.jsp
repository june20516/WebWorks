<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="resources/js/list.js"></script>
<link rel="stylesheet" href="resources/css/new.css">
<script type=""></script>
</head>
<body>
	<div>
	${sessionScope.id }
	<span id="listContainer"></span>
	<form name="paging">
	<input type="hidden" id="sessionId" value="${sessionScope.id }">
	<input type="hidden" id="listVal" value="${list}">
	<input type="hidden" name="totalCount" id="totalCount" value="${totalCount}" />
	<input type="hidden" name="pageCount" id="pageCount" value="${pageCount}" />
	<input type="hidden" name="pageNum" id="pageNum" />
	</form>
	<span id="loginPart" style="text-align:right;"><a href="login" class="btn">로그인</a></span>
	<span id="logoutPart" style="text-align:right;"><a href="Logout.do" class="btn">로그아웃</a></span>
	<p style="text-align:right;"><input type="button" id="searchBtn" value="검색"></p>
	<table>
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>제목</td>
			<td>날짜</td>
			<td>조회수</td>
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
				<td>${dto.bHit}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5"><a href="writeView" class="btn">글작성</a></td>
		</tr>
	</table>
	
	
	 
	</div>
	<button class="pageCountBtn" value=5>5개씩 보기</button>
	<button class="pageCountBtn" value=10>10개씩 보기</button>
	<button class="pageCountBtn" value=15>15개씩 보기</button>
	<table>
	<tr id="pageN">
	
	</tr>
	</table>
</body>
</html>