<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/views/layout/header.jsp" %>

		<div class="container">
			<div class="container_inner">
				<div class="table_wrap write">
				<form action="reply.do" method="get">
					<input type="hidden" name="num" value="${dto.num}">
					<input type="hidden" name="bGroup" value="${dto.bGroup}">
					<input type="hidden" name="bStep" value="${dto.bStep}">
					<input type="hidden" name="bIndent" value="${dto.bIndent}">
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
								<td>
								<input type="text" class="w100p" name="title" id="input_text" maxlength="50" value="[RE:]${dto.title }">
								</td>
							</tr>
							<tr>
								<th>글쓴이</th>
								<td class="id"><input type="text" name="id" id="id" value="${sessionScope.id }" readonly="readonly"/></td>
							</tr>
							<tr>
								<th>내용</th>
								<td><textarea name="content" id="content">${dto.content }</textarea></td>
							</tr>
						</tbody>
						
					</table>
					<div class="btn_wrap">
					<div class="box_right">
						<input type="submit" class="btn btn_point" value="등록"><a href="index.jsp" class="btn btn_point">취소</a>
					</div>
				</div>
					</form>
				</div><!-- //table_wrap -->
			

				
			</div><!-- //container_inner -->
		</div><!-- //container -->
<%@include file="/views/layout/footer.jsp" %>