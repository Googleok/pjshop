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
										<th>No</th>
										<th>Name</th>
										<th>Price</th>
										<th>ReqDate</th>
										<th>Exhibition</th>
										<th>Option</th>
										<th>SailsStatus</th>
										<th>Rank</th>
										<th>Count</th>
										<th>ShippingFee</th>
										<th>CategoryNo</th>
										<th>Del</th>
									</tr>
								</thead>
								<tfoot>
									<tr>
										<th>No</th>
										<th>Name</th>
										<th>Price</th>
										<th>ReqDate</th>
										<th>Exhibition</th>
										<th>Option</th>
										<th>SailsStatus</th>
										<th>Rank</th>
										<th>Count</th>
										<th>ShippingFee</th>
										<th>CategoryNo</th>
										<th>Del</th>
									</tr>
								</tfoot>
								<tbody>
								<c:forEach items="${productList }" var="vo" varStatus="status">
									<tr>
										<td>${vo.no }</td>
										<td>${vo.name }</td>
										<td>${vo.price }</td>
										<td>${vo.regDate }</td>
										<td>${vo.exhibitionAvailability }</td>
										<td>${vo.optionAvailability }</td>
										<td>${vo.sailsStatus }</td>
										<td>${vo.exhibitionRank }</td>
										<td>${vo.count }</td>
										<td>${vo.shippingFee }</td>
										<td>${vo.categoryNo }</td>
										<td><a class="btn btn-danger" href="${pageContext.servletContext.contextPath }/admin/product/delete/${vo.no}">X</a></td>
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

	
</body>

</html>
