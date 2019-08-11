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
			<a class="nav-link" href="${pageContext.servletContext.contextPath }/user/cart"> 
			<i class="fas fa-fw fa-shopping-cart"></i> <span>장바구니</span>
			</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="${pageContext.servletContext.contextPath }/user/order">
					<i class="fas fa-fw fa-shipping-fast"></i> <span>주문목록/배송조회</span>
				</a>
			</li>
			<li class="nav-item"><a class="nav-link"
				href="${pageContext.servletContext.contextPath }/user/update">
					<i class="fas fa-fw fa-user-alt"></i> <span>개인정보수정</span>
			</a></li>
		</ul>
</body>
</html>