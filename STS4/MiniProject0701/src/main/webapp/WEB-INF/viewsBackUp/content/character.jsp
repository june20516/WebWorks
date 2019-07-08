<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<html>
<head>

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(function() {
		$(".contentAtc").click(function() {
			articleId = this.getAttribute("id");
			location.href = "/article?id=" + articleId.substring(7);
		})
	});
</script>


<title>Character - ${character.name }</title>

</head>
<body>
<%@ include file="contentHeader.jsp" %>
	<div id="character">
	<img id="characterThmb" src=${character.image_path } />
	<h1> ${character.name }</h1>
	</div>
	
	
	<div id="contents">
		<c:forEach var="content" items="${contents }">
			<table>
				<tr>
					<td><img class="contentAtc" id="article${content.id }"
						name="${content.title }" src="${content.thumbnail_path }" /><br>
						<label for="${content.title }">${content.title }</label></td>
				</tr>
			</table>
		</c:forEach>

	</div>
</html>
