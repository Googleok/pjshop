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
		<form action="${pageContext.servletContext.contextPath }" method="post" >
	
		<div class="row">
			<h1 class="order-title">주문/결제</h1>
		</div>
		<hr style="border: 2px solid black; width: 100%; margin-right: 10px;">
		<div class="row">
			<h4 class="order-title">구매자정보</h4>
		</div>
		<table class="table table-bordered order-info">
			<tr>
				<th>이름</th>
				<td>박종억</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>whddjrw</td>
			</tr>
			<tr>
				<th>휴대폰번호</th>
				<td>010-4028-7755</td>
			</tr>
		</table>	
		
		<div class="row">
			<h4 class="order-title">받는사람정보</h4>
			<a href="javascript:popup()" class="btn btn-light mb-1 ml-2" style="bottom: 10px;">배송지변경</a>
		</div>
		<table class="table table-bordered order-info">
			<tr>
				<th>이름</th>
				<td>박종억</td>
			</tr>
			<tr>
				<th>배송주소</th>
				<td>서울특별시 관악구 신림동 1458-10 샤인에비뉴  203호</td>
			</tr>
			<tr>
				<th>휴대폰번호</th>
				<td>010-4028-7755</td>
			</tr>
			<tr>
				<th>공동 현관비밀번호</th>
				<td>2812*</td>
			</tr>
			<tr>
				<th>배송 요청사항</th>
				<td>직접 받고 부재 시 문 앞</td>
			</tr>
			
		</table>	
		
		<div class="row">
			<h4 class="order-title">결제정보</h4>
		</div>
		<table class="table table-bordered order-info">
			<tr>
				<th>총상품가격</th>
				<td>12900원</td>
			</tr>
			<tr>
				<th>배송비</th>
				<td>0원</td>
			</tr>
			<tr>
				<th>총결제금액</th>
				<td>12250원</td>
			</tr>
		</table>	
		<div class="container text-center mb-5">
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
	function popup() {
		 var url = "${pageContext.servletContext.contextPath }/user/address";
         var name = "popup test";
         var option = "width = 500, height = 500, top = 100, left = 200, location = no"
         window.open(url, name, option);
	}
</script>

</body>

</html>
