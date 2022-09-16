<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
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

<body id="category">

	<!-- Start Header Area -->
	<jsp:include page="/WEB-INF/views/customer/layout/header.jsp"></jsp:include>
	<!-- End Header Area -->

	<!-- Start Banner Area -->
	<section class="banner-area organic-breadcrumb">
		<div class="container">
			<div
				class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
				<div class="col-first">
					<h1>Shop Category page</h1>
					<nav class="d-flex align-items-center">
						<a href="${base }/home">Home<span class="lnr lnr-arrow-right"></span></a>
						<a href="${base }/category">Category <span
							class="lnr lnr-arrow-right"></span>
						</a>
					</nav>
				</div>
			</div>
		</div>
	</section>
	<!-- End Banner Area -->
	<form action="${base }/category/search" method="get">
		<div class="container">
			
			<div class="row">
				<div class="col-xl-12 col-lg-8 col-md-7">
					<!-- Start Filter Bar -->
					<div class="filter-bar d-flex flex-wrap align-items-center">
						<div class="sorting">
							<select name="categoryID">
								<option value="">Category</option>
								<c:forEach items="${category }" var="cate">
									<option value="${cate.id }"
										${searchModel.category == cate.id ? "selected" : ""}>${cate.name }</option>
								</c:forEach>
							</select>
						</div>

						<div class="sorting">
							<select name="priceSort">
								<option value="">Price</option>
								<option value="asc"
									${searchModel.sortByPrice == "asc" ? "selected" : ""}>Price
									up</option>
								<option value="desc"
									${searchModel.sortByPrice == "desc" ? "selected" : ""}>Price
									down</option>
							</select>
						</div>
						<div class="sorting">
							<select name="year">
								<option value="">Year</option>


								<option value="2022"
									${searchModel.year == 2022 ? "selected" : ""}>2022</option>
								<option value="2021"
									${searchModel.year == 2021 ? "selected" : ""}>2021</option>
								<option value="2020"
									${searchModel.year == 2020 ? "selected" : ""}>2020</option>
								<option value="2019"
									${searchModel.year == 2019 ? "selected" : ""}>2019</option>
							</select>
						</div>
						<div class="sorting">
							<select name="ishot">
								<option value="">Is hot?</option>
								<option value="1" ${searchModel.isHot == 1 ? "selected" : ""}>Hot</option>
							</select>
						</div>
						<div class="sorting mr-auto">
							<select name="numberPerPage">

								<option value="20" ${numberPage == 20 ? "selected" : ""}>Show
									20</option>
								<option value="40" ${numberPage == 40 ? "selected" : ""}>Show
									40</option>
								<option value="80" ${numberPage == 80 ? "selected" : ""}>Show
									80</option>
							</select>
						</div>
						<div class="sorting ">
							<input type="text" hidden id="page" name="page">
							<!-- <button type="submit" class="btnSearch btn btn-secondary">Search</button> -->
							<button type="submit" type="submit" id="btnSearch"
								class="border-0 btnSearch genric-btn primary circle arrow">
								Search<span class="lnr lnr-arrow-right"></span>
							</button>
						</div>

					</div>
					<!-- End Filter Bar -->
					
					
					
					<!-- Start Best Seller -->
					<section class="lattest-product-area pb-40 category-list">
					
						<div class="row">
							<c:forEach items="${pageWithData.data }" var="product"
								varStatus="loop">
								<!-- single product -->
								<div class="col-lg-3 col-md-6">
									<div class="single-product">
										<div>
											<img class="img-fluid img-hot"
												src="${base }/img/ProductImages/${product.avatar}" alt="">
											<c:if test="${product.isHot == true}">
												<span class="badge badge-danger badge-customize1 ">HOT</span>
											</c:if>

										</div>
										<div class="product-details">
											<h6>${product.title }</h6>
											<div class="price">
												<h6>${product.priceSale }</h6>
												<h6 class="l-through">${product.price }</h6>
											</div>
											<div class="prd-bottom">

												<a onclick="javascript:addToCart('${base}',${product.id});"
													class="social-info"> <span class="ti-bag"></span>
													<p class="hover-text">add to bag</p>
												</a> <a href="" class="social-info"> <span
													class="lnr lnr-heart"></span>
													<p class="hover-text">Wishlist</p>
												</a> <a href="" class="social-info"> <span
													class="lnr lnr-sync"></span>
													<p class="hover-text">compare</p>
												</a> <a href="${base }/product/detail/${product.seo}"
													class="social-info"> <span class="lnr lnr-move"></span>
													<p class="hover-text">view more</p>
												</a>
											</div>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
					</section>
					<!-- End Best Seller -->
					<!-- Start Filter Bar -->
					<div class="filter-bar d-flex flex-wrap align-items-center">

						<div class="m-auto">
							<section>
								<div id="paging"></div>
							</section>
						</div>
					</div>
					<!-- End Filter Bar -->
				</div>
			</div>
		</div>
	</form>



	<!-- Start related-product Area -->
	<section class="related-product-area section_gap">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-lg-6 text-center">
					<div class="section-title">
						<h1>Deals of the Week</h1>
						<p>Discounts make us think we’re getting a good deal. But
							discounts offered within a limited time frame make us take
							action.</p>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-9">
					<div class="row">

						<c:forEach items="${ProductDiscout.data }" var="discoutpr">
							<div class="col-lg-4 col-md-4 col-sm-6 mb-20">
								<div class="single-related-product d-flex">
									<a href="${base }/product/detail/${discoutpr.seo}"><img
										style="height: 110px"
										src="${base }/img/ProductImages/${discoutpr.avatar}" alt=""></a>
									<div class="desc">
										<a href="${base }/product/detail/${discoutpr.seo}"
											class="title">${discoutpr.title }</a>
										<div class="price">
											<h6>$${discoutpr.price }</h6>
											<h6 class="l-through">$${discoutpr.priceSale }</h6>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>

					</div>
				</div>
				<div class="col-lg-3">
					<div class="ctg-right">
						<a href="#" target="_blank"> <img
							class="img-fluid d-block mx-auto" src="img/category/c5.jpg"
							alt="">
						</a>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- End related-product Area -->

	<!-- start footer Area -->
	<jsp:include page="/WEB-INF/views/customer/layout/footer.jsp"></jsp:include>
	<!-- End footer Area -->

	<!-- Modal Quick Product View -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="container relative">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<div class="product-quick-view">
					<div class="row align-items-center">
						<div class="col-lg-6">
							<div class="quick-view-carousel">
								<div class="item"
									style="background: url(img/organic-food/q1.jpg);"></div>
								<div class="item"
									style="background: url(img/organic-food/q1.jpg);"></div>
								<div class="item"
									style="background: url(img/organic-food/q1.jpg);"></div>
							</div>
						</div>
						<div class="col-lg-6">
							<div class="quick-view-content">
								<div class="top">
									<h3 class="head">Mill Oil 1000W Heater, White</h3>
									<div class="price d-flex align-items-center">
										<span class="lnr lnr-tag"></span> <span class="ml-10">$149.99</span>
									</div>
									<div class="category">
										Category: <span>Household</span>
									</div>
									<div class="available">
										Availibility: <span>In Stock</span>
									</div>
								</div>
								<div class="middle">
									<p class="content">Mill Oil is an innovative oil filled
										radiator with the most modern technology. If you are looking
										for something that can make your interior look awesome, and at
										the same time give you the pleasant warm feeling during the
										winter.</p>
									<a href="#" class="view-full">View full Details <span
										class="lnr lnr-arrow-right"></span></a>
								</div>
								<div class="bottom">
									<div class="color-picker d-flex align-items-center">
										Color: <span class="single-pick"></span> <span
											class="single-pick"></span> <span class="single-pick"></span>
										<span class="single-pick"></span> <span class="single-pick"></span>
									</div>
									<div class="quantity-container d-flex align-items-center mt-15">
										Quantity: <input type="text" class="quantity-amount ml-15"
											value="1" />
										<div class="arrow-btn d-inline-flex flex-column">
											<button class="increase arrow" type="button"
												title="Increase Quantity">
												<span class="lnr lnr-chevron-up"></span>
											</button>
											<button class="decrease arrow" type="button"
												title="Decrease Quantity">
												<span class="lnr lnr-chevron-down"></span>
											</button>
										</div>

									</div>
									<div class="d-flex mt-20">
										<a href="#" class="view-btn color-2"><span>Add to
												Cart</span></a> <a href="#" class="like-btn"><span
											class="lnr lnr-layers"></span></a> <a href="#" class="like-btn"><span
											class="lnr lnr-heart"></span></a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="/WEB-INF/views/customer/layout/js.jsp"></jsp:include>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#paging").pagination({
				currentPage : ${pageWithData.currentPage},
				items :  ${pageWithData.totalItems},
				itemsOnPage : ${numberPage},
				cssStyle : 'customer-theme',
				onPageClick : function(pageNumber, event) {
					$('#page').val(pageNumber);
					$('#btnSearch').trigger('click');
				},
			})
		});
	</script>
</body>

</html>