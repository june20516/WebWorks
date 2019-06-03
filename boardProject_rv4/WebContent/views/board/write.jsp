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
				<div class="table_wrap write">
				<form action="${path}/bw.do" method="post">
					<table>
						<colgroup class="pc">
							<col width="120px">
							<col width="*">
						</colgroup>
						<colgroup class="mobile">
							<col width="*">
						</colgroup>
						<tbody>
							<tr>
								<th>제목</th>
								<td><input type="text" class="w100p" name="title" id="input_text" maxlength="150"></td>
							</tr>
							<tr>
								<th>글쓴이</th>
								<td class="id"><input type="text" name="id" id="id" value="${id }" readonly="readonly"/></td>
							</tr>
							<tr>
								<th>내용</th>
								<td><textarea name="content" id="content"></textarea></td>
							</tr>
						</tbody>
					</table>
					<div class="btn_wrap">
					<div class="box_right">
						<input type="submit" class="btn btn_point" value="등록">
						<a class="btn btn_point" href='/boardProject/index.jsp'>취소</a>
					</div>
				</div>
					</form>
				</div><!-- //table_wrap -->
		
			</div><!-- //container_inner -->
		</div><!-- //container -->
	</div>
</body>
</html>