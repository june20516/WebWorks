function infoConfirm() {
	if(document.regForm.id.value.length == 0) {
		alert("아이디는 필수 사항입니다.");
		regForm.id.focus();
		return;
	}
	if(document.regForm.id.value.length < 4) {
		alert("아이디는 4글자 이상이어야 합니다.");
		regForm.id.focus();
		return;
	}
	if(document.regForm.pw.value.length == 0) {
		alert("비밀번호는 필수 사항입니다.");
		regForm.pw.focus();
		return;
	}
	if(document.regForm.pw.value != document.regForm.pwCheck.value) {
		alert("비밀번호가 일치하지 않습니다.");
		regForm.pw.focus();
		return;
	}
	if(document.regForm.name.value.length == 0) {
		alert("이름은 필수 사항입니다.");
		regForm.name.focus();
		return;
	}
	document.regForm.submit();
}
function updateInfoConfirm() {
	if(document.regForm.pw.value == "") {
		alert("패스워드를 입력하세요.");
		document.reg_frm.pw.focus();
		return;
	}
	if(document.regForm.pw.value != document.regForm.pwCheck.value) {
		alert("패스워드가 일치하지 않습니다.");
		reg_frm.pw.focus();
		return;
	}
	document.regForm.submit();
}