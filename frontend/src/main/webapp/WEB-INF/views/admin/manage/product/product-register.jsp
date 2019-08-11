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

<!-- Editor - SummerNote -->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet">

<!-- FileUpload UI -->
<link
	href="${pageContext.servletContext.contextPath }/assets/css/admin/imageUpload.css"
	rel="stylesheet">


<style type="text/css">

#dataTable2 tr:hover {
	background-color: #00FF7F;
	cursor:pointer;
}

#dataTable3 tr:hover {
	background-color: #00FF7F;
	cursor:pointer;
}


</style>

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

		<form method="post" action="${pageContext.servletContext.contextPath }/admin/product/register">
			<div class="container-fluid">

				<!-- Breadcrumbs -->
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="#">Product</a></li>
					<li class="breadcrumb-item active">Register</li>
				</ol>

			    <div class="card mb-3">
			      <div class="card-header">Register an Product</div>
			      <div class="card-body">
			      
			        <div class="accordion" id="accordion-register">
					
					  <!-- 아코디언 1 - 기본정보 -->
					  <div class="card">
					    <div class="card-header" id="accordion-register-header-1">
					      <h2 class="mb-0">
					        <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#accordion-register-body-1" aria-expanded="true" aria-controls="accordion-register-body-1">
					          	기본정보
					        </button>
					      </h2>
					    </div>
					
					    <div id="accordion-register-body-1" class="collapse show" aria-labelledby="accordion-register-header-1" data-parent="#accordion-register">
					      <div class="card-body">
					      <input type="hidden" name="count" value="1000">
					      <table class="table">
							  <tbody>
							    <tr>
							      <th scope="row" style="width: 15%;">
							      	상품명
							      </th>
							      <td style="width: 85%">
							        <div class="form-group">
							            <div class="form-row">
							              <div class="col-md-6">
							                <div class="form-label-group">
							                  <input type="text" name="name" id="product-name" class="form-control" placeholder="Product name" required="required" autofocus="autofocus">
							                  <label for="product-name">Product name</label>
							                </div>
							              </div>
							            </div>
							          </div>
							      </td>
							    </tr>
							   
							    <tr>
							      <th scope="row" style="width: 15%;">
							      	가격
							      </th>
							      <td style="width: 85%">
							        <div class="form-group">
							            <div class="form-row">
							              <div class="col-md-6">
							                <div class="form-label-group">
							                  <input type="text" name="price" id="product-price" class="form-control" placeholder="Product price" required="required">
							                  <label for="product-price">Product price</label>
							                </div>
							              </div>
							            </div>
							          </div>
							      </td>
							    </tr>
							   
							    <tr>
							      <th scope="row" style="width: 15%;">
							      	배송비
							      </th>
							      <td style="width: 85%">
							        <div class="form-group">
							            <div class="form-row">
							              <div class="col-md-6">
							                <div class="form-label-group">
							                  <input type="text" name="shippingFee" id="product-shippingfee" class="form-control" placeholder="Shipping Fee" required="required">
							                  <label for="product-shippingfee">Shipping Fee</label>
							                </div>
							              </div>
							            </div>
							          </div>
							      </td>
							    </tr>
							   
							    <tr>
							      <th scope="row" style="width: 15%;">
							      	이미지
							      </th>
							      <td style="width: 85%">
							          <div class="form-group" >
							            <div class="form-row" id="imageUpload">
										   <div class="col-sm-3 imgUp">
										  	 <h5 class="mb-3 ml-1 img-title">대표이미지</h5>
										     <div class="imagePreview"></div>
										     <label class="btn btn-primary btn-upload col-md-12">
										       Upload<input type="file" class="uploadFile img" value="Upload Photo" style="width: 0px;height: 0px;overflow: hidden;">
											 </label>
										   </div><!-- col-2 -->
										   <i class="fa fa-plus imgAdd" style="line-height: 2;margin-top: 37px;margin-left: 6px;"></i>
							            </div>
							          </div>
							      </td>
							    </tr>
							    
							     
							    <tr>
							      <th scope="row" style="width: 15%;">
							      	상품설명
							      </th>
							      <td style="width: 85%">
							        <div class="form-group">
							            <div class="form-row">
							              <div class="col-md-12">
							                <div class="form-label-group">
                      						  <textarea name="detail" id="summernote" placeholder="상품 상세를 입력해주세요." required="required"></textarea>
							                  <label for="summernote"></label>
							                </div>
							              </div>
							            </div>
							          </div>
							      </td>
							    </tr>
							    
							  </tbody>
							</table>
						    
					      </div>
					    </div>
					  </div>
					  <!-- 아코디언 1 END - 기본정보 -->
					  
					  <!-- 아코디언 2 - 기본정보 -->
					  
					  <div class="card">
					    <div class="card-header" id="accordion-register-header-2">
					      <h2 class="mb-0">
					        <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#accordion-register-body-2" aria-expanded="false" aria-controls="accordion-register-body-2">
					          	쇼핑몰 진열설정
					        </button>
					      </h2>
					    </div>
					    <div id="accordion-register-body-2" class="collapse" aria-labelledby="accordion-register-header-2" data-parent="#accordion-register">
					      <div class="card-body">

							<table class="table">
							  <tbody>
							    <tr>
							      <th scope="row" style="width: 15%;">
							      	진열상태
							      </th>
							      <td style="width: 85%">
							        <div class="form-group">
							            <div class="form-row">
							              <div class="col-md-6 row">
								              <div class="custom-control custom-radio">
												<input type="radio" name="exhibitionAvailability" id="exhibitionAvailability-1" class="custom-control-input" value="true">
												<label class="custom-control-label" for="exhibitionAvailability-1">진열함</label>
											  </div>
											  <div class="custom-control custom-radio ml-4">
												<input type="radio" name="exhibitionAvailability" id="exhibitionAvailability-2" class="custom-control-input" value="false" checked="checked">
												<label class="custom-control-label" for="exhibitionAvailability-2">진열안함</label>
											  </div>
							              </div>
							            </div>
							          </div>
							      </td>
							    </tr>
							   
							    <tr>
							      <th scope="row" style="width: 15%;">
							      	판매상태
							      </th>
							      <td style="width: 85%">
							        <div class="form-group">
							            <div class="form-row">
							              <div class="col-md-6 row">
							                  <div class="custom-control custom-radio">
												<input type="radio" name="sailsStatus" id="sailsStatus-1" class="custom-control-input" value="true">
												<label class="custom-control-label" for="sailsStatus-1">판매함</label>
											  </div>
											  <div class="custom-control custom-radio ml-4">
												<input type="radio" name="sailsStatus" id="sailsStatus-2" class="custom-control-input" value="false" checked="checked">
												<label class="custom-control-label" for="sailsStatus-2">판매안함</label>
											  </div>
							              </div>
							            </div>
							          </div>
							      </td>
							    </tr>
							   
							    <tr>
							      <th scope="row" style="width: 15%;">
							      	진열순위
							      </th>
							      <td style="width: 85%">
							        <div class="form-group">
							            <div class="form-row">
							              <div class="col-md-6 row">
							                <div class="custom-control custom-checkbox">
												<input type="checkbox" name="exhibitionRank" id="exhibitionRank-1" class="custom-control-input" value="1" checked="checked">
												<label class="custom-control-label" for="exhibitionRank-1">추천상품</label>
											</div>
							                <div class="custom-control custom-checkbox ml-4">
												<input type="checkbox" name="exhibitionRank" id="exhibitionRank-2" class="custom-control-input" value="2">
												<label class="custom-control-label" for="exhibitionRank-2">신상품</label>
											</div>
							                <div class="custom-control custom-checkbox ml-4">
												<input type="checkbox" name="exhibitionRank" id="exhibitionRank-3" class="custom-control-input" value="3">
												<label class="custom-control-label" for="exhibitionRank-3">Best 100</label>
											</div>
							                <div class="custom-control custom-checkbox ml-4">
												<input type="checkbox" name="exhibitionRank" id="exhibitionRank-4" class="custom-control-input" value="4">
												<label class="custom-control-label" for="exhibitionRank-4">etc</label>
											</div>
							              </div>
							            </div>
							          </div>
							      </td>
							    </tr>
							    
							    <tr>
							      <th scope="row" style="width: 15%;">
							      	카테고리
							      </th>
							      
							      <td style="width: 85%">
							        <div class="form-group">
							        	<input type="hidden" name="categoryNo" id="selected-category-no" value="">
										<div class="row">
											<h2 class="mb-3">✅ Select Product's Category</h2>
										</div>
							            <div class="form-row mb-5">
											<div class="col-md-12">
											<table class="table table-bordered" id="dataTable2" width="100%"
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
													<tbody id="child-category-list">
													</tbody>
												</table>
											</div>
										</div>
										
										<div class="row">
											<h2 class="mb-3">➕ Add Category</h2>
										</div>
										
							            <div class="form-row">
							              <div class="col-md-7">
								              <div class="table-responsive">
												<table class="table table-bordered" id="dataTable1" width="100%"
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
													<tbody id="category-list">
													
													<%-- 	<c:forEach items="${categoryList }" var="vo" varStatus="status">
															<tr>
																<td>${vo.no }</td>
																<td>${vo.name }</td>
																<td>${vo.depth }</td>
																<td>${vo.parentsNo }</td>
																<td>${vo.groupNo }</td>
															</tr>
														</c:forEach> --%>
													</tbody>
												</table>
											  </div>
							              
							              
							              </div>
							              <div class="col-md-5" style="margin-top: 50px;">
									          <div class="form-group">
									            <div class="form-row">
									              <div class="col-md-12">
									                <div class="form-label-group">
									                  <input type="text" id="parents-category-name" class="form-control" placeholder="Category name" autofocus="autofocus">
									                  <label for="parents-category-name">Category name</label>
									                </div>
									              </div>
									            </div>
									          </div>
									          <div class="form-group">
									            <div class="form-row">
									              <div class="col-md-12">
									                <div class="form-label-group">
									                  <input type="text" name="depth" id="parents-depth" class="form-control" placeholder="Depth">
									                  <label for="parents-depth">Depth</label>
									                </div>
									              </div>
									            </div>
									          </div>
  								           	<button type="button" class="btn btn-primary btn-block col-md-12" id="parents-category-button">add Parents_Category</button>
									        
									        <br>
									        
									          <div class="form-group">
									            <div class="form-row">
									              <div class="col-md-12">
									                <div class="form-label-group">
									                  <input type="text" id="child-category-name" class="form-control" placeholder="Category name" autofocus="autofocus">
									                  <label for="child-category-name">Category name</label>
									                </div>
									              </div>
									            </div>
									          </div>
									          <div class="form-group">
									            <div class="form-row">
									              <div class="col-md-12">
									                <div class="form-label-group">
									                  <input type="text" name="depth" id="child-depth" class="form-control" placeholder="Depth">
									                  <label for="child-depth">Depth</label>
									                </div>
									              </div>
									            </div>
									          </div>
									          <div class="form-group">
									            <div class="form-row">
									              <div class="col-md-12">
									                <div class="form-label-group">
									                  <input type="text" name="parentsNo" id="parents-no" class="form-control" placeholder="Parents no">
									                  <label for="parents-no">Parents no</label>
									                </div>
									              </div>
									            </div>
									          </div>
									          <div class="form-group">
									            <div class="form-row">
									              <div class="col-md-12">
									                <div class="form-label-group">
									                  <input type="text" name="groupNo" id="group-no" class="form-control" placeholder="Group no">
									                  <label for="group-no">Group no</label>
									                </div>
									              </div>
									            </div>
									          </div>
									          <button type="button" class="btn btn-warning btn-block col-md-12" id="child-category-button">add Child_Category</button>
									        
							              </div>
							            </div>
							          </div>
							      </td>
							    </tr>
							    
							    
							  </tbody>
							</table>
	
					      </div>
					    </div>
					  </div>
					  <div class="card">
					    <div class="card-header" id="accordion-register-header-3">
					      <h2 class="mb-0">
					        <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#accordion-register-body-3" aria-expanded="false" aria-controls="accordion-register-body-3">
					       		옵션설정
					        </button>
					      </h2>
					    </div>
					    <div id="accordion-register-body-3" class="collapse" aria-labelledby="accordion-register-header-3" data-parent="#accordion-register">
					      <div class="card-body">
					  		<table class="table">
							  <tbody>
							    <tr>
							      <th scope="row" style="width: 15%;">
							      	상품옵션
							      </th>
							      <td style="width: 85%">
							        <div class="form-group">
							            <div class="form-row">
							              <div class="col-md-6 row">
							                  <div class="custom-control custom-radio">
												<input type="radio" name="optionAvailability" id="optionAvailability-1" class="custom-control-input" value="true">
												<label class="custom-control-label" for="optionAvailability-1">사용함</label>
											  </div>
											  <div class="custom-control custom-radio ml-4">
												<input type="radio" name="optionAvailability" id="optionAvailability-2" class="custom-control-input" value="false" checked="checked">
												<label class="custom-control-label" for="optionAvailability-2">사용안함</label>
											  </div>
							              </div>
							            </div>
							          </div>
							      </td>
							    </tr>
							    
							    <tr id="option-setting" style="display: none;">
							      <th scope="row" style="width: 15%;">
							      	옵션설정
							      </th>
							      <td style="width: 40%">
							        <div class="form-group">
							            <div class="form-row">
											<div class="col-md-12">
											<table class="table table-bordered" id="dataTable3" width="100%"
													cellspacing="0">
													<thead>
														<tr>
															<th style="width: 20%;">No</th>
															<th style="width: 80%;">Name</th>
														</tr>
													</thead>
													<tfoot>
														<tr>
															<th style="width: 20%;">No</th>
															<th style="width: 80%;">Name</th>
														</tr>
													</tfoot>
													<tbody id="optionname-list">
													</tbody>
												</table>
											</div>
										</div>
							          </div>
							          <h5>추가할 옵션</h5>
							          <div class="form-group" id="hidden-option">

							          </div>
							          
							          <div id="view-addOption"></div>
							          <div class="form-group">
							          	<div class="form-row">
								          <div class="col-md-12">
											<table class="table table-bordered" id="dataTable4" width="100%"
														cellspacing="0" style="display: none;">
												<thead>
													<tr>
														<th style="width: 20%;">Optionname No</th>
														<th style="width: 25%;">Name</th>
														<th style="width: 55%;">Value</th>
													</tr>
												</thead>
												<tbody id="optionAdd-list">
												</tbody>
											</table>
										  </div>
										</div>
									 </div>
									 <div class="form-group">
							          	<div class="form-row">
								          <div class="col-md-12">
											<table class="table table-bordered" id="dataTable5" width="100%"
														cellspacing="0" style="display: none;">
												<thead>
													<tr>
														<th style="width: 20%;">Optionname No</th>
														<th style="width: 25%;">Name</th>
														<th style="width: 55%;">Value</th>
													</tr>
												</thead>
												<tbody id="optionAdd-list-2">
												</tbody>
											</table>
										  </div>
										</div>
									 </div>
									 <div class="form-group">
									 	<div class="form-row" style="float: right;">
											<button type="button" class="btn btn-primary btn-lg" id="option-cartesian">옵션품목 만들기</button>									 	
									 	</div>
									 </div>
									 
									 <div class="form-group" style="margin-top: 80px;">
							          	<div class="form-row">
								          <div class="col-md-12">
											<table class="table table-bordered" id="dataTable6" width="100%"
														cellspacing="0" style="display: none;">
												<thead>
													<tr>
														<th style="width: 30%;">옵션</th>
														<th style="width: 20%;">부가세</th>
														<th style="width: 30%;">재고설정</th>
														<th style="width: 20%;">수량</th>
													</tr>
												</thead>
												<tbody id="optionAdd-list-3">
												</tbody>
											</table>
										  </div>
										</div>
									 </div>
									 
							      </td>
							      
							    </tr>
							    
							  </tbody>
							</table>					      
					      </div>
					    </div>
					  </div>
					</div>
			       
			      </div>
			    </div>

			</div>
			<!-- /.container-fluid -->

			<!-- Sticky Footer -->
			<footer class="sticky-footer">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<button class="btn btn-primary btn-lg">상품등록</button>
					</div>
				</div>
			</footer>
	
		</form>  

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
	<!-- Editor - SummerNote -->
	<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>

	<!-- EJS -->
	<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/ejs/ejs.js"></script>

	<!-- FileUpload UI -->
	<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/admin/imageUpload.js"></script>

	
	<script type="text/javascript">

		
		 ////////////////////// import ejs template //////////////////////
		 var listTemplate = new EJS({
		     url : '${pageContext.request.contextPath }/assets/js/ejs-templates/category-list.ejs' 
		 });
		 var optionTemplate = new EJS({
		     url : '${pageContext.request.contextPath }/assets/js/ejs-templates/addOption.ejs' 
		 });
		 
		 //////////////////////////////////////////////////////////////////
		    
		 var render = function(vo, mode){
		    var html =  listItemTemplate.render(vo);
		      
		    if(mode){         
		       $("#category-list").prepend(html);          
		    }else{
		       $("#category-list").append(html);      
		    }
	    }
		var renderOption = function(no, mode){
		    var html =  optionTemplate.render(no);
		      
		    if(mode){         
		       $("#category-list").prepend(html);          
		    }else{
		       $("#category-list").append(html);      
		    }
	    }
		
		var getCategoryList = function () {
			$.ajax({
				url : "${pageContext.servletContext.contextPath }/api/admin/category/list",
				type: "get",
				dataType: "json",
				success: function(response){
						if(response.result != "success"){
			               console.error(response.message); 
			               return;
			            }
						
						$('#dataTable1').DataTable({
							data : response.data,
							columns : [
							{ data : 'no' },
							{ data : 'name' },
							{ data : 'depth' },
							{ data : 'parentsNo' },
							{ data : 'groupNo' }
							]
						});

						//var html = listTemplate.render(response);
				        //$("#category-list").append(html);
						
					 },            // jqeury XML Http Request
			         error : function(jqXHR, status, e){
			            console.error(status + " : " + e);
			         }
			});
		};
		
		var getChildCategoryList = function () {
			$.ajax({
				url : "${pageContext.servletContext.contextPath }/api/admin/category/list/child",
				type: "get",
				dataType: "json",
				success: function(response){
						if(response.result != "success"){
			               console.error(response.message); 
			               return;
			            }
						
						$('#dataTable2').DataTable({
							data : response.data,
							columns : [
							{ data : 'no' },
							{ data : 'name' },
							{ data : 'depth' },
							{ data : 'parentsNo' },
							{ data : 'groupNo' }
							]
						});

					 },            // jqeury XML Http Request
			         error : function(jqXHR, status, e){
			            console.error(status + " : " + e);
			         }
			});
		};
		
		var getOptionnameList = function () {
			$.ajax({
				url : "${pageContext.servletContext.contextPath }/api/admin/product/optionname/list",
				type: "get",
				dataType: "json",
				success: function(response){
						if(response.result != "success"){
			               console.error(response.message); 
			               return;
			            }
						
						$('#dataTable3').DataTable({
							data : response.data,
							columns : [
							{ data : 'no' },
							{ data : 'optionName' }
							]
						});

					 },            // jqeury XML Http Request
			         error : function(jqXHR, status, e){
			            console.error(status + " : " + e);
			         }
			});
		};
		
	$(function () {
		
		
		$('#optionAvailability-1').on('click', function () {
			$('#option-setting').show();
		});
		
		$('#optionAvailability-2').on('click', function () {
			$('#option-setting').hide();
		});		
		
		$('#dataTable3 tbody').on('click', 'tr', function () {
			var tr = $(this);
			var td = tr.children();
			var optionNo = td[0].innerHTML;
			var optionName = td[1].innerHTML;
			
			$('#dataTable3 tbody tr').css('background-color', '#FFFFFF');
			
			tr.css('background-color', '#00FF7F');
			
			var html = optionTemplate.render({'optionNo' : optionNo, 'optionName' : optionName});
	        $("#hidden-option").append(html);
			
	    } );
		
		
		 $(document).on("keydown", "#option-value-1",function(key) {
             if (key.keyCode == 13) {
            	var optionNo = $('#option-name-no-1').val();
         		var optionName = $('#option-name-1').val();
        		var optionValue = $('#option-value-1').val();
				
        		if($("#dataTable4").css("display") == "none"){   
        	        $('#dataTable4').show();  
        	    }  
        		
        		var html = '<tr><td style="width: 20%;">'+optionNo+'</td><td style="width: 25%;">'+optionName+'</td><td style="width: 55%;">'+optionValue+'</td></tr>';

        		$('#optionAdd-list').append(html);
        		$('#option-value-1').val('');
             }
         });
		 
		 $(document).on("keydown", "#option-value-2", function(key) {
             if (key.keyCode == 13) {
              	var optionNo = $('#option-name-no-2').val();
         		var optionName = $('#option-name-2').val();
        		var optionValue = $('#option-value-2').val();
				
        		if($("#dataTable5").css("display") == "none"){   
        	        $('#dataTable5').show();  
        	    }  
        		
        		var html = '<tr><td style="width: 20%;">'+optionNo+'</td><td style="width: 25%;">'+optionName+'</td><td style="width: 55%;">'+optionValue+'</td></tr>';

        		$('#optionAdd-list-2').append(html);
        		$('#option-value-2').val('');
             }
         });
		 
		$('#option-cartesian').on('click', function () {
			var option1 = $('#optionAdd-list');
			var tr1 = option1.children();
			var td1 = tr1.children();
			var option2 = $('#optionAdd-list-2');
			var tr2 = option2.children();
			var td2 = tr2.children();
			
			var optionValueList1 = new Set([]);
			var optionValueList2 = new Set([]);
			var optionFullValue = new Set([]);
			
			var html = '';
			
			var indexNo = 0;
			
			for (var i = 0; i < td1.length; i++) {
				if(i%3 == 0){
					html += '<input type="hidden" name="optionValueList['+parseInt(i/3)+'].optionNameNo" value="'+td1[i].innerHTML+'">';
				}else if(i%3 == 2){
					html += '<input type="hidden" name="optionValueList['+parseInt(i/3)+'].optionValue" value="'+td1[i].innerHTML+'">';
					optionValueList1.add(td1[i].innerHTML);
				}
				indexNo = i/3;
			}
			
			indexNo += 1;
			indexNo = parseInt(indexNo);
			for (var i = 0; i < td2.length; i++) {
				if(i%3 == 0){
					html += '<input type="hidden" name="optionValueList['+parseInt((i/3)+indexNo)+'].optionNameNo" value="'+td2[i].innerHTML+'">';
				}else if(i%3 == 2){
					html += '<input type="hidden" name="optionValueList['+parseInt((i/3)+indexNo)+'].optionValue" value="'+td2[i].innerHTML+'">';
					optionValueList2.add(td2[i].innerHTML);
				}
			}
			
			console.log(html);
			
			$('#hidden-option').append(html);
			
			var it1 = optionValueList1.values();
			var it2 = optionValueList2.values();
			
			var myArr1 = Array.from(it1);
			var myArr2 = Array.from(it2);
			
			console.log(myArr1);
			console.log(myArr2);
			
			for (var i = 0; i < myArr1.length; i++) {
				for (var j = 0; j < myArr2.length; j++) {
					optionFullValue.add(myArr1[i] + '/' + myArr2[j] );
				}
			}
			
			console.log(optionFullValue);
			
			var it3 =optionFullValue.values();
			
			var myArr3 = Array.from(it3);
			
			$('#dataTable6').show();
			
			for (var i = 0; i < myArr3.length; i++) {
				var html = '<input type="hidden" name="optionList['+i+'].optionValue" value="'+myArr3[i]+'">';
						
				$('#hidden-option').append(html);
        		var html2 = '<tr>';
        			html2+= '<td style="width: 30%;">'+myArr3[i]+'</td>';
        			html2+= '<td style="width: 20%;"><input type="text" class="form-control" name="optionList['+ i +'].additionalPrice" placeholder="부가세"></td>';
 
        			html2 += '<td style="width: 30%">'  
						   + '<div class="col-md-12 row">'        			
				  		   + '<div class="custom-control custom-radio">'
						   + '<input type="radio" name="optionList['+i+'].stockAvailability" id="stock-1" class="custom-control-input" value="true" checked="checked">'
						   + '<label class="custom-control-label" for="stock-1">사용함</label>'
				 		   + '</div>'
				  		   + '<div class="custom-control custom-radio ml-4">'
						   + '<input type="radio" name="optionList['+i+'].stockAvailability" id="stock-2" class="custom-control-input" value="false">'
						   + '<label class="custom-control-label" for="stock-2">사용안함</label>'
				 		   + '</div>'
				 		   + '</td>';
        			       + '</div>'
        			html2+= '<td style="width: 20%;"><input type="text" class="form-control" name="optionList['+ i +'].productCount" placeholder="개수"></td>';
        			html2+= '</tr>';

				$('#optionAdd-list-3').append(html2);
			}
			
			
			
		});
		
		$('#dataTable2 tbody').on('click', 'tr', function () {
			var tr = $(this);
			var td = tr.children();
			var categoryNo = td[0].innerHTML;
			
			$('#dataTable2 tbody tr').css('background-color', '#FFFFFF');
			
			tr.css('background-color', '#00FF7F');
			
			console.log($('#selected-category-no').val());
			$('#selected-category-no').val(categoryNo);
	    } );
		
			
		$('#parents-category-button').on("click", function () {
			$.ajax({
				url : "${pageContext.servletContext.contextPath }/api/admin/category",
				type: "post",
				contentType : "application/x-www-form-urlencoded; charset=utf-8" ,
				dataType: "json",
				data: {
						name :  $('#parents-category-name').val(),
						depth: $('#parents-depth').val()
					  },
				success: function(response){
						$('#dataTable1').DataTable().destroy();
						$('#dataTable2').DataTable().destroy();
						getCategoryList();
						getChildCategoryList();
					
						$('#child-category-name').val('');
						$('#child-depth').val('')
						$('#parents-no').val('')
						$('#group-no').val('')
			         },            // jqeury XML Http Request
			         error : function(jqXHR, status, e){
			            console.error(status + " : " + e);
			         }
			});
			
		});	
		
		$('#child-category-button').on("click", function () {
			$.ajax({
				url : "${pageContext.servletContext.contextPath }/api/admin/category",
				type: "post",
				contentType : "application/x-www-form-urlencoded; charset=utf-8" ,
				dataType: "json",
				data: {
						name :  $('#child-category-name').val(),
						depth: $('#child-depth').val(),
						parentsNo: $('#parents-no').val(),
						groupNo: $('#group-no').val()
					  },
				success: function(response){
						$('#dataTable1').DataTable().destroy();
						$('#dataTable2').DataTable().destroy();
						getCategoryList();
						getChildCategoryList();
						
						$('#child-category-name').val('');
						$('#child-depth').val('')
						$('#parents-no').val('')
						$('#group-no').val('')
			         },            // jqeury XML Http Request
			         error : function(jqXHR, status, e){
			            console.error(status + " : " + e);
			         }
			});
			
		});	
		
		getCategoryList();
		getChildCategoryList();	
		getOptionnameList();
	});
	</script>
	
	<!-- Summernote -->
	<script type="text/javascript">
	$(function(){
		$('#summernote').summernote({
			height: 600,
	        minHeight: null,             // set minimum height of editor
	        maxHeight: null,             // set maximum height of editor
			fontNames : [ '맑은고딕', 'Arial', 'Arial Black', 'Comic Sans MS', 'Courier New', ],
			fontNamesIgnoreCheck : [ '맑은고딕' ],
			focus: true,
			
			callbacks: {
				onImageUpload: function(files, editor, welEditable) {
		            for (var i = files.length - 1; i >= 0; i--) {
		            	sendFile(files[i], this);
		            }
		        }
			}
			
		});

	})
	
	function sendFile(file, el) {
		var form_data = new FormData();
      	form_data.append('file', file);
      	$.ajax({
        	data: form_data,
        	type: "POST",
        	url: '/productImageUploadAjax',
        	cache: false,
        	contentType: false,
        	dataType: 'json',
        	enctype: 'multipart/form-data',
        	processData: false,
        	success: function(img_name) {
          		$(el).summernote('editor.insertImage', img_name);
        	}
      	});
    }	
	
	
	</script>
</body>

</html>
