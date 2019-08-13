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
						<input type="text" name="" id="zip-code" class="postcodify_postcode5 form-control" value="" placeholder="우편번호" style="width: 20%; margin-left: 15px;"/>
						<button id="postcodify_search_button" class="btn btn-primary">검색</button><br />
					</div>
					<input type="text" name="" id="address-1" class="postcodify_address form-control" value="" placeholder="주소"/><br />
					<input type="text" name="" id="address-2" class="postcodify_details form-control" value="" placeholder="상세주소"/><br />
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
					<button class="btn btn-light btn-lg" id="add-address-btn">배송지 추가 +</button>
				</td>
			</tr>
		</table>	

		
		<table class="table table-bordered order-info mt-4">
			<tbody id="address-table-tbody">
			</tbody>
		</table>	
				
		<!-- /.row -->
	</div>
	<!-- /.container -->
	

	<!-- Footer -->
	<c:import url='/WEB-INF/views/includes/footer.jsp' />
	<!-- /.Footer -->

	<!-- jQuery와 Postcodify를 로딩한다 -->
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
	<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>

	<!-- "검색" 단추를 누르면 팝업 레이어가 열리도록 설정한다 -->
	<script> $(function() { $("#postcodify_search_button").postcodifyPopUp(); }); </script>

	<script type="text/javascript">
	
	
	function modifyAddress(addressNo, btn) {
		var td = $(btn).parent().parent();
		var pList = td.children();
		
		//var recipientName = pList[0].;
		var recipientPhone = '';
		var address = '';
		var entrancePassword = '';
		var message = '';
		
		for (var i = 0; i < pList.length - 1; i++) {
			
		}
		
		console.log(pList);
		
		//console.log(btn.typeof);
		//console.log(addressNo);
	}
	
	function selectAddress(addressNo, btn) {
		var td = $(btn).parent().parent();
		var pList = td.children();
		
		window.opener.hello({
			recipientName : pList[0].innerHTML,	
			recipientPhone : pList[1].innerHTML,	
			address : pList[2].innerHTML,	
			entrancePassword : pList[3].innerHTML,	
			message : pList[4].innerHTML
		});
		
		window.close();
	}
	
	
	function getAddressList() {
		var userNo = ${userNo};
		$.ajax({
			url: "${pageContext.servletContext.contextPath}/api/user/address?userno=" + userNo,
			type: "get",
			dataType: "json",
			success: function (response) {
				var data = response.data;
				console.log(response);

				$('#address-table-tbody').empty();
				for (var i = 0; i < data.length; i++) {
					var html = '';
					html += '<tr>';
					html += '<td>';
					html += '<p>'+ data[i].recipientName +'</p>';
					html += '<p>'+ data[i].recipientPhone +'</p>';
					html += '<p>'+ data[i].address +'</p>';
					html += '<p>'+ data[i].entrancePassword +'</p>';
					html += '<p>'+ data[i].message +'</p>';
					html += '<div class="row">';
					html += '<button class="btn btn-secondary ml-3 btn-lg" onclick="modifyAddress('+ data[i].no +', this)">수정</button>';
					html += '<button class="btn btn-primary btn-lg" style="margin-left: 510px;" onclick="selectAddress('+ data[i].no +', this)">선택</button>';
					html += '</div>';
					html += '</td>';
					html += '</tr>';
					$('#address-table-tbody').append(html); 
				}
			},
			error : function (jqXHR, status, e) {
				console.error(status + " : " + e);
			}
		});
	}
	
	$(function () {
		
		$('#add-address-btn').on('click', function () {
			var user_no = ${userNo};
			var addressVo = {
				"zipCode" : $('#zip-code').val(),
				"address" : $('#address-1').val() + " " + $('#address-2').val(),
				"entrancePassword" : $('#entrance-password').val(),
				"message" : $('#message').val(),
				"userNo" : user_no,
				"recipientName" : $('#recipient-name').val(),
				"recipientPhone" : $('#recipient-phone').val()
			};
			
			$.ajax({
				url: "${pageContext.servletContext.contextPath}/api/user/address",
				type: "post",
				contentType: "application/json; charset=utf-8",
				dataType: "json",
				data: JSON.stringify(addressVo),
				success: function (response) {
					console.log(response);
					
					if(response.result == "success"){
						$('#zip-code').val('');
						$('#address-1').val('');
						$('#address-2').val('');
						$('#entrance-password').val('');
						$('#message').val('');
						$('#recipient-name').val('');
						$('#recipient-phone').val('');
					}
					
					getAddressList();
					
				},
				error : function (jqXHR, status, e) {
					console.error(status + " : " + e);
				}
			});
			
		});
		
		getAddressList();
		
	});

	</script>


</body>

</html>
