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
			      
			        <form method="post" action="${pageContext.servletContext.contextPath }/api/admin/category">
			          <div class="form-group">
			            <div class="form-row">
			              <div class="col-md-6">
			                <div class="form-label-group">
			                  <input type="text" name="name" id="parents-category-name" class="form-control" placeholder="Category name" required="required" autofocus="autofocus">
			                  <label for="parents-category-name">Category name</label>
			                </div>
			              </div>
			            </div>
			          </div>
			          <div class="form-group">
			            <div class="form-row">
			              <div class="col-md-6">
			                <div class="form-label-group">
			                  <input type="text" name="depth" id="parents-depth" class="form-control" placeholder="Depth" required="required">
			                  <label for="parents-depth">Depth</label>
			                </div>
			              </div>
			            </div>
			          </div>
			           <input class="btn btn-primary btn-block col-md-6" type="submit" value="add Parents_Category"/>
			        </form>
			        
			        <br>
			        
			         <form method="post" action="${pageContext.servletContext.contextPath }/api/admin/category">
			          <div class="form-group">
			            <div class="form-row">
			              <div class="col-md-6">
			                <div class="form-label-group">
			                  <input type="text" name="name" id="child-category-name" class="form-control" placeholder="Category name" required="required" autofocus="autofocus">
			                  <label for="child-category-name">Category name</label>
			                </div>
			              </div>
			            </div>
			          </div>
			          <div class="form-group">
			            <div class="form-row">
			              <div class="col-md-6">
			                <div class="form-label-group">
			                  <input type="text" name="depth" id="child-depth" class="form-control" placeholder="Depth" required="required">
			                  <label for="child-depth">Depth</label>
			                </div>
			              </div>
			            </div>
			          </div>
			          <div class="form-group">
			            <div class="form-row">
			              <div class="col-md-6">
			                <div class="form-label-group">
			                  <input type="text" name="parentsNo" id="parents-no" class="form-control" placeholder="Parents no" required="required">
			                  <label for="parents-no">Parents no</label>
			                </div>
			              </div>
			            </div>
			          </div>
			          <div class="form-group">
			            <div class="form-row">
			              <div class="col-md-6">
			                <div class="form-label-group">
			                  <input type="text" name="groupNo" id="group-no" class="form-control" placeholder="Group no" required="required">
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







	<script type="text/javascript">
	
	$(function () {
		
		var render = function(vo, mode){
		      // 실제로는 template library를 사용한다. (html 렌더링 라이브러리)
		      // -> ejs, underscore, mustache
		/*       var html =  "<li data-no='"+ vo.no +"'>"+
		                  "<strong>"+vo.name+"</strong>"+
		                                    // 이 문자열의 모든(g)거에 다 적용해라 . \n -> <br>
		                  "<p>"+ vo.contents.replace(/</gi, "&lt;").replace(/>/gi, "&gt;").replace(/\n/gi, "<br>") + "</p><br>"+
		                  "<strong></strong>"+
		                  "<a href='#' data-no='"+ vo.no +"'>삭제</a>"+ 
		               "</li>"; */ 
		               
		      var html =  listItemTemplate.render(vo);
		      
		      if(mode){         
		         $("#list-guestbook").prepend(html);          
		      }else{
		         $("#list-guestbook").append(html);      
		      }
		} 
		
		$.ajax({
			url : 	,
			type: 	,
			contentType: "application/json" ,
			dataType: "json",
			data: "",
			success: function(response){
		            if(response.result != "success"){
		               console.error(response.message); 
		               return;
		            }
		            
		            rendering
		            $.each(response.data, render); 
		            $.each(response.data, function(index, vo){
		               render(vo); 
		            });
		            var html = listTemplate.render(response);
		            $("#list-guestbook").append(html);
		            
		         },            // jqeury XML Http Request
		         error : function(jqXHR, status, e){
		            console.error(status + " : " + e);
		         }
		})
		console.log('test')
	});
	
	</script>






</body>

</html>
