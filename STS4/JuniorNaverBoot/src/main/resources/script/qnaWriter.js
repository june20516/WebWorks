$(function() {
		$("#summernote").summernote(
				{	//툴바 세팅
					toolbar: [
					    ['style', ['bold', 'italic', 'underline', 'clear']],
					    ['fontname',['fontname']],
					    ['font', ['strikethrough', 'superscript', 'subscript']],
					    ['fontsize', ['fontsize']],
					    ['color', ['color']],
					    ['para', ['ul', 'ol', 'paragraph']],
					    ['insert', ['link', 'picture', 'video']],
					    ['view', ['help']]
					  ],
					lang : 'ko-KR',
					fontNames : [ 'Nanum Gothic', 'Nanum Myeongjo',
							'Gamja Flower', 'Noto Serif KR' ],
					fontNamesIgnoreCheck : [ 'Gamja Flower', 'Noto Serif KR' ],
					placeholder : '질문을 입력하세요..',
					callbacks: {
						onImageUpload: function(files, editor, welEditable) {
				            for (var i = files.length - 1; i >= 0; i--) {
				            	sendFile(files[i], this);
				            }
				        }
					}
		});
		
		//질문하기 버튼으로 진입했을 때, qNo가 없는 경우 0으로 생성하여 submit해주기
		$("#go").click(function() {
			if (!$("#qNo").val()) {
				$("#qNo").val("0");
			}
		})
	});
	
	function sendFile(file, el) {
		var form_data = new FormData();
      	form_data.append('file', file);
      	$.ajax({
        	data: form_data,
        	type: "POST",
        	url: 'image',
        	cache: false,
        	contentType: false,
        	enctype: 'multipart/form-data',
        	processData: false,
        	success: function(img_name) {
          		$(el).summernote('editor.insertImage', img_name);
        	}
      	});
    }
	