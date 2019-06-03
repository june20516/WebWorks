<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no" />
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/resources/css/reset.css" />
<link rel="stylesheet" href="${path}/resources/css/common.css" />
<link rel="stylesheet" href="${path}/resources/css/sub.css" />
   <script type="text/javascript" src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
   <script>
   function Check(){
       if($("#title").val() == "" ){
           alert("제목을 입력해주세요.");
           $("#title").focus();
           return false;
         }
       if($("#content").val() == "" ){
           alert("내용을 입력해주세요.");
           $("#content").focus();
           return false;
         }
   }
   </script>
</head>
<body>
   <div class="wrap">
      <jsp:include page="../layout/header.jsp"></jsp:include>
      <div class="container">
         <div class="container_inner">
            <div class="table_wrap write">
            <form onsubmit="return Check()"  action="/boardProject/Up.do" method="get">
                        <input type="hidden" name="num" id="num" value="${param.num}">
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
                        <td><input type="text" class="w100p" name="title" id="title" value="${param.title }"></td>
                     </tr>
                     <tr>
                        <th>글쓴이</th>
                        <td class="id"><input type="text" name="id" id="id" value="${id }" readonly="readonly"/></td>
                     </tr>
                     <tr>
                        <th>내용</th>
                        <td><textarea name="content" id="content">${param.content }</textarea></td>

                     </tr>
                  </tbody>
               </table>
               <div class="btn_wrap">
               <div class="box_right">
                  <input type="submit" class="btn btn_point" value="등록">
                  <a class="btn btn_point" href='/boardProject/index.jsp'>취소</a>
               </div>
            </div>
               </form>
            </div><!-- //table_wrap -->
         

            <div class="table_wrap prevNextList">
               <table>
                  <colgroup>
                     <col width="120px">
                     <col width="*">
                  </colgroup>
                  <tbody>
                     <tr>
                        <th class="prev">이전글</th>
                        <td><a href="#">제목이 들어갑니다.</a></td>
                     </tr>
                     <tr>
                        <th class="next">다음글</th>
                        <td><a href="#">제목이 들어갑니다.</a></td>
                     </tr>
                  </tbody>
               </table>
            </div>
         </div><!-- //container_inner -->
      </div><!-- //container -->
   </div>
</body>
</html>