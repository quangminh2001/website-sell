<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- import JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="zxx" class="no-js">

<head>
<!-- Mobile Specific Meta -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Favicon-->
<link rel="shortcut icon" href="${base }/img/fav.png">
<!-- Author Meta -->
<meta name="author" content="CodePixar">
<!-- Meta Description -->
<meta name="description" content="">
<!-- Meta Keyword -->
<meta name="keywords" content="">
<!-- meta character set -->
<meta charset="UTF-8">
<!-- Site Title -->
<title>Karma Shop</title>

<jsp:include page="/WEB-INF/views/customer/layout/css.jsp"></jsp:include>
</head>

<body>

	<!-- Start Header Area -->
	<jsp:include page="/WEB-INF/views/customer/layout/header.jsp"></jsp:include>
	<!-- End Header Area -->

	<!-- Start Banner Area -->
	<section class="banner-area organic-breadcrumb">
		<div class="container">
			<div
				class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
				<div class="col-first">
					<h1>Blog Page</h1>
					<nav class="d-flex align-items-center">
						<a href="${base }/home">Home<span class="lnr lnr-arrow-right"></span></a>
						<a href="${base }/blog">Blog</a>
					</nav>
				</div>
			</div>
		</div>
	</section>
	<!-- End Banner Area -->

	<!--================Blog Categorie Area =================-->
	<section class="blog_categorie_area">
		<div class="container">
			<div class="row">
				<div class="col-lg-4">
					<div class="categories_post">
						<img src="img/blog/cat-post/cat-post-3.jpg" alt="post">
						<div class="categories_details">
							<div class="categories_text">
								<a href="${base }/blog?category=social-life">
									<h5>Social Life</h5>
								</a>
								<div class="border_line"></div>
								<p>Enjoy your social life together</p>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="categories_post">
						<img src="img/blog/cat-post/cat-post-2.jpg" alt="post">
						<div class="categories_details">
							<div class="categories_text">
								<a href="${base }/blog?category=politics">
									<h5>Politics</h5>
								</a>
								<div class="border_line"></div>
								<p>Be a part of politics</p>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="categories_post">
						<img src="img/blog/cat-post/cat-post-1.jpg" alt="post">
						<div class="categories_details">
							<div class="categories_text">
								<a href="${base }/blog?category=food">
									<h5>Food</h5>
								</a>
								<div class="border_line"></div>
								<p>Let the food be finished</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--================Blog Categorie Area =================-->

	<!--================Blog Area =================-->
	<section class="blog_area">
		<div class="container">
			<div class="row">
				<div class="col-lg-8">
					<div class="blog_left_sidebar">
						<c:if test="${empty search.data }">
							<h3 class="h3">Not found post</h3>
						</c:if>
						<c:forEach items="${search.data }" var="item">
							<article class="row blog_item">
								<div class="col-md-3">
									<div class="blog_info text-right">
										<div class="post_tag">
											<a href="#" class="text-secondary text-uppercase">${item.categoryName }</a>
										</div>
										<ul class="blog_meta list">
											<li><a href="#">${item.userCreated }<i
													class="lnr lnr-user"></i></a></li>
											<li><a href="#"> <fmt:formatDate
														value="${item.createdDate}" type="both" timeStyle="short"
														dateStyle="short"></fmt:formatDate> <i
													class="lnr lnr-calendar-full"></i></a></li>
											<%-- <li><a href="#">${item.view }<i class="lnr lnr-eye"></i></a></li> --%>
											<!-- <li><a href="#">06 Comments<i class="lnr lnr-bubble"></i></a></li> -->
										</ul>
									</div>
								</div>
								<div class="col-md-9">
									<div class="blog_post">
										<img src="${base }/img/ProductImages/${item.path}" alt="">
										<div class="blog_details">
											<a href="single-blog.html">
												<h2>${item.title }</h2>
											</a>
											<p>${item.shortContent }</p>
											<div id="demo${item.id }" class="collapse">
												${item.content }</div>
											<button class="genric-btn primary-border circle"
												data-toggle="collapse" data-target="#demo${item.id }">View
												More</button>

										</div>
									</div>
								</div>
							</article>
						</c:forEach>


						
							<div class=" d-flex flex-wrap align-items-center">

								<div class=" ${empty search.data ? "d-none" : "" }  m-auto">
									<section>
										<div id="paging"></div>
									</section>
								</div>
							</div>
						


					</div>
				</div>
				<div class="col-lg-4">
					<div class="blog_right_sidebar">
						<aside class="single_sidebar_widget search_widget">
							<form action="" method="get">
								<div class="input-group">

									<input type="text" class="form-control" name="search"
										placeholder="Search Posts" onfocus="this.placeholder = ''"
										onblur="this.placeholder = 'Search Posts'"
										value="${modelsearch.keyword }"> <span
										class="input-group-btn">

										<button class="btn btn-default" type="submit">
											<i class="lnr lnr-magnifier"></i>
										</button>
									</span>

								</div>
							</form>
							<!-- /input-group -->
							<div class="br"></div>
						</aside>
						<aside class="single_sidebar_widget author_widget">
							<img class="author_img rounded-circle" src="img/blog/author.png"
								alt="">
							<h4>Charlie Barber</h4>
							<p>Senior blog writer</p>
							<div class="social_icon">
								<a href="#"><i class="fa-brands fa-facebook"></i></a> <a
									href="#"><i class="fa-brands fa-github"></i></a> <a href="#"><i
									class="fa-brands fa-twitter"></i></a> <a href="#"><i
									class="fa-brands fa-google"></i></a>
							</div>
							<p>Boot camps have its supporters andit sdetractors. Some
								people do not understand why you should have to spend money on
								boot camp when you can get. Boot camps have itssuppor ters
								andits detractors.</p>
							<div class="br"></div>
						</aside>

					</div>
				</div>
			</div>
		</div>
	</section>
	<!--================Blog Area =================-->

	<!-- start footer Area -->
	<jsp:include page="/WEB-INF/views/customer/layout/footer.jsp"></jsp:include>
	<!-- End footer Area -->

	<jsp:include page="/WEB-INF/views/customer/layout/js.jsp"></jsp:include>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#paging").pagination({
				currentPage : ${search.currentPage},
				items :  ${search.totalItems},
				itemsOnPage : 10,
				cssStyle : 'customer-theme',
				onPageClick : function(pageNumber, event) {
					$('#page').val(pageNumber);
					$('#btnSearch').trigger('click');
				},
			})
		});
	</script>
</html>