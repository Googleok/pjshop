<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="#">Eok's Shop</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">

				<c:choose>
					<c:when test='${param.active == "login" }'>
						<sec:authorize access="isAuthenticated()">
							<li class="nav-item">
								<a class="nav-link" href="${pageContext.servletContext.contextPath }/main">홈</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="${pageContext.servletContext.contextPath }/user/cart">장바구니</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="${pageContext.servletContext.contextPath }/cs">고객센터</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="${pageContext.servletContext.contextPath }/user/logout">로그아웃</a>
							</li>
						</sec:authorize>
						<sec:authorize access="!isAuthenticated()">
							<li class="nav-item">
								<a class="nav-link" href="${pageContext.servletContext.contextPath }/main">홈</a>
							</li>
							<li class="nav-item active">
								<a class="nav-link" href="${pageContext.servletContext.contextPath }/user/login">로그인<span class="sr-only">(current)</span></a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="${pageContext.servletContext.contextPath }/user/join">회원가입</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="${pageContext.servletContext.contextPath }/cs">고객센터</a>
							</li>
						</sec:authorize>
					</c:when>
					<c:when test='${param.active == "join" }'>
						<sec:authorize access="isAuthenticated()">
							<li class="nav-item">
								<a class="nav-link" href="${pageContext.servletContext.contextPath }/main">홈</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="${pageContext.servletContext.contextPath }/user/cart">장바구니</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="${pageContext.servletContext.contextPath }/cs">고객센터</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="${pageContext.servletContext.contextPath }/user/logout">로그아웃</a>
							</li>
						</sec:authorize>
						<sec:authorize access="!isAuthenticated()">
							<li class="nav-item">
								<a class="nav-link" href="${pageContext.servletContext.contextPath }/main">홈</a>
							</li>
							<li class="nav-item active">
								<a class="nav-link" href="${pageContext.servletContext.contextPath }/user/login">로그인<span class="sr-only">(current)</span></a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="${pageContext.servletContext.contextPath }/user/join">회원가입</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="${pageContext.servletContext.contextPath }/cs">고객센터</a>
							</li>
							
						</sec:authorize>
					</c:when>
					<c:when test='${param.active == "cs" }'>
						<sec:authorize access="isAuthenticated()">
							<li class="nav-item">
								<a class="nav-link" href="${pageContext.servletContext.contextPath }/main">홈</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="${pageContext.servletContext.contextPath }/user/cart">장바구니</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="${pageContext.servletContext.contextPath }/cs">고객센터</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="${pageContext.servletContext.contextPath }/user/logout">로그아웃</a>
							</li>
						</sec:authorize>
						<sec:authorize access="!isAuthenticated()">
							<li class="nav-item">
								<a class="nav-link" href="${pageContext.servletContext.contextPath }/main">홈</a>
							</li>
							<li class="nav-item active">
								<a class="nav-link" href="${pageContext.servletContext.contextPath }/user/login">로그인<span class="sr-only">(current)</span></a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="${pageContext.servletContext.contextPath }/user/join">회원가입</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="${pageContext.servletContext.contextPath }/cs">고객센터</a>
							</li>
							
						</sec:authorize>
					</c:when>					
					<c:otherwise>
					<sec:authorize access="isAuthenticated()">
							<li class="nav-item">
								<a class="nav-link" href="${pageContext.servletContext.contextPath }/main">홈</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="${pageContext.servletContext.contextPath }/user/cart">장바구니</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="${pageContext.servletContext.contextPath }/cs">고객센터</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="${pageContext.servletContext.contextPath }/user/logout">로그아웃</a>
							</li>
						</sec:authorize>
						<sec:authorize access="!isAuthenticated()">
							<li class="nav-item">
								<a class="nav-link" href="${pageContext.servletContext.contextPath }/main">홈</a>
							</li>
							<li class="nav-item active">
								<a class="nav-link" href="${pageContext.servletContext.contextPath }/user/login">로그인<span class="sr-only">(current)</span></a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="${pageContext.servletContext.contextPath }/user/join">회원가입</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="${pageContext.servletContext.contextPath }/cs">고객센터</a>
							</li>
							
						</sec:authorize>
					</c:otherwise>				
				</c:choose>
			</ul>
		</div>
	</div>
</nav>