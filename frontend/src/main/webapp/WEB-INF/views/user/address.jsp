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
	<style type="text/css">
	.navbar-header {
    float: left;
    padding: 15px;
    text-align: center;
    font-size : 1rem;
    font-weight: bold;
    width: 100%;
    color: white;
	}
	</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<span class="navbar-header" >배송지 추가</span>
		</div>
	</nav>
	
	<div class="container">
	
		<table class="table table-bordered order-info mt-4">
			<tr>
				<th>수취인</th>
				<td>
					<input type="text" name="recipientName" id="recipient-name" class="form-control" placeholder="Recipient name" required="required" autofocus="autofocus">
				</td>
			</tr>
			<tr>
				<th>휴대폰번호</th>
				<td>
					<input type="text" name="recipientPhone" id="recipient-phone" class="form-control" placeholder="Recipient phone" required="required">
				</td>
			</tr>
			<tr>
				<th>주소</th>
				<td>
				<div class="container">
					<div class="row mb-4" >
						<input type="text" name="" class="postcodify_postcode5 form-control" value="" placeholder="우편번호" style="width: 20%; margin-left: 15px;"/>
						<button id="postcodify_search_button" class="btn btn-primary">검색</button><br />
					</div>
					<input type="text" name="" class="postcodify_address form-control" value="" placeholder="주소"/><br />
					<input type="text" name="" class="postcodify_details form-control" value="" placeholder="상세주소"/><br />
				</div>
				</td>
			</tr>
			<tr>
				<th>현관비밀번호</th>
				<td>
					<input type="text" name="entrancePassword" id="entrance-password" class="form-control" placeholder="Entrance password" required="required">
				</td>
			</tr>
			<tr>
				<th>배송메시지</th>
				<td>
					<input type="text" name="message" id="message" class="form-control" placeholder="Message" required="required">
				</td>
			</tr>
			<tr>
				<th>
				배송
				</th>
				<td>
					<button class="btn btn-light btn-lg">배송지 추가 +</button>
				</td>
			</tr>
		</table>	

		
		<table class="table table-bordered order-info mt-4">
			<tr>
				<td>
				<p>박종억</p>
				<p>01040287755</p>
				<p>서울특별시 관악구 신림동 1458-10 샤인에비뉴, 203호</p>
				<p>2812*</p>
				<p>직접 받고 부재 시 문 앞</p>
				<div class="row">
					<button class="btn btn-secondary ml-3 btn-lg">수정</button>
					<button class="btn btn-primary btn-lg" style="margin-left: 340px;">선택</button>
				</div>
				</td>
			</tr>
		</table>	
				
		<!-- /.row -->
	</div>
	<!-- /.container -->
	

	<!-- Footer -->
	<c:import url='/WEB-INF/views/includes/footer.jsp' />
	<!-- /.Footer -->

	<script type="text/javascript">
	function popup() {
		 var url = "${pageContext.servletContext.contextPath }/main";
         var name = "popup test";
         var option = "width = 500, height = 500, top = 100, left = 200, location = no"
         window.open(url, name, option);
	}
	
	</script>
	<!-- jQuery와 Postcodify를 로딩한다 -->
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
	<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>

	<!-- "검색" 단추를 누르면 팝업 레이어가 열리도록 설정한다 -->
	<script> $(function() { $("#postcodify_search_button").postcodifyPopUp(); }); </script>

</body>

</html>
