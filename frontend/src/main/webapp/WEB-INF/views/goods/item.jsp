<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">
	<title>Shop Homepage - Start Bootstrap Template</title>
	<!-- Bootstrap core CSS -->
	<link href="${pageContext.servletContext.contextPath }/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<!-- Custom styles for this template -->
	<link href="${pageContext.servletContext.contextPath }/assets/css/shop-item.css" rel="stylesheet">
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript">
	$(function () {
		$('#option-dropdown .dropdown-menu a').bind('click', function (e) {
		    var html = $(this).html();
		    $('#option-dropdown button.dropdown-toggle').html(html + ' <span class="caret"></span>');
			
		    var rowHtml = '<div>';
		    
		    rowHtml += html;
		    
		    rowHtml += '<input type="text" style="display: inline; width: 50px; margin-left: 100px;" class="form-control" value="1"/>'
		    rowHtml += '<button type="button" class="btn btn-light" style="width: 50px;">+</button>'
		    rowHtml += '<button type="button" class="btn btn-light" style="width: 50px;">-</button>'
		    rowHtml += '</div>'
		    $('#temp-list').append(rowHtml);		    
		});
	});
	</script>
</head>

<body>
	<!-- Navigation -->
	<c:import url='/WEB-INF/views/includes/navigation.jsp'>
		<c:param name="active" value="shopping" />
	</c:import>
	<!-- /.Navigation -->

	<!-- Page Content -->
	<div class="container">

		<div class="row">

			<div class="col-lg-3">
				<h1 class="my-4">Eok's Shop</h1>
				<div class="list-group">
				<c:forEach items="${categoryList }" var = "vo" varStatus="status">
					<a href="${pageContext.servletContext.contextPath }/product/list?category_no=${vo.no }" class="list-group-item">${vo.name }</a>
				</c:forEach>
				</div>
			</div>
			<!-- /.col-lg-3 -->

			<div class="col-lg-9">

				<div class="row">
				
					<div id="carouselExampleIndicators" class="carousel slide my-4 col-md-6"
						data-ride="carousel">
						
						<ol class="carousel-indicators">
							<li data-target="#carouselExampleIndicators" data-slide-to="${productDetail.productImageVoList[0].no}"></li>
			
						<c:forEach items="${productDetail.productImageVoList}" var="vo" varStatus="status" begin="1">
							<li data-target="#carouselExampleIndicators" data-slide-to="${vo.no }"></li>
						</c:forEach>
						</ol>
						<div class="carousel-inner" role="listbox">
							<div class="carousel-item active">
								<img class="d-block img-fluid" src="${pageContext.servletContext.contextPath }${productDetail.productImageVoList[0].imageUrl}" style="width: 400px; height: 500px;">
							</div>
						<c:forEach items="${productDetail.productImageVoList}" var="vo" varStatus="status" begin="1">
							<div class="carousel-item">
								<img class="d-block img-fluid" src="${pageContext.servletContext.contextPath }${vo.imageUrl}" style="width: 400px; height: 500px;">
							</div>
						</c:forEach>
						</div>
						<a class="carousel-control-prev" href="#carouselExampleIndicators"
							role="button" data-slide="prev"> <span
							class="carousel-control-prev-icon" aria-hidden="true"></span> <span
							class="sr-only">Previous</span>
						</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
							role="button" data-slide="next"> <span
							class="carousel-control-next-icon" aria-hidden="true"></span> <span
							class="sr-only">Next</span>
						</a>
					</div>
					
					<div class="col-md-6" style="margin-top: 40px;">
						<hr>
						<div class="row ml-3">
							<h5>상품명</h5>							
							<span class="card-title ml-3">${productDetail.name }</span>
						</div>
						<hr>
						<div class="row ml-3">
							<h5>판매가</h5>							
							<span class="ml-3">${productDetail.price }원</span>
						</div>
						<hr>
						<div class="row ml-3">
							<h5>배송비</h5>							
							<span class="ml-3">${productDetail.shippingFee }원</span>
						</div>
						<span class="ml-3">3일후 도착예정</span>
						<hr>
						<div class="btn-group col-md-12" id="option-dropdown">
						  <button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						    Option <span class="caret"></span>
						  </button>
						  <div class="dropdown-menu col-md-11">
							  	<c:forEach items="${productDetail.optionList }" var="vo" varStatus="status">
								    <a class="dropdown-item" href="javascript:void(0)">${vo.optionValue }</a>
							  	</c:forEach>
						  </div>
						</div>
						
						<div id="temp-list" style="height: 150px; background-color: red;" class="col-md-11 ml-3 mb-3">
						</div>
						
						<div class="row col-md-12 ml-1">
						
							<button type="button" class="btn btn-warning col-md-6">바로 주문하기</button>
							<button type="button" class="btn btn-secondary col-md-5 ml-2">장바구니 담기</button>
						</div>
					</div>
				</div>
				<!-- /.card -->

				<div class="card card-outline-secondary my-4">
					<div class="card-header">Product Detail</div>
					<div class="card-body">
						${productDetail.detail }
					</div>
				</div>
				<!-- /.card -->

			</div>
			<!-- /.col-lg-9 -->

		</div>

	</div>
	<!-- /.container -->

	<!-- Footer -->
	<c:import url='/WEB-INF/views/includes/footer.jsp' />
	<!-- /.Footer -->
</body>

</html>