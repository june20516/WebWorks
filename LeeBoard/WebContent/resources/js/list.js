var pageCount = 5;
var contentCount;

function setGoPage() {
    $('#pageN').empty();
    for(var i = 0; i<=(contentCount/pageCount); i++){
        $('#pageN').append("<td><a class='goPage' href='javascript:goPage("+(i+1)+");'>"+(i+1)+"</a></td>");
    }
};


function goPage(pageNum) {
	// name이 paging인 태그
    var f = document.paging;

    // form 태그의 하위 태그 값 매개 변수로 대입
    f.pageNum.value = pageNum;
    console.log(pageNum);

    // input태그의 값들을 전송하는 주소
    f.action = "./List.do";

    // 전송 방식 : post
    f.method = "post";
    f.submit();
}

$(function() {
    var sessionId = $('#sessionId').val();
    if (sessionId==""||sessionId==null) {
        $('#logoutPart').hide();
    } else {
        $('#loginPart').hide();
    }
    
    contentCount = $('#totalCount').val();
    setGoPage();
    
    $('.pageCountBtn').click(function() {
    	$('#pageCount').val($(this).val());
    	pageCount = $(this).val();
    	setGoPage();
    });
    
});