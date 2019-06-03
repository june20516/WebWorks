
$(document).ready(function(){
	
	/* 로그인페이지가기 */
	$(".goLogin").click(function(){
		alert('로그인을 해주세요');
		location.href="views/login/login.jsp";
	});
	
	
	/* 게시판목록 돌아가기 */
	$("#goList").click(function(){
		location.href="index.jsp";
	});
	
	/* 뒤로 돌아가기 */
	   $(".goBack").click(function(){
	      history.go(-2);
	   });
	
	/* 텍스트 길이제한 */
	$('#input_text').keyup(function(){
        if ($(this).val().length > $(this).attr('maxlength')) {
            alert('제한길이 초과');
            $(this).val($(this).val().substr(0, $(this).attr('maxlength')));
        }
    });
	
	/* input 포커스 이벤트 */
	$('.login_focus').focus(function(){
		$(this).siblings('span').fadeIn('500');
	});
	$('.login_focus').blur(function(){
		$(this).siblings('span').hide();
	});
	


});

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