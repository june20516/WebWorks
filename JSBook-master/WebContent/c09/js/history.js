$(function() {                              // DOM이 로드되면 동작한다 
  function toggleContent(id){                    // 페이지에 새로운 콘텐츠를 로드한다
    $('section').removeClass('current');
    $('section').attr('hidden','');
    $(id).addClass('current');
    $(id).removeAttr('hidden');
  }

  $('#history').click(function(){
    toggleContent('#content');
  })
  $('#history2').click(function(){
    toggleContent('#content2');
  })
  $('#history3').click(function(){
    toggleContent('#content3');
  })

});