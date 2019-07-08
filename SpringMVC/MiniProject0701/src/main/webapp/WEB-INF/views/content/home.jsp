<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<html>
<head>
<%@include file="../commonHeader.jsp"  %>
  <!-- Bootstrap core CSS -->
  <link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom styles for this template -->
  <link href="resources/css/juniornaver-homepage.css" rel="stylesheet">
  
  <!-- Bootstrap core JavaScript -->
 <script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="resources/vendor/jquery/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$(".contentThmb").click(function() {
			var id = this.getAttribute("id");
			location.href = "/article?id=" + id.substring(7);
		})

		$(".characterThmb").click(function() {
			var id = this.getAttribute("id");
			location.href = "/character?id=" + id.substring(9);
		})
	});
</script>
<title>Home</title>

</head>
<body>

<%@include file="../commonNav.jsp"  %>
  <!-- Page Content -->
  <div class="container">

    <div class="row">

      <div class="col-lg-3">
		
        <c:if test="${sessionScope.userLoginInfo.name!=null }" >
			<h1 class="my-4">${sessionScope.userLoginInfo.name}님,안녕하세요</h1>
		</c:if>

        <div class="list-group">
          <a href="/?menu=1" class="list-group-item">동요</a>
          <a href="/?menu=2" class="list-group-item">동화</a>
          <a href="/?menu=3" class="list-group-item">TV프로그램</a>
        </div>

      </div>
      <!-- /.col-lg-3 -->

      <div class="col-lg-9">
        <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
          <ol class="carousel-indicators">
		<c:forEach varStatus="charCount" items="${characters }">
            <c:choose>
          <c:when test="${charCount.index==0 }">
            <li data-target="#carouselExampleIndicators" data-slide-to="${charCount.index }" class="active"></li>
                    </c:when>  
			<c:otherwise>  
            <li data-target="#carouselExampleIndicators" data-slide-to="${charCount.index }"></li>
                          </c:otherwise>
                                </c:choose>
            </c:forEach>
          </ol>
          <div class="carousel-inner" role="listbox">
          <c:forEach varStatus="charCount" var="character" items="${characters }">
          <c:choose>
          <c:when test="${charCount.index==0 }">
            <div class="carousel-item active">
          </c:when>  
			<c:otherwise>            
            <div class="carousel-item">
              </c:otherwise>
          </c:choose>
              <img class="d-block img-fluid characterThmb" id="character${character.id }" style="width: 800; height: 300;" src="${character.image_path }" alt="${character.name }">          
            </div>
            </c:forEach>
          <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
          </a>
          <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
          </a>
        </div>

        <div class="row">
        
<c:forEach var="content" items="${contents }" >
          <div class="col-lg-4 col-md-6 mb-4">
            <div class="card h-100">
              <a href="#" class="contentThmb" id="article${content.id }"><img class="card-img-top" src="${content.thumbnail_path }"></a>
              <div class="card-body">
                <h4 class="card-title">
                  <a href="#" class="contentThmb">${content.title }</a>
                </h4>
                <h5>조회수 : ${content.viewCount }</h5>
                <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur!</p>
              </div>
              <div class="card-footer">
                <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
              </div>
            </div>
          </div>
</c:forEach>

        </div>
        <!-- /.row -->

      </div>
      <!-- /.col-lg-9 -->

    </div>
    <!-- /.row -->

  </div>
  <!-- /.container -->

  <!-- Footer -->
  <footer class="py-5 bg-dark">
    <div class="container">
      <p class="m-0 text-center text-white">Copyright &copy; Bit Namba One 2019</p>
    </div>
    <!-- /.container -->
  </footer>



<!--
	<div id="characters">
		<table>
			<tr>
				<c:forEach var="character" items="${characters }">
					<td><img style="cursor: pointer;" class="characterThmb" id="character${character.id }"
						name="${character.name }" src="${character.image_path } " /><br>
						<label for="${character.name }">${character.name }</label></td>
				</c:forEach>
			</tr>
		</table>
	</div>

	<div id="contents">
		<table>
			<tr>
				<c:forEach var="content" items="${contents }" varStatus="loop">
					<td><img style="cursor: pointer;" class="contentThmb" id="article${content.id }"
						name="${content.title }" src="${content.thumbnail_path }" /><br>
						<label for="${content.title }">${content.title }</label></td>
						<c:if test="${loop.count%4==0}">
						<tr></tr>
						</c:if>
				</c:forEach>
			</tr>
		</table>
	</div>
	-->
	 
	 </body>
</html>
