<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Code By Web Dev Trick ( https://webdevtrick.com) -->
<html>
<head>
<meta charset="UTF-8">
<title>Dynamic</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Raleway:400,100,300,200,500,600,700,800,900">

<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/assets/css/banner.css">

</head>

<body>

	<div class="intro">
		<div class="animated-bar"></div>

		<div class="slide slide-a">
			<div class="slide-content">
				<p class="slide-a-child">github.com/Googleok</p>
				<h1 class="slide-a-child">This Is Eok's Shop</h1>
				<p class="slide-a-child">This is New and Fresh Shoppingmall</p>
			</div>
		</div>

		<div class="slide slide-b">
			<div class="slide-content">
				<h2 class="slide-b-child">What We Share?</h2>
				<p class="slide-b-child">Tee, Shirt, Pants and Shoes</p>
				<p class="slide-b-child">From Cafe24 And Google Design,
					Ceo &amp; Park JongEok</p>
			</div>
		</div>

		<div class="slide slide-c">
			<div class="slide-content">
				<h2 class="slide-c-child">This Shop Is For</h2>
				<ul>
					<li class="slide-c-child"><p>Children</p></li>
					<li class="slide-c-child"><p>Young People</p></li>
					<li class="slide-c-child"><p>Old People</p></li>
					<li class="slide-c-child"><p>Everyone</p></li>
				</ul>
			</div>
		</div>

		<div class="slide slide-d">
			<div class="slide-content">
				<h2 class="slide-d-child">Keep Visiting This Shop</h2>
				<p class="slide-d-child">
					Our Shop -<a href="${pageContext.servletContext.contextPath }/main" target="_blank">
						Eokshop.com</a>
				</p>
				<button class="slide-d-child replay">Go</button>
			</div>
		</div>

	</div>
	<script	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
	<script src="${pageContext.servletContext.contextPath }/assets/js/banner.js"></script>
</body>

</html>
