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
					<h1>Checkout</h1>
					<nav class="d-flex align-items-center">
						<a href="${base }/home">Home<span class="lnr lnr-arrow-right"></span></a>
						<a href="${base }/cart/checkout">Checkout</a>
					</nav>
				</div>
			</div>
		</div>
	</section>
	<!-- End Banner Area -->

	<!--================Checkout Area =================-->

	<section class="checkout_area section_gap">
		<div class="container">
			<c:if test="${status == true }">
				<div class="alert alert-success">
					<strong>Success!</strong> Your order will be processed as soon as
					possible.
				</div>
			</c:if>
			<div class="billing_details">
				<form class="contact_form" action="${base }/cart/checkout"
					method="post" novalidate="novalidate">
					<div class="row">
						<div class="col-lg-8">
							<h3>Billing Details</h3>

							<div class="col-md-12 form-group ">
								<input type="text" name="fullName"
									value="${userLogined.username }" placeholder="Full name"
									onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Full name'" required
									class="single-input">
							</div>
							<div class="col-md-12 form-group ">
								<input type="text" name="phonenumber"
									value="${userLogined.phone }" placeholder="Phone Number"
									onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Phone Number'" required
									class="single-input">
							</div>
							<div class="col-md-12 form-group">
								<input type="text" name="email"
									${isLogined == true  ? "disabled" :"" }
									value="${userLogined.email }" placeholder="Email"
									onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Email'" required
									class="single-input">
							</div>
							<div class="col-md-12 form-group">
								<input type="text" name="address" placeholder="Address"
									onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Address'"
									value="${userLogined.address }" required class="single-input">
							</div>
							<div class="col-md-12 form-group">
								<!-- <div class="creat_account">
									<h3>Shipping Details</h3>
									<input type="checkbox" id="f-option3" name="selector">
									<label for="f-option3">Ship to a different address?</label>
								</div> -->
								<textarea class="form-control" name="message" id="message"
									rows="6" placeholder="Order Notes"></textarea>
							</div>
							<button class="border-0 w-100 primary-btn" type="submit">Proceed
								to Paypal</button>
						</div>
						<div class="col-lg-4">
							<div class="order_box">
								<h2>Your Order</h2>
								<ul class="list">
									<li><a href="#">Product <span>Total</span></a></li>
									<c:forEach items="${cart.cartItems }" var="ci">
										<li class=""><a href="#" class="row d-flex"><span
												class="col-6 text-truncate ">${ci.productName }</span> <span
												class="col-2">x ${ci.quantity }</span> <span
												class="col-4  text-right">$${ ci.priceUnit }</span></a></li>
									</c:forEach>

									<!-- <li><a href="#">Fresh Tomatoes <span class="middle">x 02</span> <span class="last">$720.00</span></a></li>
                                <li><a href="#">Fresh Brocoli <span class="middle">x 02</span> <span class="last">$720.00</span></a></li> -->
								</ul>
								<ul class="list list_2">
									<li><a href="#">Total <span>$${cart.totaPrice }</span></a></li>
									<!-- <li><a href="#"> Discount<span>
												$50.00</span></a></li>
									<li><a href="#">Total <span>$2210.00</span></a></li> -->
								</ul>
								<div class="payment_item">
									<div class="radion_btn">
										<input type="radio" id="f-option5" name="selector"> <label
											for="f-option5">Check payments</label>
										<div class="check"></div>
									</div>
									<p>Please send a check to Store Name, Store Street, Store
										Town, Store State / County, Store Postcode.</p>
								</div>
								<div class="payment_item active">
									<div class="radion_btn">
										<input type="radio" id="f-option6" name="selector"> <label
											for="f-option6">Paypal </label> <img
											src="${base }/img/product/card.jpg" alt="">
										<div class="check"></div>
									</div>
									<p>Pay via PayPal; you can pay with your credit card if you
										don’t have a PayPal account.</p>
								</div>
								<div class="creat_account">
									<input type="checkbox" id="f-option4" name="selector">
									<label for="f-option4">I’ve read and accept the </label> <a
										href="#">terms & conditions*</a>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</section>
	<!--================End Checkout Area =================-->

	<!-- start footer Area -->
	<jsp:include page="/WEB-INF/views/customer/layout/footer.jsp"></jsp:include>
	<!-- End footer Area -->

	<jsp:include page="/WEB-INF/views/customer/layout/js.jsp"></jsp:include>


</body>

</html>