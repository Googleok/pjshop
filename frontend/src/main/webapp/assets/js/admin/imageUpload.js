$(".imgAdd").click(function(){
  $(this).closest(".form-row").find('.imgAdd').before('<div class="col-sm-3 imgUp"><h5 class="row mb-3 ml-1 img-title">추가이미지</h5><div class="imagePreview"></div><label class="btn btn-primary btn-upload col-md-12">Upload<input type="file" class="uploadFile img" value="Upload Photo" style="width:0px;height:0px;overflow:hidden;"></label><i class="fa fa-times del" style="line-height: 2;margin-top: 37px;margin-left: 6px;"></i></div>');
});
$(document).on("click", "i.del" , function() {
	$(this).parent().remove();
});
$(function() {
    $(document).on("change",".uploadFile", function()
    {
    	var index = $('.imgUp').length-1;
    	var role = $(this).parents('.imgUp').children('.img-title')[0].innerHTML;
    	
    	console.log(role);
    	var uploadFile = $(this);
        var files = !!this.files ? this.files : [];
        if (!files.length || !window.FileReader) return; // no file selected, or no FileReader support
        
        var form_data = new FormData();
      	form_data.append('file', files[0]);
      	$.ajax({
        	data: form_data,
        	type: "POST",
        	url: '/productImageUploadAjax',
        	cache: false,
        	contentType: false,
        	dataType: 'json',
        	enctype: 'multipart/form-data',
        	processData: false,
        	success: function(img_name) {
        		console.log('이미지네임', img_name);
        		var html = '<input type="hidden" name=productImageList['+index+'].imageUrl value="'+img_name+'"> ';
        		if(role == '대표이미지'){
        			html += '<input type="hidden" name=productImageList['+index+'].imageRole value="main"> ';
        		}else if(role == '추가이미지'){
        			html += '<input type="hidden" name=productImageList['+index+'].imageRole value="sub"> ';
        		}
    			
        		$('#imageUpload').append(html);
        	}
      	});
        
        if (/^image/.test( files[0].type)){ // only image file
            var reader = new FileReader(); // instance of the FileReader
            reader.readAsDataURL(files[0]); // read the local file
 
            reader.onloadend = function(){ // set image data as background of div
                //alert(uploadFile.closest(".upimage").find('.imagePreview').length);
            	uploadFile.closest(".imgUp").find('.imagePreview').css("background-image", "url("+this.result+")");
            }
        }
      
    });
});