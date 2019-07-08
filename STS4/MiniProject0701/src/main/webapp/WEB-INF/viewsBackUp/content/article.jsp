<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<!-- Bootstrap core CSS -->
<link href="resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="resources/css/shop-homepage.css" rel="stylesheet">

<title>article</title>
</head>
<body>
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="#">쥬니버 네이버</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active"><a class="nav-link" href="/">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="joinProcess">로그인</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="logout">로그아웃</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="qnaList">Q&A</a>
				</li>
				</li>
				<li class="nav-item"><a class="nav-link" href="join">회원가입</a>
				</li>
			</ul>
		</div>
	</div>
</nav>


	<div id="contentDiv">
		<video id="videoPlayer" width="700" height="500" controls autoplay>
			<source type="video/mp4" src="${article.video_path }" />
		</video>

		<h3>${article.title }</h3>
	</div>

</body>
</html>