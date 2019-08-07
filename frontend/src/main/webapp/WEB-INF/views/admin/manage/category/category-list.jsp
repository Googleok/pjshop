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
					<li class="breadcrumb-item"><a href="#">Category</a></li>
					<li class="breadcrumb-item active">List</li>
				</ol>

			    <div class="card mb-3">
			      <div class="card-header">Register an Category</div>
			      <div class="card-body">
			      
			        <form method="post" action="/admin/category">
			          <div class="form-group">
			            <div class="form-row">
			              <div class="col-md-6">
			                <div class="form-label-group">
			                  <input type="text" id="parents-category-name" class="form-control" placeholder="Category name" required="required" autofocus="autofocus">
			                  <label for="parents-category-name">Category name</label>
			                </div>
			              </div>
			            </div>
			          </div>
			          <div class="form-group">
			            <div class="form-row">
			              <div class="col-md-6">
			                <div class="form-label-group">
			                  <input type="text" id="parents-depth" class="form-control" placeholder="Depth" required="required">
			                  <label for="parents-depth">Depth</label>
			                </div>
			              </div>
			            </div>
			          </div>
			           <input class="btn btn-primary btn-block col-md-6" type="submit" value="add Parents_Category"/>
			        </form>
			        
			        <br>
			        
			         <form method="post" action="/admin/category">
			          <div class="form-group">
			            <div class="form-row">
			              <div class="col-md-6">
			                <div class="form-label-group">
			                  <input type="text" id="child-category-name" class="form-control" placeholder="Category name" required="required" autofocus="autofocus">
			                  <label for="child-category-name">Category name</label>
			                </div>
			              </div>
			            </div>
			          </div>
			          <div class="form-group">
			            <div class="form-row">
			              <div class="col-md-6">
			                <div class="form-label-group">
			                  <input type="text" id="child-depth" class="form-control" placeholder="Depth" required="required">
			                  <label for="child-depth">Depth</label>
			                </div>
			              </div>
			            </div>
			          </div>
			          <div class="form-group">
			            <div class="form-row">
			              <div class="col-md-6">
			                <div class="form-label-group">
			                  <input type="text" id="parents-no" class="form-control" placeholder="Parents no" required="required">
			                  <label for="parents-no">Parents no</label>
			                </div>
			              </div>
			            </div>
			          </div>
			          <div class="form-group">
			            <div class="form-row">
			              <div class="col-md-6">
			                <div class="form-label-group">
			                  <input type="text" id="group-no" class="form-control" placeholder="Group no" required="required">
			                  <label for="group-no">Group no</label>
			                </div>
			              </div>
			            </div>
			          </div>
			          <input class="btn btn-warning btn-block col-md-6" type="submit" value="add Child_Category"/>
			        </form>
			       
			      </div>
			    </div>

				<!-- Category DataTables -->
				<div class="card mb-3">
					<div class="card-header">
						<i class="fas fa-table"></i> Category Data Table
					</div>
					<div class="card-body">
						<div class="table-responsive">
							<table class="table table-bordered" id="dataTable" width="100%"
								cellspacing="0">
								<thead>
									<tr>
										<th>No</th>
										<th>Name</th>
										<th>Depth</th>
										<th>Parents_No</th>
										<th>Group_No</th>
									</tr>
								</thead>
								<tfoot>
									<tr>
										<th>No</th>
										<th>Name</th>
										<th>Depth</th>
										<th>Parents_No</th>
										<th>Group_No</th>
									</tr>
								</tfoot>
								<tbody>
								<c:forEach items="${categoryList }" var="vo" varStatus="status">
									<tr>
										<td>${vo.no }</td>
										<td>${vo.name }</td>
										<td>${vo.depth }</td>
										<td>${vo.parentsNo }</td>
										<td>${vo.groupNo }</td>
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
