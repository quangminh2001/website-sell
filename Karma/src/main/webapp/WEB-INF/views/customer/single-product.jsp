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
					<h1>Product Details Page</h1>
					<nav class="d-flex align-items-center">
						<a href="index.html">Home<span class="lnr lnr-arrow-right"></span></a>
						<a href="#">Shop<span class="lnr lnr-arrow-right"></span></a> <a
							href="single-product.html">product-details</a>
					</nav>
				</div>
			</div>
		</div>
	</section>
	<!-- End Banner Area -->

	<!--================Single Product Area =================-->
	<div class="product_image_area">
		<div class="container">
			<div class="row s_product_inner">
				<div class="col-lg-6">
					<div class="s_Product_carousel">
						<div class="single-prd-item">
							<img class="img-fluid"
								src="${base }/img/ProductImages/${product.avatar}" alt="">
						</div>

						<c:forEach items="${product.productImages }" var="imgPr">
							<div class="single-prd-item">
								<img class="img-fluid"
									src="${base }/img/ProductImages/${imgPr.path}" alt="">
							</div>
						</c:forEach>


						<%-- 
						<c:forEach items="${product.productImages }" var="imgPr">
							
						</c:forEach> --%>
						<div class="single-prd-item">
							<img class="img-fluid"
								src="${base }/img/ProductImages/${product.avatar}" alt="">
						</div>
						<div class="single-prd-item">
							<img class="img-fluid"
								src="${base }/img/ProductImages/${product.avatar}" alt="">
						</div>
					</div>
				</div>
				<div class="col-lg-5 offset-lg-1">
					<div class="s_product_text">
						<h3 class="text-uppercase">${product.title }</h3>
						<h2>$${product.priceSale }</h2>
						<ul class="list">
							<li><a class="active" href="#"><span>Category</span> :
									${product.categories.name }</a></li>
							<li><a href="#"><span>Availibility</span> : In Stock</a></li>
						</ul>
						<p>${product.shortDescription }.</p>
						<div class="product_count">
							<label for="qty">Quantity:</label> <input type="text" name="qty"
								id="sst" maxlength="12" value="1" title="Quantity:"
								class="input-text qty">
							<button onclick="addToCart('${base }',${product.id })"
								class="increase items-count" type="button">
								<i class="lnr lnr-chevron-up"></i>
							</button>
							<button onclick="deleteToCart('${base }',${product.id })"
								class="reduced items-count" type="button">
								<i class="lnr lnr-chevron-down"></i>
							</button>
						</div>
						<div class="card_area d-flex align-items-center">
							<a class="primary-btn"
								onclick="javascript:addToCart('${base}',${product.id});">Add
								to Cart</a> <a class="icon_btn" href="#"><i
								class="lnr lnr lnr-diamond"></i></a> <a class="icon_btn" href="#"><i
								class="lnr lnr lnr-heart"></i></a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--================End Single Product Area =================-->

	<!--================Product Description Area =================-->
	<section class="product_description_area">
		<div class="container">
			<ul class="nav nav-tabs" id="myTab" role="tablist">
				<li class="nav-item"><a class="nav-link" id="home-tab"
					data-toggle="tab" href="#home" role="tab" aria-controls="home"
					aria-selected="true">Description</a></li>
				<li class="nav-item"><a class="nav-link" id="profile-tab"
					data-toggle="tab" href="#profile" role="tab"
					aria-controls="profile" aria-selected="false">Specification</a></li>
				<li class="nav-item"><a class="nav-link active"
					id="contact-tab" data-toggle="tab" href="#contact" role="tab"
					aria-controls="contact" aria-selected="false">Comments</a></li>

				<!-- <li class="nav-item"><a class="nav-link active" id="review-tab"
					data-toggle="tab" href="#review" role="tab" aria-controls="review"
					aria-selected="false">Reviews</a></li> -->
			</ul>
			<div class="tab-content" id="myTabContent">
				<div class="tab-pane fade" id="home" role="tabpanel"
					aria-labelledby="home-tab">
					<p>${product.detailDescription }</p>
					<!-- <p>It is often frustrating to attempt to plan meals that are designed for one. Despite this fact, we are seeing
						more and more recipe books and Internet websites that are dedicated to the act of cooking for one. Divorce and
						the death of spouses or grown children leaving for college are all reasons that someone accustomed to cooking for
						more than one would suddenly need to learn how to adjust all the cooking practices utilized before into a
						streamlined plan of cooking that is more efficient for one person creating less</p> -->
				</div>
				<div class="tab-pane fade" id="profile" role="tabpanel"
					aria-labelledby="profile-tab">
					<div class="table-responsive">
						<table class="table">
							<tbody>
								<tr>
									<td>
										<h5>Width</h5>
									</td>
									<td>
										<h5>${product.width }mm</h5>
									</td>
								</tr>
								<tr>
									<td>
										<h5>Height</h5>
									</td>
									<td>
										<h5>${product.height }mm</h5>
									</td>
								</tr>
								<tr>
									<td>
										<h5>Depth</h5>
									</td>
									<td>
										<h5>${product.depth }mm</h5>
									</td>
								</tr>
								<tr>
									<td>
										<h5>Weight</h5>
									</td>
									<td>
										<h5>${product.weight }gm</h5>
									</td>
								</tr>
								<tr>
									<td>
										<h5>Quality checking</h5>
									</td>
									<td>
										<h5>${product.isCheck == true ?"Yes":"No" }</h5>
									</td>
								</tr>
								<tr>
									<td>
										<h5>Freshness Duration</h5>
									</td>
									<td>
										<h5>03days</h5>
									</td>
								</tr>
								<tr>
									<td>
										<h5>When packeting</h5>
									</td>
									<td>
										<h5>Without touch of hand</h5>
									</td>
								</tr>
								<tr>
									<td>
										<h5>Each Box contains</h5>
									</td>
									<td>
										<h5>60pcs</h5>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>

				<div class="tab-pane fade show active" id="contact" role="tabpanel"
					aria-labelledby="contact-tab">
					<div class="row">
						<div class="col-lg-12">
							<form action="${base }/comment" method="post">
								<div class="form-group reply">
									<textarea class="form-control" id="content" name="content"
										rows="3"></textarea>
									<input value="${product.id }" hidden name="productID">

								</div>
								<button type="submit" class="btn btn-danger mb-4">Post</button>
							</form>
							<div class="comment_list">
								<c:if test="${empty listComments}">
									<h4 class="h4">Not found comments</h4>
								</c:if>
								<c:forEach items="${listComments }" var="comment">
									<c:if test="${empty comment.parent }">
										<div class="review_item">
											<div class="media">
												<div class="d-flex">

													<c:if test="${comment.customerName =='Anonymous' }">
														<img src="${base }/img/avatar.jpg" style="width: 70px"
															class="img-fluid rounded-circle" alt="">
													</c:if>
													<c:if test="${comment.customerName !='Anonymous' }">
														<img src="${base }/img/minh.jpg" style="width: 70px"
															class="img-fluid rounded-circle" alt="">
													</c:if>
												</div>
												<div class="media-body">
													<h4>${comment.customerName }</h4>
													<h5>
														<fmt:formatDate type="both" dateStyle="medium"
															timeStyle="medium" value="${comment.createdDate }" />
													</h5>
													<a class="reply_btn" class="btn btn-primary"
														data-toggle="collapse" data-target="#demo${comment.id }">Reply</a>
												</div>
											</div>
											<p>${comment.content }</p>
										</div>

										<div id="demo${comment.id }" class="collapse ml-4">
											<form action="${base }/comment" method="post">
												<div class="form-group reply">
													<textarea class="form-control" id="content" name="content"
														rows="3"></textarea>
													<input value="${product.id }" hidden name="productID">
													<input value="${comment.id }" hidden name="parentID">
												</div>
												<button type="submit" class="btn btn-danger mb-4">Post</button>
											</form>
										</div>
										
										<c:forEach items="${comment.child }" var="item">
											<div class="review_item reply">
												<div class="media">
													<div class="d-flex">
														<c:if test="${item.customerName =='Anonymous' }">
															<img src="${base }/img/avatar.jpg" style="width: 70px"
																class="img-fluid rounded-circle" alt="">
														</c:if>
														<c:if test="${item.customerName !='Anonymous' }">
															<img src="${base }/img/product/review-2.png" alt="">
														</c:if>
													</div>
													<div class="media-body">
														<h4>${item.customerName }
															<i class="fa-solid fa-arrow-right"> </i>
															${comment.customerName }
														</h4>
														<h5>
															<fmt:formatDate type="both" dateStyle="medium"
																timeStyle="medium" value="${item.createdDate }" />
														</h5>
															<a class="reply_btn" href="#">Reply</a> 
													</div>
												</div>
												<p>${item.content }</p>
											</div>
											
										</c:forEach>
									</c:if>
								</c:forEach>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--================End Product Description Area =================-->

	<!-- Start related-product Area -->
	<section class="related-product-area section_gap_bottom">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-lg-6 text-center">
					<div class="section-title">
						<h1>Related Products</h1>
						<p>these products are products with the same product category
							and more.</p>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-9">
					<div class="row">

						<c:forEach items="${listProduct.data }" var="relatedProduct">

							<div class="col-lg-4 col-md-4 col-sm-6 mb-20">
								<div class="single-related-product d-flex">
									<a href="${base }/product/detail/${relatedProduct.seo}"><img
										style="height: 110px"
										src="${base }/img/ProductImages/${relatedProduct.avatar}"
										alt=""></a>
									<div class="desc">
										<a href="${base }/product/detail/${relatedProduct.seo}"
											class="title">${relatedProduct.title }</a>
										<div class="price">
											<h6>$${relatedProduct.price }</h6>
											<h6 class="l-through">$${relatedProduct.priceSale }</h6>
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
							class="img-fluid d-block mx-auto"
							src="${base }/img/category/c5.jpg" alt="">
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
	<jsp:include page="/WEB-INF/views/customer/layout/js.jsp"></jsp:include>

</body>

</html>