/**
 * 
 */
$(function() {
		/* id 중복 확인 part */
		//id check 수행여부 flag		
		var idChecked = false;
		//id가 바뀌는 경우 새로 check하기 위한 동작
		$('#id').change(function() {
			idChecked = false;
			console.log('changed');
		})
		//id check 를 누를 경우 서버와 ajax 
		$('#idCheck').click(function() {
			var usrId = $('#id').val();

			$.ajax({
				async : true,
				type : 'POST',
				data : usrId,
				url : '/idCheck',
				contentType : 'application/json;',
				dataType : 'json',
				success : function(data) {
					if (data.isDupl) {
						$("#id").attr("style", "background-color: LightCoral");
						alert("누군가 사용하는 아이디입니다.");
						$("#id").focus();
					} else {
						$("#id").attr("style", "background-color: Aquamarine");
						idChecked = true;
						alert("사용할 수 있는 아이디입니다.");
						$("#password").focus();
					}
				},
				error : function(request,status,error) {
					alert("request: "+request+" status: "+status
							+" error: "+error);
				}
			});
		});
		
		//유효성 검사
		function validate() {

			var idPwRegEx = /^[a-zA-Z0-9]{4,12}$/
			var nameRegEx = /^[a-zA-Z0-9가-힣]{1,12}$/

			//get Element
			var id = $("#id");
			var password = $("#password");
			var name = $("#name");
			//아이디 유효성 검사
			if (!check(idPwRegEx, id, "아이디는 4~12자의 영문 대소문자와 숫자만 입력해주세요")) {
				return false;
			}
			
			//아이디 체크 실행여부 검사
			if (!idChecked) {
				alert('id 중복확인이 필요합니다');
				return false;
			}
			
			//비밀번호 유효성 검사
			if (!check(idPwRegEx, password, "패스워드는 4~12자의 영문 대소문자와 숫자만 입력해주세요")) {
				return false;
			}
			//이름 유효성 검사
			if (!check(nameRegEx, name, "이름은 특수문제를 제외한 1~12자로 입력해주세요")) {
				return false;
			}
			// 비밀번호 확인 검사
			if (joinForm.password.value != joinForm.passwordChk.value) {
				alert("비밀번호가 일치하지 않습니다. 다시 확인해 주세요.");
				joinForm.passwordChk.value = "";
				joinForm.passwordChk.focus();
				return false;
			}
			//모든 검사 통과
			return true;
		} // function validate End

		// 정규식으로 값 체크
		function check(regEx, element, message) {
			if (regEx.test(element.val())) {
				return true;
			}
			alert(message);
			element.value = "";
			element.focus();
			return false;
		}
		
		/* 제출부 */
		$('#joinSubmit').click(
				function() {
					if (validate()) {
						//유효성 검사 완료 후 회원가입 컨펌
						if (confirm("아이디 : " + $('#id').val() + "\n이름 : "
								+ $('#name').val() + "\n\n위의 정보로 회원가입 하시겠습니까?")) {
							joinForm.submit();
						}
					}
					;
				})

	})