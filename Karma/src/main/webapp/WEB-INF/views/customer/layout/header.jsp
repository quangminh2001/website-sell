<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- import JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- Start Header Area -->
<header class="header_area sticky-header">
	<div class="main_menu">
		<nav class="navbar navbar-expand-lg navbar-light main_box">
			<div class="container">
				<!-- Brand and toggle get grouped for better mobile display -->
				<a class="navbar-brand logo_h" href="${base }/home"><img
					src="${base }/img/logo.png" alt=""></a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse offset"
					id="navbarSupportedContent">
					<ul class="nav navbar-nav menu_nav ml-auto">
						<li class="nav-item active"><a class="nav-link"
							href="${base }/home">Home</a></li>
						<li class="nav-item"><a class="nav-link"
							href="${base }/category">Shop</a></li>
						<%-- <li class="nav-item submenu dropdown">
						
						<a href="${base }/category"
							class="nav-link dropdown-toggle" data-toggle="dropdown"
							role="button" aria-haspopup="true" aria-expanded="false">Shop</a>
							
							<ul class="dropdown-menu">
								<c:forEach items="${ category}" var="cate">
									<li class="nav-item"><a class="nav-link"
									href="${base }/category/${cate.seo}">${cate.name }</a></li>
								</c:forEach>
							</ul>
						</li> --%>
						<li class="nav-item"><a class="nav-link" href="${base }/blog">Blog</a></li>
						<%-- <li class="nav-item submenu dropdown">
								<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
								 aria-expanded="false">Blog</a>
								<ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link" href="${base }/blog">Blog</a></li>
									<li class="nav-item"><a class="nav-link" href="${base }/single-blog">Blog Details</a></li>
								</ul>
							</li> --%>

						<li class="nav-item"><a class="nav-link"
							href="${base }/contact">Contact</a></li>


					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li class="nav-item"><a href="${base}/cart/view" class="cart"><span
								class="ti-bag position-relative">
									<h6 id="iconTotalCart"
										class="d-block position-absolute badge-cart">
										${totalItems == null ? 0 : totalItems }</h6>
							</span></a></li>

						<!-- <li class="nav-item">
							<button class="search">
								<span class="lnr lnr lnr-heart"></span>
							</button>
						</li>
 -->

						<li class="nav-item">
							<button class="search">
								<span class="lnr lnr-magnifier" id="search"></span>
							</button>
						</li>
						<!-- <li class="nav-item">
							<button class="search" data-toggle="dropdown"
							role="button" aria-haspopup="true" aria-expanded="false">
							<span class="lnr" ><i class="fa-solid fa-user-large text-secondary"></i></span>
								
							</button>
						</li> -->

						<li class="nav-item submenu dropdown"><button
								class="nav-link dropdown-toggle search" type="button"
								id="dropdownMenuButton" data-toggle="dropdown"
								aria-haspopup="true" aria-expanded="false">
								<span class="lnr"><i
									class="fa-solid fa-user-large text-secondary"></i></span>
							</button>

							<div class="dropdown-menu m-0 text-uppercase "
								aria-labelledby="dropdownMenuButton">
								<a class="dropdown-item " style="font-size: 12px" href="#">${userLogined.username }</a>
								<c:if test="${empty userLogined.username}">
									<a class="dropdown-item" style="font-size: 12px"
										href="${base }/login">Login</a>
								</c:if>
								<a class="dropdown-item" style="font-size: 12px"
									href="${base }/logout">Logout</a>
							</div>
					</ul>
				</div>
			</div>
		</nav>
	</div>
	<div class="search_input" id="search_input_box">
		<div class="container">
			<form action="${base }/category" method="get"
				class="d-flex justify-content-between">
				<input type="text" class="form-control" id="search_input"
					name="search" placeholder="Search Here">
				<button type="submit" class="btn"></button>
				<span class="lnr lnr-cross" id="close_search" title="Close Search"></span>
			</form>
		</div>
	</div>
</header>
<!-- End Header Area -->

