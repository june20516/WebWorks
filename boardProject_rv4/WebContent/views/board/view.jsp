<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no" />
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/resources/css/reset.css" />
<link rel="stylesheet" href="${path}/resources/css/common.css" />
<link rel="stylesheet" href="${path}/resources/css/sub.css" />
<script src="${path }/resources/js/jquery-1.9.1.js"></script>
<script src="${path }/resources/js/jquery-ui.min.js"></script>
<script src="${path }/resources/js/run.js"></script>
</head>
<body>

	<div class="wrap">
		<jsp:include page="../layout/header.jsp"></jsp:include>
		<div class="container">
			<div class="container_inner">
				<form action="views/board/update.jsp">
					<div class="table_wrap view">
						<table>
							<colgroup class="pc">
								<col width="120px">
								<col width="*">
							</colgroup>
							<colgroup class="mobile">
								<col width="*">
							</colgroup>
							<input type="hidden" name="num" value="${dto.num}" />
							<input type="hidden" name="title" id="title" value="${dto.title}" />
							<input type="hidden" name="content" value="${dto.content}" />
							<tbody>
								<tr>
									<th>제목</th>
									<td>${dto.title }</td>
								</tr>
								<tr>
									<th>글쓴이</th>
									<td>${dto.id }</td>
								</tr>
								<tr>
									<th>등록일</th>
									<td>${dto.writeday}</td>
								</tr>
								<tr>
									<th>내용</th>
									<td>${dto.content }</td>
								</tr>

							</tbody>
						</table>

					</div>
					<!-- //table_wrap -->

					<div class="btn_wrap">
						<div class="box_right">
							<c:if test="${sessionScope.id == dto.id }">
								<a class="btn btn_point" href="bd.do?num=${dto.num }">삭제</a>
								<input class="btn btn_point" type="submit" value="수정">
							</c:if>
							<a href='reply_view.do?num=${dto.num}' class="btn btn_point">답글</a> 
							<a href='index.jsp'class="btn btn_point">목록</a>
						</div>
					</div>
				</form>
				<div class="table_wrap prevNextList">
					<table>
						<colgroup>
							<col width="120px">
							<col width="*">
						</colgroup>
						<tbody>
							<tr>
								<th class="prev">이전글</th>
								<td><a href="bv.do?no=${dto.num}">${dtop.title }</a></td>
							</tr>
							<tr>
								<th class="next">다음글</th>
								<td><a href="bv.do?no=${dto.num}">${dton.title }</a></td>
							</tr>
						</tbody>
					</table>
					dsfds	${reDto }sdfdsf
	
					 <c:forEach items="${reDto }" var="re">
					 	${re }<br>
					 </c:forEach>
				</div>

				
			</div><!-- //container_inner -->
		</div><!-- //container -->
	
	</div>
	
	
	
	
	
	
</body>
</html>







