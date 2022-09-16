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
<!--
			CSS
			============================================= -->

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

	<!--================Blog Area =================-->
	<section class="blog_area single-post-area section_gap">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 posts-list">
					<div class="single-post row">
						<div class="col-lg-12">
							<div class="feature-img">
								<img class="img-fluid"
									src="${base }/img/ProductImages/${post.path}" alt="">
							</div>
						</div>
						<div class="col-lg-3  col-md-3">
							<div class="blog_info text-right">
								<div class="post_tag">
									<a href="#" class="text-uppercase text-secondary">${post.categoryName }</a>
								</div>
								<ul class="blog_meta list">
									<li><a href="#">${post.userCreated }<i
											class="lnr lnr-user"></i></a></li>
									<li><a href="#"><fmt:formatDate
												value="${post.createdDate}" type="both" timeStyle="short"
												dateStyle="short"></fmt:formatDate><i
											class="lnr lnr-calendar-full"></i></a></li>
									<li><a href="#">${post.view }<i class="lnr lnr-eye"></i></a></li>
									<!-- <li><a href="#">06 Comments<i class="lnr lnr-bubble"></i></a></li> -->
								</ul>
								<ul class="social-links">
									<li><a href="#"><i class="fa-brands fa-facebook"></i></a></li>
									<li><a href="#"><i class="fa-brands fa-github"></i></a></li>
									<li><a href="#"><i class="fa-brands fa-twitter"></i></a></li>
									<li><a href="#"><i class="fa-brands fa-google"></i></a></li>
								</ul>
							</div>
						</div>
						<div class="col-lg-9 col-md-9 blog_details">
							<h2>${post.title }</h2>
							<p class="excert">${post.content }</p>
						</div>

					</div>
					<div class="navigation-area">
						<div class="row">
							<div
								class="col-lg-6 col-md-6 col-12 nav-left flex-row d-flex justify-content-start align-items-center">
								<div class="thumb">
									<a href="#"><img class="img-fluid" src="img/blog/prev.jpg"
										alt=""></a>
								</div>
								<div class="arrow">
									<a href="#"><span class="lnr text-white lnr-arrow-left"></span></a>
								</div>
								<div class="detials">
									<p>Prev Post</p>
									<a href="#">
										<h4>Space The Final Frontier</h4>
									</a>
								</div>
							</div>
							<div
								class="col-lg-6 col-md-6 col-12 nav-right flex-row d-flex justify-content-end align-items-center">
								<div class="detials">
									<p>Next Post</p>
									<a href="#">
										<h4>Telescopes 101</h4>
									</a>
								</div>
								<div class="arrow">
									<a href="#"><span class="lnr text-white lnr-arrow-right"></span></a>
								</div>
								<div class="thumb">
									<a href="#"><img class="img-fluid" src="img/blog/next.jpg"
										alt=""></a>
								</div>
							</div>
						</div>
					</div>
					<div class="comments-area">
						<h4>05 Comments</h4>
						<div class="comment-list">
							<div class="single-comment justify-content-between d-flex">
								<div class="user justify-content-between d-flex">
									<div class="thumb">
										<img src="img/blog/c1.jpg" alt="">
									</div>
									<div class="desc">
										<h5>
											<a href="#">Emilly Blunt</a>
										</h5>
										<p class="date">December 4, 2018 at 3:12 pm</p>
										<p class="comment">Never say goodbye till the end comes!</p>
									</div>
								</div>
								<div class="reply-btn">
									<a href="" class="btn-reply text-uppercase">reply</a>
								</div>
							</div>
						</div>
						<div class="comment-list left-padding">
							<div class="single-comment justify-content-between d-flex">
								<div class="user justify-content-between d-flex">
									<div class="thumb">
										<img src="img/blog/c2.jpg" alt="">
									</div>
									<div class="desc">
										<h5>
											<a href="#">Elsie Cunningham</a>
										</h5>
										<p class="date">December 4, 2018 at 3:12 pm</p>
										<p class="comment">Never say goodbye till the end comes!</p>
									</div>
								</div>
								<div class="reply-btn">
									<a href="" class="btn-reply text-uppercase">reply</a>
								</div>
							</div>
						</div>
						<div class="comment-list left-padding">
							<div class="single-comment justify-content-between d-flex">
								<div class="user justify-content-between d-flex">
									<div class="thumb">
										<img src="img/blog/c3.jpg" alt="">
									</div>
									<div class="desc">
										<h5>
											<a href="#">Annie Stephens</a>
										</h5>
										<p class="date">December 4, 2018 at 3:12 pm</p>
										<p class="comment">Never say goodbye till the end comes!</p>
									</div>
								</div>
								<div class="reply-btn">
									<a href="" class="btn-reply text-uppercase">reply</a>
								</div>
							</div>
						</div>
						<div class="comment-list">
							<div class="single-comment justify-content-between d-flex">
								<div class="user justify-content-between d-flex">
									<div class="thumb">
										<img src="img/blog/c4.jpg" alt="">
									</div>
									<div class="desc">
										<h5>
											<a href="#">Maria Luna</a>
										</h5>
										<p class="date">December 4, 2018 at 3:12 pm</p>
										<p class="comment">Never say goodbye till the end comes!</p>
									</div>
								</div>
								<div class="reply-btn">
									<a href="" class="btn-reply text-uppercase">reply</a>
								</div>
							</div>
						</div>
						<div class="comment-list">
							<div class="single-comment justify-content-between d-flex">
								<div class="user justify-content-between d-flex">
									<div class="thumb">
										<img src="img/blog/c5.jpg" alt="">
									</div>
									<div class="desc">
										<h5>
											<a href="#">Ina Hayes</a>
										</h5>
										<p class="date">December 4, 2018 at 3:12 pm</p>
										<p class="comment">Never say goodbye till the end comes!</p>
									</div>
								</div>
								<div class="reply-btn">
									<a href="" class="btn-reply text-uppercase">reply</a>
								</div>
							</div>
						</div>
					</div>
					<div class="comment-form">
						<h4>Leave a Reply</h4>
						<form>
							<div class="form-group form-inline">
								<div class="form-group col-lg-6 col-md-6 name">
									<input type="text" class="form-control" id="name"
										placeholder="Enter Name" onfocus="this.placeholder = ''"
										onblur="this.placeholder = 'Enter Name'">
								</div>
								<div class="form-group col-lg-6 col-md-6 email">
									<input type="email" class="form-control" id="email"
										placeholder="Enter email address"
										onfocus="this.placeholder = ''"
										onblur="this.placeholder = 'Enter email address'">
								</div>
							</div>
							<div class="form-group">
								<input type="text" class="form-control" id="subject"
									placeholder="Subject" onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Subject'">
							</div>
							<div class="form-group">
								<textarea class="form-control mb-10" rows="5" name="message"
									placeholder="Messege" onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Messege'" required=""></textarea>
							</div>
							<a href="#" class="primary-btn submit_btn">Post Comment</a>
						</form>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="blog_right_sidebar">
						<aside class="single_sidebar_widget search_widget">
							<div class="input-group">
								<input type="text" class="form-control"
									placeholder="Search Posts" onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Search Posts'"> <span
									class="input-group-btn">
									<button class="btn btn-default" type="button">
										<i class="lnr lnr-magnifier"></i>
									</button>
								</span>
							</div>
							<!-- /input-group -->
							<div class="br"></div>
						</aside>
						<aside class="single_sidebar_widget author_widget">
							<img class="author_img rounded-circle" src="${base }/img/blog/author.png"
								alt="">
							<h4>Charlie Barber</h4>
							<p>Senior blog writer</p>
							<div class="social_icon">
								<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
									class="fa fa-twitter"></i></a> <a href="#"><i
									class="fa fa-github"></i></a> <a href="#"><i
									class="fa fa-behance"></i></a>
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
	<!-- <script src="js/vendor/jquery-2.2.4.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
	 crossorigin="anonymous"></script>
	<script src="js/vendor/bootstrap.min.js"></script>
	<script src="js/jquery.ajaxchimp.min.js"></script>
	<script src="js/jquery.nice-select.min.js"></script>
	<script src="js/jquery.sticky.js"></script>
    <script src="js/nouislider.min.js"></script>
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	gmaps Js
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCjCGmQ0Uq4exrzdcL6rvxywDDOvfAu6eE"></script>
	<script src="js/gmaps.min.js"></script>
	<script src="js/main.js"></script> -->
</body>

</html>