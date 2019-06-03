<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sign up</title>
   <link rel="stylesheet" type="text/css" href="${path}/resources/css/style.css">
   <link rel="stylesheet" type="text/css" href="${path}/resources/css/reset.css">
	<script src="${path }/resources/js/jquery-1.9.1.js" charset="utf-8"></script>
	<script src="${path }/resources/js/jquery-ui.min.js" charset="utf-8"></script>
	<script src="${path }/resources/js/run.js" charset="utf-8"></script>
</head>
<body>
   <div id="signup-box">
      <div id="sign-box">
      <h1>Sign Up</h1>

      <form action="/boardProject/is.do" method="post" id="form" name="sign_form">
         <p><input type="text" name="id" id="id" class="inputBox" autocomplete="off" placeholder="Id(영문 대소문자, 숫자 조합 8~12자)"/></p>
         <p><input type="password" name="pw" id="pw" class="inputBox" autocomplete="off" placeholder="Password(영문 대소문자, 숫자 조합 8~12자)"/></p>
         <p><input type="password" name="pwRetype" id="pwRetype" class="inputBox" autocomplete="off" placeholder="RetypePassword"/></p>
         <p><input type="text" name="name" id="name" class="inputBox" autocomplete="off" placeholder="Name"/></p>
         <p class="inlineWrap">
         <input type="text" name="tel1" class="inputBox" autocomplete="off" placeholder="010"/>
         <input type="text" name="tel2" class="inputBox" autocomplete="off" placeholder="1234"/>
         <input type="text" name="tel3" class="inputBox" autocomplete="off" placeholder="5678"/>
         </p>
         <p class="inlineWrap">
            <input type="text" name="birth1" class="inputBox" autocomplete="off" placeholder="Year(4자)"/>
            <select name="birth2">
               <option>Month</option>
               <option value="1" >1</option>
               <option value="2" >2</option>
               <option value="3" >3</option>
               <option value="4" >4</option>
               <option value="5" >5</option>
               <option value="6" >6</option>
               <option value="7" >7</option>
               <option value="8" >8</option>
               <option value="9" >9</option>
               <option value="10" >10</option>
               <option value="11" >11</option>
               <option value="12" >12</option>
            </select>
            <input type="text" name="birth3" class="inputBox" autocomplete="off" placeholder="Date(일)"/>
         </p>
         <p class="blockWrap">
            <select name="sex">
               <option>성별</option>
               <option value="man">남자</option>
               <option value="woman">여자</option>
            </select>
         </p>
         <p><input type="text" name="email" id="email" class="inputBox" autocomplete="off" placeholder="Email"/></p>
         <input type="submit" value="Sign Up" onclick="" class="btn">
         <input type="reset" value="Cancel" class="btn cancel" onclick="javascript:window.location='${path}/views/login/login.jsp'">
      </form>
      </div>   
   </div>
</body>
</html>