<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>SB Admin - Dashboard</title>

<!-- Custom fonts for this template-->
<link
	href="${pageContext.servletContext.contextPath }/assets/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">

<!-- Page level plugin CSS-->
<link
	href="${pageContext.servletContext.contextPath }/assets/vendor/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link
	href="${pageContext.servletContext.contextPath }/assets/css/admin/sb-admin.css"
	rel="stylesheet">

<!-- Editor - SummerNote -->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet">

<!-- FileUpload UI -->
<link
	href="${pageContext.servletContext.contextPath }/assets/css/admin/imageUpload.css"
	rel="stylesheet">


<style>
.fileDrop {
  width: 500px;
  height: 600px;
  border: 1px dotted gray;
  background-color: red;
  margin: auto;
  
}
div.col-md-12 {
    height: 700px;
}
div.form-group {
    margin-top: 30px;
}
div.box-body {
    height: 600px;
}
div.form-group input,textarea {
    position: relative;
    bottom: 50px;
}
div.form-group label {
    position: relative;
    bottom: 30px;
    font-size: 16px;
    font-weight: bold;
}
button.btn.btn-default {
    color: #ffffff;
    background-color: #2ae03f;
    font-weight: normal;
    width : 100px;
}
</style>


</head>
<body>
    
<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header with-border">
					<h3 class="box-title">REGISTER BOARD</h3>
				</div>
				<!-- /.box-header -->

<form role="form" method="post" id="registerForm">
	<div class="box-body">
		<div class="form-group">
			<label for="exampleInputEmail1">Title</label><br><br>
			<input type="text"
				name="title" class="form-control" placeholder="Enter Title" >
		</div>
		<br><br>
		<div class="form-group">
			<label for="exampleInputPassword1">Content</label><br><br>
			<textarea rows="3" class="form-control" name="content" placeholder="Enter....."  ></textarea>
		</div><br><br>
		<div class="form-group">
			<label for="exampleInputEmail1">Writer</label><br><br>
			<input type="text"
				name="writer" class="form-control" value="${login.uid}" readonly="readonly" >
		</div><br><br>
		
		<div class="form-group">
			<label for="exampleInputEmail1">File DROP Here</label><br><br>
			<div class="fileDrop"></div>
		</div>
	</div>
	<!-- /.box-body -->
	
	<div class="box-footer">
		<div>
			<hr>
		</div>
		<ul class="mailbox-attachments clearfix uploadedList">
		</ul>
		
		
		<button type="submit" class="btn btn-default">Submit</button>
		<button type="reset" class="btn btn-warning">CANCEL</button>
	</div>
</form>


			</div>
			<!-- /.box -->
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row -->
</section>
<!-- /.content -->

<!-- Handlebars -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js">
</script>
<script src="${pageContext.servletContext.contextPath }/assets/vendor/jquery/jquery.min.js"></script>


<!-- upload.js -->
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/assets/js/admin/upload.js"></script>

<!-- 화면에 보일 각 파일을 템플릿화 -->
<script id="template" type="text/x-handlebars-template">
	<li>
		<span class="mailbox-attachment-icon has-img">
			<img src="{{imgsrc}}" alt="Attachment">
		</span>
		<div class="mailbox-attachment-info">
			<a href="{{getLink}}" class="mailbox-attachment-name">{{fileName}}</a>
			<a href="{{fullName}}" class="btn btn-default btn-xs pull-right delbtn">
			</a>
		</span>
		</div>
			<i class="fa fa-fw fa-remove" data-src="{{fullName}}"></i>
	</li>
</script>

<script>
	var template = Handlebars.compile($("#template").html());
	
	$(".fileDrop").on("dragenter dragover", function (event) {
		event.preventDefault();
	});
	
	$(".fileDrop").on("drop", function (event) {
		event.preventDefault();
		
		var files = event.originalEvent.dataTransfer.files;
		
		var file = files[0];
		
		var formData = new FormData();
		
		formData.append("file", file);
		
		$.ajax({
			url: '/snsUploadAjax',
			data: formData,
			dataType: 'json',
			processData: false,
			contentType: false,
			type: 'POST',
			success: function (data) {
				
				var fileInfo = getFileInfo(data);
				
				console.log(fileInfo);
				var html = '<img src="/assets/image/'+data+'"alt="Attachment">'
				$('.uploadedList').append(html);
				
				console.log(data);				
			},
			error : function (a,b,c) {
				console.log(a,b,c);
			}
		});
	});
	
	// form 태그의 submit 처리
	$("#registerForm").submit(function (event) {
		event.preventDefault();
	
		var that = $(this);
		
		var str = "";
		
		$(".uploadedList .delbtn").each(function (index) {
			str += "<input type='hidden' name='files["+index+"]' value='"+$(this).attr("href")+"'> ";
		});
		
		that.append(str);
		alert(that);
	 	that.get(0).submit(); 
	});
</script>

<script>
/*
...579p.
...화면에서 small태그로 된 'x' 삭제버튼을 클릭하면 'data-src'속성값으로
...사용된 파일의 이름을 얻어와서 POST방식으로 호출함.
*/			
$(".uploadedList").on("click", "i", function(event){
	var that = $(this);
	var tmp = that.attr("data-src");
	console.log("tmp : " + tmp);
	
	$.ajax({
	   url:"/deleteFile",
	   type:"post",
	   data: {fileName:$(this).attr("data-src")},
	   dataType:"text",
	   success:function(result){
		   if(result == 'deleted'){
			   that.parent('li').remove(); 
		   }
	   }
	});
});
</script>

</body>
</html>