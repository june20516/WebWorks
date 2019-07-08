<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
$(function() {
	$( '#')
	$('idCheck').click(function() {
		var idChecked = false;
		
		var usrId = $('id').val();
		
		$.ajax({
			async : true,
			type : 'POST',
			data : usrId,
			url : "idCheck",
			dataType : "json",
			contentType: "application/json; charset=UTF-8",
			success : function(data) {
				if(data.isDupl){
					$("#id").attr("style", 'style="border-color: red"');
					alert("누군가 사용하는 아이디입니다.");
					$("#id").focus();
				}else{
					$("#id").attr("style", 'style="border-color: blue"');
					alert("사용할 수 있는 아이디입니다.");
					$("#password").focus();
					idChecked = true;
				}
			},
			error : function(error) {
				alert("error : " + error);
			}
		});
	});
	$('#joinSubmit').click(function(){
		checkRegex(){
			
		}
	})
	
})

var checkRegex(){
	document.form.
}
</script>
<title>회원가입</title>

</head>
<body>
	<h1>쥬니버 회원이 되세요 !</h1>
	<form action="joinProcess" id="joinForm" method="post">
		<label for="id">아이디를 입력해 주세요 </label> <br> <input type="text"
			id="id" name="id" placeholder="아이디는 4글자 이상입니다"> <input
			type="button" id="idCheck" value="중복확인"> <br> <label
			for="password">비밀번호를 입력해 주세요</label> <br> <input type="password"
			id="password" name="password" placeholder="비밀번호는 영어+숫자로 8글자 이상입니다">
		<label for="passwordChk"></label> <br> <label for="password">비밀번호를
			한번 더 입력해 주세요</label> <br> <input type="password" id="passwordChk"
			name="passwordChk" placeholder="비밀번호는 영어+숫자로 8글자 이상입니다"> <br>
		<label for="name">이름을 입력해 주세요</label> <br> <input type="text"
			id="name" name="name" placeholder="이름을 입력해주세요"> <br> <br>
		<input type="button" id="joinSubmit" value="가입하기"> <input
			type="button" value="로그인 페이지로	">
	</form>


</body>
</html>