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

</head>

<body id="page-top">

	<!-- navbar -->
	<c:import url='/WEB-INF/views/admin/includes/navbar.jsp'>
	</c:import>
	<!--/navbar -->

	<div id="wrapper">

		<!-- Sidebar -->
		<c:import url='/WEB-INF/views/admin/includes/sidebar.jsp'>
		</c:import>
		<!-- /Sidebar -->

		<div id="content-wrapper">

			<div class="container-fluid">

				<!-- Breadcrumbs -->
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="#">User</a></li>
					<li class="breadcrumb-item active">List</li>
				</ol>

				<!-- Category DataTables -->
				<div class="card mb-3">
					<div class="card-header">
						<i class="fas fa-table"></i> User Data Table
					</div>
					<div class="card-body">
						<div class="table-responsive">
							<table class="table table-bordered" id="dataTable" width="100%"
								cellspacing="0">
								<thead>
									<tr>
										<th>No</th>
										<th>ID</th>
										<th>Name</th>
										<th>Phone</th>
										<th>Email</th>
										<th>Birth</th>
										<th>Gender</th>
										<th>Role</th>
										<th>Del</th>
									</tr>
								</thead>
								<tfoot>
									<tr>
										<th>No</th>
										<th>ID</th>
										<th>Name</th>
										<th>Phone</th>
										<th>Email</th>
										<th>Birth</th>
										<th>Gender</th>
										<th>Role</th>
										<th>Del</th>
									</tr>
								</tfoot>
								<tbody>
								<c:forEach items="${userList }" var="vo" varStatus="status">
									<tr>
										<td>${vo.no }</td>
										<td>${vo.id }</td>
										<td>${vo.name }</td>
										<td>${vo.phone }</td>
										<td>${vo.email }</td>
										<td>${vo.birth }</td>
										<td>${vo.gender }</td>
										<td>${vo.role }</td>
										<td><a class="btn btn-danger" href="${pageContext.servletContext.contextPath }/admin/user/delete/${vo.no}">X</a></td>
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

	<c:import url='/WEB-INF/views/admin/includes/logoutModal.jsp'>
	</c:import>

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
		src="${pageContext.servletContext.contextPath }/assets/vendor/chart.js/Chart.min.js"></script>
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
	<script
		src="${pageContext.servletContext.contextPath }/assets/js/admin/demo/chart-area-demo.js"></script>


</body>

</html>
