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
</head>
<body>
	<!-- Navigation -->
	<c:import url='/WEB-INF/views/includes/navigation.jsp'>
		<c:param name="active" value="shopping" />
	</c:import>
	<!-- /.Navigation -->
	
	<div class="container">
		<div class="row">

			<div class="col-lg-3">
				<div style="width: 255px; height: 200px">
					<c:import url='/WEB-INF/views/includes/logo.jsp'>
					</c:import>
				</div>

				<div class="list-group" id="accordion">
				<c:forEach items="${categoryList }" var = "vo" varStatus="status">
	                <c:if test="${vo.depth == 1}">
	                <div class="panel panel-default">
	                    <div class="panel-heading">
	                        <h4 class="panel-title category-class">
	                            <a data-toggle="collapse" data-parent="#accordion" href="#collapse${vo.no }" class="list-group-item category-name"><span class="glyphicon glyphicon-folder-close">
	                            </span>${vo.name }</a>
	                        </h4>
	                    </div>
	                    
	                    <div id="collapse${vo.no }" class="panel-collapse collapse in">
	                        <div class="panel-body">
	                            <table class="table">
	                            	<c:set var="parentsNo" value="${vo.no }"></c:set>
									<c:forEach items="${categoryList }" var = "vo" varStatus="status">
									<c:if test="${vo.depth > 1 && vo.parentsNo == parentsNo}">
	                                <tr>
	                                    <td class="category-class">
	                                        <span class="glyphicon glyphicon-pencil text-primary"></span><a href="${pageContext.servletContext.contextPath }/product/list?category_no=${vo.no }" class="category-name">${vo.name }</a>
	                                    </td>
	                                </tr>
	                                </c:if>
									</c:forEach>
	                            </table>
	                        </div>
	                    </div>
	                </div>
	                </c:if>
				</c:forEach>
	            </div>
	            
			</div>
			
			<!-- /.col-lg-3 -->

			<div class="col-lg-9">
				<div id="carouselExampleIndicators" class="carousel slide my-4"
					data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#carouselExampleIndicators" data-slide-to="0"
							class="active"></li>
						<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
						<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
					</ol>
					<div class="carousel-inner" role="listbox">
						<div class="carousel-item active">
							<img class="d-block img-fluid" src="${pageContext.servletContext.contextPath }/assets/images/goods/jean-main.jpg" style="width: 900px; height: 500px;"
								alt="First slide">
						</div>
						<div class="carousel-item">
							<img class="d-block img-fluid" src="${pageContext.servletContext.contextPath }/assets/images/goods/adidas-tee-main.jpg" style="width: 900px; height: 500px;"
								alt="Second slide">
						</div>
						<div class="carousel-item">
							<img class="d-block img-fluid" src="${pageContext.servletContext.contextPath }/assets/images/goods/nike-tee_main.jpg" style="width: 900px; height: 500px;"
								alt="Third slide">
						</div>
					</div>
					<a class="carousel-control-prev" href="#carouselExampleIndicators"
						role="button" data-slide="prev"> <span
						class="carousel-control-prev-icon" aria-hidden="true"></span> <span
						class="sr-only">Previous</span>
					</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
						role="button" data-slide="next"> <span
						class="carousel-control-next-icon" aria-hidden="true"></span> <span
						class="sr-only">Next</span>
					</a>
				</div>

				<div class="row">
					<c:forEach items="${productList }" var="vo" varStatus="status">
						<div class="col-lg-4 col-md-6 mb-4">
							<div class="card h-100">
								<a href="${pageContext.servletContext.contextPath }/product/detail/${vo.no }"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
								<div class="card-body">
									<h4 class="card-title">
										<a href="${pageContext.servletContext.contextPath }/product/detail/${vo.no }">${vo.name }</a>
									</h4>
									<h5>${vo.price }원</h5>
									<p class="card-text">Lorem ipsum dolor sit amet, consectetur
										adipisicing elit. Amet numquam aspernatur!</p>
								</div>
								<div class="card-footer">
									<small class="text-muted">&#9733; &#9733; &#9733;
										&#9733; &#9734;</small>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
				<!-- /.row -->
			</div>
			<!-- /.col-lg-9 -->
			
		</div>
		<!-- /.row -->
	</div>
	<!-- /.container -->
	

	<!-- Footer -->
	<c:import url='/WEB-INF/views/includes/footer.jsp' />
	<!-- /.Footer -->
</body>

</html>
