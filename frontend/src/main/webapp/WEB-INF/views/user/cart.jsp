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
	<link href="${pageContext.servletContext.contextPath }/assets/css/shop-homepage.css" rel="stylesheet">
	<!-- Custom fonts for this template-->
	<link
		href="${pageContext.servletContext.contextPath }/assets/vendor/fontawesome-free/css/all.min.css"
		rel="stylesheet" type="text/css">
	
	<!-- Page level plugin CSS-->
	<link
		href="${pageContext.servletContext.contextPath }/assets/vendor/datatables/dataTables.bootstrap4.css"
		rel="stylesheet">

</head>
<body>
	<!-- Navigation -->
	<c:import url='/WEB-INF/views/includes/navigation.jsp'>
		<c:param name="active" value="shopping" />
	</c:import>
	<!-- /.Navigation -->
	
	
	
<div id="wrapper">

		<!-- Sidebar -->
		<c:import url='/WEB-INF/views/includes/sidebar.jsp'>
		</c:import>
		<!-- /Sidebar -->

		<div id="content-wrapper">

			<div class="container-fluid">

				<!-- Breadcrumbs -->
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="#">Product</a></li>
					<li class="breadcrumb-item active">List</li>
				</ol>

				<!-- Category DataTables -->
				<div class="card mb-3">
					<div class="card-header">
						<i class="fas fa-table"></i> Product Data Table
					</div>
					<div class="card-body">
						<div class="table-responsive">
							<table class="table table-bordered" id="dataTable" width="100%"
								cellspacing="0">
								<thead>
									<tr>
										<th width="10%">
											<div class="custom-control custom-checkbox">
											    <input type="checkbox" class="custom-control-input" id="allCheck" >
												<label class="custom-control-label" for="allCheck"></label>
											</div>
										</th>
										<th>상품명</th>
										<th>옵션</th>
										<th>부가세</th>
										<th>배송비</th>
										<th>가격</th>
										<th>수량</th>
										<th>총가격 (상품가격 + 부가세  * 수량)</th>
										<th width="5%">삭제</th>
									</tr>
								</thead>
						
								<tbody>
								<c:forEach items="${cartList }" var="vo" varStatus="status">
									<tr>
										<td>
											<div class="custom-control custom-checkbox">
											    <input type="checkbox" class="custom-control-input cart-class" name="cart-checkbox" id="${vo.no}" >
												<label class="custom-control-label" for="${vo.no}"></label>
												<div><input type="hidden" value="${vo.productOptionNo }"></div>
											</div>
										</td>
										<td>${vo.productName }</td>
										<td>${vo.optionValue }</td>
										<td>${vo.additionalPrice }</td>
										<td>${vo.shippingFee }</td>
										<td>${vo.price }</td>
										<td>${vo.count }</td>
										<td>${vo.count * (vo.price + vo.additionalPrice) }</td>
										<td><a class="btn btn-danger" href="${pageContext.servletContext.contextPath }/user/cart/delete/${vo.no}">X</a></td>
									</tr>
								</c:forEach>
								</tbody>
								<tfoot>
									<tr>
										<td colspan="1" class="text-center">
											<button class="btn btn-danger btn-lg" id="delete-btn">선택삭제</button>
										</td>
										<td colspan="8" id="tablefoot" class="text-right">
											
										</td>
									</tr>
								</tfoot>
							</table>
						</div>
					</div>
					<div class="card-footer small text-muted text-center">
						<a href="${pageContext.servletContext.contextPath}/main" class="btn btn-secondary col-md-2" style="height: 70px; padding-top: 22px;">계속 쇼핑하기</a>
						<button type="button" class="btn btn-warning col-md-2 ml-2" style="height: 70px;" id="go-order">바로 주문하기</button>
					</div>
				</div>

			</div>
			<!-- /.container-fluid -->

			<!-- Sticky Footer -->
			<footer class="sticky-footer">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<span>Copyright Â© Your Website 2019</span>
					</div>
				</div>
			</footer>

		</div>
		<!-- /.content-wrapper -->
	</div>
	
	
	<!-- /#wrapper -->
	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>
		<!-- Bootstrap core JavaScript-->
	<script
		src="${pageContext.servletContext.contextPath }/assets/vendor/jquery/jquery.min.js"></script>
	<script
		src="${pageContext.servletContext.contextPath }/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script
		src="${pageContext.servletContext.contextPath }/assets/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Page level plugin JavaScript-->
	<script
		src="${pageContext.servletContext.contextPath }/assets/vendor/datatables/jquery.dataTables.js"></script>
	<script
		src="${pageContext.servletContext.contextPath }/assets/vendor/datatables/dataTables.bootstrap4.js"></script>

	<!-- Custom scripts for all pages-->
	<script
		src="${pageContext.servletContext.contextPath }/assets/js/admin/sb-admin.min.js"></script>

	<!-- Demo scripts for this page-->
	<script
		src="${pageContext.servletContext.contextPath }/assets/js/admin/demo/datatables-demo.js"></script>

	<script type="text/javascript">
	
	function appendPrice(checkbox) {
		var productPrice = 0;
		var productAdditionalPrice = 0;
		var productShippingFee = 0;
		var name = "";
		var option = "";
		var additional_price = "";
		var shipping_fee = "";
		var price = "";
		var count = "";
		
		checkbox.each(function (i) {
			var tr = checkbox.parent().parent().parent().eq(i);
			var td = tr.children();
			
			name = td.eq(1).text();
			option = td.eq(2).text();
			additional_price = td.eq(3).text();
			shipping_fee = td.eq(4).text();
			price = td.eq(5).text();
			count = td.eq(6).text();
			
			productPrice += parseInt(price);
			productAdditionalPrice += parseInt(additional_price);
			productShippingFee += parseInt(shipping_fee);
			
		});
		
		if(productPrice + productAdditionalPrice < 30000){
			productShippingFee = 2500;
		}else{
			productShippingFee = 0;
		}
		
		var totalPrice = count * (productPrice + productAdditionalPrice) + productShippingFee;
		
		$('#tablefoot').empty();
		
		var html = '<span>상품가격 '+productPrice+'원 + </span>';
			html += '<span>부가세 '+ productAdditionalPrice +'원 + </span>';
			if(productShippingFee == 0) {
				html += '<span>배송비 <b> 무료 </b> = </span>';
			}else{
				html += '<span>배송비 '+ productShippingFee +'원 = </span>';
			}
			
			html += '<span>주문금액 <b> '+ totalPrice +' </b> 원 </span>';
		$('#tablefoot').append(html);

		var cc = $("input[name=cart-checkbox]");
		if(checkbox.length == 0) {
			$('#tablefoot').empty();
		}
		
		if(cc.length > checkbox.length){
			$("#delete-btn")[0].innerHTML = "선택삭제";
		}
		
		if(cc.length == checkbox.length){
			$("#delete-btn")[0].innerHTML = "전체삭제";
		}
		
	}
	
	$(function () {
		
		$('#go-order').on('click', function () {
			var checked = $("input[name=cart-checkbox]:checked");
			var productOptionNoList = checked.siblings('div').children();
			var tdList = checked.parent().parent().siblings();
			console.log(productOptionNoList);
			console.log(tdList);
			
			//var tdList = parentTdList[i].siblings();
			/* 
			2,4,5
			10,12,13
			16
			0~7
			15
			 */
			var orderProductList = [];
			
			var additionalPrice = 0;
			var price = 0;
			var count = 0;
			var orderProduct = {};				
			for (var i = 0; i < tdList.length; i++) {
				if(i%8 == 2){
					additionalPrice = tdList[i].innerHTML;	
					continue;
				}
				
				if(i%8 == 4){
					price = tdList[i].innerHTML;
					continue;
				}
				
				if(i%8 == 5){
					count = tdList[i].innerHTML;
					continue;
				}
				
				if(i%8 == 7){
					orderProduct = {
						"productOptionNo" : productOptionNoList[i%7].defaultValue,
						"count" : count,
						"productPrice" : parseInt(additionalPrice) + parseInt(price)
					}
					
					orderProductList.push(orderProduct);
				}
			}
			
			console.log(orderProductList);
			
		
		    var form = document.createElement("form");
		    form.setAttribute("method", "post");
		    form.setAttribute("action", "${pageContext.servletContext.contextPath}/user/checkout");
		    
		    for(var i=0; i < orderProductList.length; i++){
		    	var optionNoField = document.createElement("input");
		    	optionNoField.setAttribute("type", "hidden");
		    	optionNoField.setAttribute("name", "orderProductList["+ i +"].productOptionNo");
		    	optionNoField.setAttribute("value", orderProductList[i].productOptionNo);
		        form.appendChild(optionNoField);
		    
		    	var countField = document.createElement("input");
		    	countField.setAttribute("type", "hidden");
		    	countField.setAttribute("name", "orderProductList["+ i +"].count");
		    	countField.setAttribute("value", orderProductList[i].count);
		        form.appendChild(countField);
		    
		    	var priceField = document.createElement("input");
		    	priceField.setAttribute("type", "hidden");
		    	priceField.setAttribute("name", "orderProductList["+ i +"].productPrice");
		    	priceField.setAttribute("value", orderProductList[i].productPrice);
		        form.appendChild(priceField);
		        
		    }
		    
		    document.body.appendChild(form);
		    form.submit();
		});
		
		$('#delete-btn').on('click', function () {
			var checkList = $("input[name=cart-checkbox]:checked");
			var deleteList = [];
			
			for (var i = 0; i < checkList.length; i++) {
				deleteList.push(checkList[i].id);
			}
			
			$.ajax({
				url : "${pageContext.servletContext.contextPath}/api/user/cart",
				type: "delete",
				contentType : "application/json; charset=utf-8" ,
				dataType: "json",
				data: JSON.stringify(deleteList),
				success: function(response){
					
		  			console.log(response);
		  			location.reload();
		         },            // jqeury XML Http Request
		         error : function(jqXHR, status, e){
		            console.error(status + " : " + e);
		         }
				
			})
			
			console.log(deleteList);
		});
		
		$('#allCheck').click(function(e){
		    if($("#allCheck").prop("checked")) {
		    	$("input[name=cart-checkbox]").prop("checked",true); 
		   	} else {
		   		$("input[name=cart-checkbox]").prop("checked",false);
		   	}
		    var checkbox = $("input[name=cart-checkbox]:checked");
		    appendPrice(checkbox);
		});
		
		$('.cart-class').on('click', function () {
			var checkbox = $("input[name=cart-checkbox]:checked");
			appendPrice(checkbox);
		}); 
		
	
		
	})
	
	</script>
	
</body>

</html>
