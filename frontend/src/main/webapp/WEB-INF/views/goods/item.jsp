<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
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
	<sec:authorize access="isAuthenticated()"> 
	<sec:authentication property="principal.no" var="userNo"/>
	</sec:authorize>
	<script type="text/javascript">
	
	
	$(function () {
		
		$(document).on('click', '.number-spinner button', function () {    
			var btn = $(this),
				oldValue = btn.closest('.number-spinner').find('#count').val().trim(),
				newVal = 0;
			
			if (btn.attr('data-dir') == 'up') {
				newVal = parseInt(oldValue) + 1;
			} else {
				if (oldValue > 1) {
					newVal = parseInt(oldValue) - 1;
				} else {
					newVal = 1;
				}
			}
			btn.closest('.number-spinner').find('#count').val(newVal);
		});
		
		$('#go-cart').on('click', function () {
			
			
			var userNo = ${userNo};
			var no = $("input[name=productOptionNo]");
			var count = $("input[name=count]");
		    var cartList = [];
			
			console.log(userNo);
			
			
		    for (var i = 0; i < count.length; i++) {
		    	
		    	var CartVo = {
		    		"userNo" : userNo,
		    		"productOptionNo" : no[i].value,		    			
					"count" : count[i].value
		    	}
		    	
		    	cartList.push(CartVo);
		    	
		    }
		    
		    console.log(cartList);
		    
			$.ajax({
				url : "${pageContext.servletContext.contextPath}/api/user/cart",
				type: "post",
				contentType : "application/json; charset=utf-8" ,
				dataType: "json",
				data: JSON.stringify({
					cartList : cartList					
				}),
				success: function(response){
						$('#cartModal').modal();
						
						$('#temp-list').empty();
						
			  			console.log(response);
			         },            // jqeury XML Http Request
			         error : function(jqXHR, status, e){
			            console.error(status + " : " + e);
			         }
			});
			
		});
		
		$('option-dropdown .dropdown-menu a').bind('click', function (e) {
			
			
		    var html = $(this).html();
		    $('#option-dropdown button.dropdown-toggle').html(html + ' <span class="caret"></span>');
			
		    var rowHtml = '<div class="row">';
		    
		    rowHtml += '<span class="col-md-6" style="padding-top: 10px;">' + html + '</span>';
		    
		    rowHtml += '<div class="input-group number-spinner">';
		    rowHtml += '<input type="text" class="form-control text-center" value="1">';
		    rowHtml += '<span class="input-group-btn">';
		    rowHtml += '<button class="btn btn-light" data-dir="dwn">+</button>';
		    rowHtml += '</span>';
		    rowHtml += '<span class="input-group-btn">';
		    rowHtml += '<button class="btn btn-light" data-dir="up">-</button>';
		    rowHtml += '</span>';
		    rowHtml += '</div>';
		    
		    rowHtml += '</div>'
		    $('#temp-list').append(rowHtml);		    
		});
		
		
	});
	
	function addOption(no, value) {
		
	    $('#option-dropdown button.dropdown-toggle').html(value + ' <span class="caret"></span>');
		
	    var rowHtml = '<div class="row number-spinner">';
	    
	    rowHtml += '<input type="hidden" name="productOptionNo" value="'+no+'">';
	    rowHtml += '<span class="col-md-6" style="padding-top: 10px;">' + value + '</span>';
	    rowHtml += '<input type="text" name="count" class="form-control col-md-2" id="count" value="1"/>'
	    rowHtml += '<button type="button" class="btn btn-light col-md-2" data-dir="dwn">-</button>'
	    rowHtml += '<button type="button" class="btn btn-light col-md-2" data-dir="up">+</button>'
	    
	    rowHtml += '</div>'
	    $('#temp-list').append(rowHtml);		    
	}
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
								    <a class="dropdown-item" href="javascript:void(0)" onclick="addOption('${vo.no}', '${vo.optionValue }')">${vo.optionValue }</a>
							  	</c:forEach>
						  </div>
						</div>
						
						<div id="temp-list" style="height: 150px; background-color: #FFFFFF; overflow: auto;" class="col-md-11 ml-3 mb-3">
						</div>
						
						<div class="row col-md-12 ml-1">
						
							<button type="button" class="btn btn-warning col-md-6">바로 주문하기</button>
							<button type="button" class="btn btn-secondary col-md-5 ml-2" id="go-cart">장바구니 담기</button>
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


	<!-- Modal -->
	<div class="modal fade" id="cartModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
			상품이 장바구니에 담겼습니다.
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">계속 쇼핑하기</button>
	        <a href="${pageContext.servletContext.contextPath }/user/cart" class="btn btn-primary">장바구니 가기</a>
	      </div>
	    </div>
	  </div>
	</div>


</body>

</html>