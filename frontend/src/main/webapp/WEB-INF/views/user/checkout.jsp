<%@page import="com.cafe24.pjshop.frontend.dto.OrderProductDto"%>
<%@page import="java.util.List"%>
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
	<sec:authorize access="isAuthenticated()"> 
	<sec:authentication property="principal.no" var="userNo"/>
	</sec:authorize>
	<link href="${pageContext.servletContext.contextPath }/assets/css/user/checkout.css" rel="stylesheet">
	
</head>
<body>
	<!-- Navigation -->
	<c:import url='/WEB-INF/views/includes/navigation.jsp'>
		<c:param name="active" value="shopping" />
	</c:import>
	<!-- /.Navigation -->
	
	<div class="container">
		<form action="${pageContext.servletContext.contextPath }/order" method="post" >
	
		<div class="row">
			<h1 class="order-title">주문/결제</h1>
		</div>
		<hr style="border: 2px solid black; width: 100%; margin-right: 10px;">
		
		<div>
			<c:forEach items="${orderProductList}" var="vo" varStatus="status">
				<input type="hidden" value="${vo.productOptionNo }" name="orderProductList[${status.index }].productOptionNo">
				<input type="hidden" value="${vo.count }" name="orderProductList[${status.index }].count">
				<input type="hidden" value="${vo.productPrice }" name="orderProductList[${status.index }].productPrice">
			</c:forEach>
		</div>

		<div class="row">
			<h4 class="order-title">구매자정보</h4>
		</div>
		<table class="table table-bordered order-info">
			<tr>
				<th>이름</th>
				<td>${userInfo.name }</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>${userInfo.email }</td>
			</tr>
			<tr>
				<th>휴대폰번호</th>
				<td>${userInfo.phone }</td>
			</tr>
		</table>	
		
		<div class="row">
			<h4 class="order-title">받는사람정보</h4>
			<a href="javascript:popup()" class="btn btn-light mb-1 ml-2" style="bottom: 10px;">배송지변경</a>
		</div>
		<table class="table table-bordered order-info">
		
			<tbody id="recipient-info-table">
				<tr>
					<th>이름</th>
					<td>${mainAddress.recipientName }</td>
				</tr>
				<tr>
					<th>배송주소</th>
					<td>${mainAddress.address }</td>
				</tr>
				<tr>
					<th>휴대폰번호</th>
					<td>${mainAddress.recipientPhone }</td>
				</tr>
				<tr>
					<th>공동 현관비밀번호</th>
					<td>${mainAddress.entrancePassword }</td>
				</tr>
				<tr>
					<th>배송 요청사항</th>
					<td>${mainAddress.message }</td>
				</tr>
			</tbody>
			
		</table>	
		
		<div class="row">
			<h4 class="order-title">결제정보</h4>
		</div>
	
		<%
			
			List<OrderProductDto> productList = (List<OrderProductDto>)request.getAttribute("orderProductList");			
			Long totalPrice = 0L;
			Long shippingFee = 0L;
			
			for(int i=0; i< productList.size(); i++){
				totalPrice += (productList.get(i).getProductPrice() * productList.get(i).getCount());
			}
			
			if(totalPrice > 30000){
				shippingFee = 0L;
			}else{
				shippingFee = 2500L;
			}
			
		%>
		<table class="table table-bordered order-info">
			<tr>
				<th>총상품가격</th>
				<td><%= totalPrice %>원</td>
			</tr>
			<tr>
				<th>배송비</th>
				<td><%= shippingFee %>원</td>
			</tr>
			<tr>
				<th>총결제금액</th>
				<td><%= totalPrice %>원</td>
			</tr>
		</table>	
		<div id="recipient-info">
			<input type="hidden" name="name" value="${mainAddress.recipientName }">
			<input type="hidden" name="address" value="${mainAddress.address }">
			<input type="hidden" name="phone" value="${mainAddress.recipientPhone }">
			<input type="hidden" name="entrancePassword" value="${mainAddress.entrancePassword }">
			<input type="hidden" name="shippingMessage" value="${mainAddress.message }">
		</div>
		<div class="container text-center mb-5">
			<input type="hidden" name="email" value="${userInfo.email }">
			<input type="hidden" name="shippingFee" value="<%= shippingFee %>">
			<input type="hidden" name="totalPrice" value="<%= totalPrice %>">
			<input type="hidden" name="userNo" value="${userNo }">
			<input type="submit" class="btn btn-warning btn-lg col-md-4" value="결제하기">
		</div>
		
		
		</form>
		<!-- /.row -->
	</div>
	<!-- /.container -->
	

	<!-- Footer -->
	<c:import url='/WEB-INF/views/includes/footer.jsp' />
	<!-- /.Footer -->

<script type="text/javascript">
	var popupX = (window.screen.width / 2) - (776 / 2);
	var popupY = (window.screen.height / 2) - (700 / 2);
	
	function popup() {
		 var url = "${pageContext.servletContext.contextPath }/user/address";
         var name = "popup test";
         var option = "width = 776, height = 700, top =  "+ popupY +", left = "+ popupX +", location = no"
         window.open(url, name, option);
	}
	
	var hello = function(data){
		var td = $('#recipient-info-table td');
		td[0].innerHTML = data.recipientName;
		td[1].innerHTML = data.address;
		td[2].innerHTML = data.recipientPhone;
		td[3].innerHTML = data.entrancePassword;
		td[4].innerHTML = data.message;
		
		$('#recipient-info').empty();
		html = '';
		html += '<input type="hidden" name="name" value="'+ data.recipientName +'">';
		html += '<input type="hidden" name="address" value="'+ data.address +'">';
		html += '<input type="hidden" name="phone" value="'+ data.recipientPhone +'">';
		html += '<input type="hidden" name="entrancePassword" value="'+ data.entrancePassword +'">';
		html += '<input type="hidden" name="shippingMessage" value="'+ data.message +'">';
		
		$('#recipient-info').append(html);
		
		
		console.log(data);
	}
</script>

</body>

</html>
