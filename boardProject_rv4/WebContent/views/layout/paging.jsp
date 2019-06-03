<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="paging">
		<a href="${param.firstPageNo }" class="page prev_02">맨처음</a>
		<a href="${param.prevPageNo }" class="page prev_01">이전</a>
		
		<c:forEach var="i" begin="${param.startPageNo }" end="${param.endPageNo }" step="1">
			<c:choose>
				<c:when test="${i eq param.pageNo }"><a href="${i }">${i }</a></c:when>
				<c:otherwise><a href="${i }">${i }</a></c:otherwise>
			</c:choose>
		</c:forEach>
		
		<a href="${param.nextPageNo }" class="page next_01">다음</a>
		<a href="${param.finalPageNo }" class="page next_02">맨뒤</a>
		
		
	</div><!-- //paging -->
</body>
</html>