<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
$(function(){
	$(".contentThmb").click(function() {
		var id = this.getAttribute("id");
		location.href="/article?id="+id.substring(7);
	})

	$(".characterThmb").click(function() {
		var id = this.getAttribute("id");
		location.href="/character?id="+id.substring(9);
	})
});
</script>
<title>Home</title>

</head>
<body>

	<div id="menuBar">
		<a href="/?menu=1">${menus[0].title }</a> <a href="/?menu=2">${menus[1].title }</a>
		<a href="/?menu=3">${menus[2].title }</a><br>
	</div>
	
	<div id="characters">
		<table>
			<tr>
				<c:forEach var="character" items="${characters }">
	<p id="test">${character.id }</p>
					<td><img class="characterThmb" id="character${character.id }" name="${character.name }"
						src="${character.image_path } " /><br> <label
						for="${character.name }">${character.name }</label></td>
				</c:forEach>
			</tr>
		</table>
	</div>

	<div id="contents">
		<c:forEach var="content" items="${contents }">
			<table>
				<tr>
					<td><img class="contentThmb" id="article${content.id }"
						name="${content.title }" src="${content.thumbnail_path }" /><br>
						<label for="${content.title }">${content.title }</label></td>
				</tr>
			</table>
		</c:forEach>

	</div>
</html>
