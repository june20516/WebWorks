<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../commonHeader.jsp"  %>
<meta charset="UTF-8">
<title>article</title>
</head>
<body>
	<%@include file="../commonNav.jsp"  %>


	<div id="contentDiv">
		<video id="videoPlayer" width="700" height="500" controls autoplay>
			<source type="video/mp4" src="${article.video_path }" />
		</video>

		<h3>${article.title }</h3>
	</div>

</body>
</html>