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
					<h1>Shopping Cart</h1>
					<nav class="d-flex align-items-center">
						<a href="${base }/home">Home<span class="lnr lnr-arrow-right"></span></a>
						<a href="${base }/cart/view">Cart</a>
					</nav>
				</div>
			</div>
		</div>
	</section>
	<!-- End Banner Area -->

	<!--================Cart Area =================-->
	<section class="cart_area">
		<div class="container">
			<div class="cart_inner">
				<div class="table-responsive">
					<table class="table">
						<thead>
							<tr>
								<th scope="col">Product</th>
								<th scope="col">Price</th>
								<th scope="col">Quantity</th>
								<th scope="col">Total</th>
								<th scope="col">Remove</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${cart.cartItems }" var="ci">
								<tr>
									<td>
										<div class="media">
											<div class="d-flex">
												<img src="${base }/img/ProductImages/${ci.avatar}" alt="">
											</div>
											<div class="media-body">
												<p>${ci.productName }</p>
											</div>
										</div>
									</td>
									<td>
										<h5>$${ci.priceUnit}</h5>
									</td>
									<td>
										<div class="product_count">
											<input type="text" name="qty" id="sst" maxlength="12"
												value="${ci.quantity }" title="Quantity:"
												class="input-text qty">
											<button data-price="${ci.priceUnit}"
												class="increase items-count" type="button">
												<i class="lnr lnr-chevron-up"
													onclick="addToCart('${base }',${ci.productId })"></i>
											</button>
											<button data-price="${ci.priceUnit}"
												class="reduced items-count" type="button">
												<i class="lnr lnr-chevron-down" onclick="deleteToCart('${base }',${ci.productId })"></i>
											</button>
										</div>
									</td>
									<td>
										<h5 class="totalPrice"
											data-total-price="${ci.priceUnit*ci.quantity}">$${ci.priceUnit*ci.quantity}</h5>
									</td>

									<td>
										<form>
											<a href="javascript:deleteItemFromCart('${base }', ${ci.productId });" class="genric-btn danger circle">Remove</a>
										</form>
									</td>
								</tr>
							</c:forEach>

							<tr class="bottom_button">
								<td><a class="gray_btn" href="#">Update Cart</a></td>
								<td></td>
								<td></td>
								<td>
									<div class="cupon_text d-flex align-items-center">
										<input type="text" valueattr="200" placeholder="Coupon Code">
										<a class="primary-btn apply_coupon">Apply</a> <a
											class="gray_btn" href="${base }/apply_coupon">Close Coupon</a>
									</div>
								</td>
							</tr>
							<tr>
								<td></td>
								<td></td>
								<td>
									<h5>Subtotal</h5>
								</td>
								<td>
									<h5 id="total_price_prduct">$${cart.totaPrice }</h5>
								</td>
							</tr>
							<!-- <tr class="shipping_area">
								<td></td>
								<td></td>
								<td>
									<h5>Shipping</h5>
								</td>
								<td>
									<div class="shipping_box">
										<ul class="list">
											<li><a href="#">Flat Rate: $5.00</a></li>
											<li><a href="#">Free Shipping</a></li>
											<li><a href="#">Flat Rate: $10.00</a></li>
											<li class="active"><a href="#">Local Delivery: $2.00</a></li>
										</ul>
										<h6>
											Calculate Shipping <i class="fa fa-caret-down"
												aria-hidden="true"></i>
										</h6>
										<select class="shipping_select">
											<option value="1">Bangladesh</option>
											<option value="2">India</option>
											<option value="4">Pakistan</option>
										</select> <select class="shipping_select">
											<option value="1">Select a State</option>
											<option value="2">Select a State</option>
											<option value="4">Select a State</option>
										</select> <input type="text" placeholder="Postcode/Zipcode"> <a
											class="gray_btn" href="#">Update Details</a>
									</div>
								</td>
							</tr> -->
							<tr class="out_button_area">
								<td></td>
								<td></td>
								<td></td>
								<td>
									<div class="checkout_btn_inner d-flex align-items-center">
										<a class="gray_btn" style="padding: 0 30px;" href="${base }/home">Continue
											Shopping</a> <a class="primary-btn" href="${base }/cart/checkout">Proceed
											to checkout</a>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</section>
	<!--================End Cart Area =================-->

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