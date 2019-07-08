<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
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
	<div id="character">
	<img id="characterThmb" src=${character.image_path } />
	<h1> ${character.name }</h1>
	</div>
	<div id="menuBar">
		<a href="/?menu=1">${menus[0].title }</a> <a href="/?menu=2">${menus[1].title }</a>
		<a href="/?menu=3">${menus[2].title }</a><br>
	</div>

	<div id="contents">
		<c:forEach var="content" items="${contents }" varStatus="loop">
			<table>
				<tr>
					<td><img class="contentAtc" id="article${content.id }"
						name="${content.title }" src="${content.thumbnail_path }" /><br>
						<label for="${content.title }">${content.title }</label></td>
						<c:if test="${loop.count%4 == 0 }"><tr></tr></c:if>
				</tr>
			</table>
		</c:forEach>

	</div>
</html>
