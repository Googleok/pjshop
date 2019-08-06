$(function(){
 	 $("#email").change(function(){ //포커스를 다른곳으로 갈때 다시 검사
         $("#img-email").hide();
         $("#btn-email").show();
    });
	console.log('hello world');
	$('#btn-email').click(function(){
		var email = $('#email').val();
		if (email == ''){
			return;
		}
		$.ajax({
            url:"/user/api/checkemail?email="+email,
            type:"get",
            dataType:"json",
            success:function(response){
               console.log(response);
               if(response.result != 'success'){
               		console.error(response.data);
               		return;
               }

               if(response.data == 'exist'){
               		$('#email').val('').focus();
					$('#exist_email').show();
               }else{
             		$('#exist_email').hide();
             		$('#btn-email').hide();
             		$('#img-email').show();
               }
            },
            error:function(xhr,error){//내부에서 통신하고 있는 객체(에러내용 더 자세히 보라)
               console.error("error:"+error);
            },

         });
		console.log(email);
	});
});