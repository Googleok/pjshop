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

<body>
<!-- Sidebar -->
		<ul class="sidebar navbar-nav">
			<li class="nav-item active">
			<a class="nav-link" href="${pageContext.servletContext.contextPath }/admin"> 
			<i class="fas fa-fw fa-tachometer-alt"></i> <span>Dashboard</span>
			</a>
			</li>
			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" href="#" id="pagesDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <i class="fas fa-fw fa-folder"></i> <span>쇼핑몰 관리</span>
				</a>
				<div class="dropdown-menu" aria-labelledby="pagesDropdown">
						
					<h6 class="dropdown-header">카테고리 관리:</h6>
					<a class="dropdown-item"
						href="${pageContext.servletContext.contextPath }/admin/category/list">카테고리 목록</a>
					<div class="dropdown-divider"></div>
					<h6 class="dropdown-header">상품 관리:</h6>
					<a class="dropdown-item"
						href="${pageContext.servletContext.contextPath }/admin/product/register">상품등록</a>
					<a class="dropdown-item"
						href="${pageContext.servletContext.contextPath }/admin/product/list">상품목록</a>
					<div class="dropdown-divider"></div>
					<h6 class="dropdown-header">고객 관리:</h6>
					<a class="dropdown-item"
						href="${pageContext.servletContext.contextPath }/admin/user/list">고객목록</a>
					<a class="dropdown-item"
						href="${pageContext.servletContext.contextPath }/admin/user/cart">고객장바구니목록</a>
					<div class="dropdown-divider"></div>
					<h6 class="dropdown-header">주문 관리:</h6>
					<a class="dropdown-item"
						href="${pageContext.servletContext.contextPath }/admin/blank">전체주문목록</a>
					<a class="dropdown-item"
						href="${pageContext.servletContext.contextPath }/admin/blank">배송관리</a>
				</div>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="${pageContext.servletContext.contextPath }/admin/charts">
					<i class="fas fa-fw fa-chart-area"></i> <span>통계분석</span>
				</a>
			</li>
			<li class="nav-item"><a class="nav-link"
				href="${pageContext.servletContext.contextPath }/admin/tables">
					<i class="fas fa-fw fa-table"></i> <span>Tables</span>
			</a></li>
		</ul>
</body>
</html>