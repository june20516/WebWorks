<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>article</title>
</head>
<body>
	<div id="characterDiv" name="aa">
	<img id="characterImg" src="${character.image_path }"/><br>
	<h1>${character.name}</h1>
	
	</div>
	
	
	<div id="contentDiv">
	<video id="videoPlayer" width="700" height="500" controls autoplay>
		<source type="video/mp4" src="${article.video_path }" />
	</video>
	
	<h3>${article.title } </h3>	
	</div>
	
</body>
</html>