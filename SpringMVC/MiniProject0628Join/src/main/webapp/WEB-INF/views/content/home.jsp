<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
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
		<a href="/?menu=3">${menus[2].title }</a><br><a href="qnaList">게시판</a>
	</div>
	
	<div id="characters">
		<table>
			<tr>
				<c:forEach var="character" items="${characters }">
					<td><img class="characterThmb" id="character${character.id }" name="${character.name }"	src="${character.image_path } " style="cursor: pointer;" /><br> 
					<label for="${character.name }">${character.name }</label>
					</td>	
				</c:forEach>
				
			</tr>
		</table>
	</div>
	<div id="contents">
	<table>
		<c:forEach var="content" items="${contents }" varStatus="loop">
				<td><img class="contentThmb" id="article${content.id }" name="${content.title }" src="${content.thumbnail_path }" style="cursor: pointer;"/><br>
					<label for="${content.title }">${content.title }</label> <label>${content.viewCount }</label>
				</td>
				<c:if test="${loop.count%4 == 0 }"><tr></tr></c:if>
		</c:forEach>
	</table>
	</div>
</html>
