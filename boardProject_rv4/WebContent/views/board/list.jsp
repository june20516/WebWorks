<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/views/layout/header.jsp" %>
 			<div class="container">
			<div class="container_inner">
				<form action="index.jsp" name="search" method="get">
					<div class="board_search">
						<div class="board_search_inner">
							<div class="select_wrap">
								<select name="opt">
									<option value="title">제목</option>
									<option value="content">내용</option>
									<option value="id">작성자</option>
								</select>
							</div>
							<div class="search">
								<label><input type="text" id="" name="keywork"></label>
								<input type="submit" class="btn_search" value="검색"/>
							</div>
						</div>
					</div><!-- //board_search -->
				</form>
				
				<div class="board_top">
					<p>Total <span>1</span>/20 건</p>
				</div>
				<div class="table_wrap list">
					<table>
						<colgroup class="pc">
							<col width="50px">
							<col width="*">
							<col width="100px">
							<col width="100px">
						</colgroup>
						<colgroup class="mobile">
							<col width="*">
							<col width="80px">
						</colgroup>
						<thead>
							<tr>
								<th class="remove">번호</th>
								<th>제목</th>
								<th>글쓴이</th>
								<th class="remove">작성일</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${dtos }" var="dto">
								<tr>
									<td class="remove">${dto.num}</td>
									<td class="subject">
										<c:choose>
											<c:when test="${id == null }">
												<a href="#" class="ellipsis goLogin">${dto.title }</a>
											</c:when>
											<c:otherwise>
												<a href="bv.do?num=${dto.num }" class="ellipsis">${dto.title }</a>
											</c:otherwise>
										</c:choose>
									</td>
									<td>${dto.id}</td>
									<td class="remove">${dto.writeday }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div><!-- //table_wrap -->

				<div class="btn_wrap">
					<div class="box_right">
						<c:choose>
							<c:when test="${id == null }">
								<a href='#' class="btn btn_point goLogin">글쓰기</a>
							</c:when>
							<c:otherwise>
								<a href='${path }/views/board/write.jsp' class="btn btn_point">글쓰기</a>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
				

				
<%@include file="/views/layout/footer.jsp" %>