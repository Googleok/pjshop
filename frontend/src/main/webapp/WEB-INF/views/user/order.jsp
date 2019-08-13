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
										<th>수취인</th>
										<th>전화번호</th>
										<th>이메일</th>
										<th>주소</th>
										<th>배송메시지</th>
										<th>현관비밀번호</th>
										<th>등록일</th>
										<th>배송비</th>
										<th>총가격</th>
										<th>상세주문서</th>
									</tr>
								</thead>
								
								<tbody>
								<c:forEach items="${orderList }" var="vo" varStatus="status">
									<tr>
										<input type="hidden" value="${vo.no }">
										<td>${vo.name }</td>
										<td>${vo.phone }</td>
										<td>${vo.email }</td>
										<td>${vo.address }</td>
										<td>${vo.shippingMessage }</td>
										<td>${vo.entrancePassword }</td>
										<td>${vo.regDate }</td>
										<td>${vo.shippingFee }</td>
										<td>${vo.totalPrice }</td>
										<td><button class="btn btn-success" onclick="getDetail(${vo.no})">상세</button></td>
									</tr>
								</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
					<div class="card-footer small text-muted">Updated yesterday
						at 11:59 PM</div>
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
	
	
	
	<!-- Modal -->
	<div class="modal fade" id="orderDetailModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog modal-lg" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">상세 주문서</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body" id="orderDetailModal-body">
			
				<div class="table-responsive">
					<table class="table table-bordered" id="dataTable2" width="100%"
								cellspacing="0">
						<thead>
							<tr>
								<th>상품명</th>
								<th>옵션</th>
								<th>개수</th>
								<th>가격</th>
								<th>배송상태</th>
								<th>서비스</th>
							</tr>
						</thead>
								
						<tbody id="orderDetail-table-tbody">
						</tbody>
					</table>
				</div>
			

	      </div>
	      <div class="modal-footer">
	      </div>
	    </div>
	  </div>
	</div>
	
	
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
	
	function getDetail(orderNo) {
		
		$.ajax({
			url: "${pageContext.servletContext.contextPath }/api/order/detail/list/" + orderNo,
			type: "get",
			data: "json",
			success: function (response) {
				var data = response.data;
				console.log(response);
				$('#orderDetail-table-tbody').empty();
				for (var i = 0; i < data.length; i++) {
					var html = '';
					html += '<tr>';
					html += '<td>'+ data[i].productName +'</td>';
					html += '<td>'+ data[i].options +'</td>';
					html += '<td>'+ data[i].count +'</td>';
					html += '<td>'+ data[i].productPrice +'</td>';
					html += '<td>'+ data[i].shippingStatus +'</td>';
					html += '<td>';
					html += '<button class="btn btn-primary col-md-12">배송조회</button><br>';
					html += '<button class="btn btn-secondary col-md-12">교환신청</button><br>';
					html += '<button class="btn btn-secondary col-md-12">반품신청</button><br>';
					html += '<button class="btn btn-light col-md-12">구매후기 쓰기</button>';
					html += '</td>';
					html += '</tr>';
					$('#orderDetail-table-tbody').append(html); 
				}
				
				$('#orderDetailModal').modal();
			},
			error: function (j, s, e) {
				console.log(s + " : " + e);
			}
			
			
		})
		
		
	}
	
	</script>
	
</body>

</html>
