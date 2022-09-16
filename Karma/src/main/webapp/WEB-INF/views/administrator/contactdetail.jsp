<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!-- import JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="shortcut icon" href="${base }/img/fav.png">
<meta name="description" content="">
<meta name="author" content="">

<title>Admin</title>

<!-- Custom fonts for this template-->
<!-- CSS -->
<jsp:include page="/WEB-INF/views/administrator/layout/css.jsp"></jsp:include>
</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">
		<!-- Sidebar -->
		<jsp:include page="/WEB-INF/views/administrator/layout/sidebar.jsp"></jsp:include>
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar -->
				<jsp:include page="${base }/admin/topbar"></jsp:include>
				<!-- End of Topbar -->




				<!-- Spring form -->
				<div class="container">


					<div class="card mb-5">
						<c:set var="contact" value="${contact }"></c:set>
						<div class="card-header">
							<h4 class="h4">
								From: <a href="" class="accordion">${contact.email }</a>
							</h4>
						</div>
						<div class="card-body">
							<p class="">${contact.message }</p>
							<h5 class="h5">Mr/Mrs. ${contact.lastName }</h5>
						</div>

					</div>

					<form action="" enctype="multipart/form-data">

						<div class="mb-3">
							<label for="des" class="form-label">Response:</label>
							<textarea class="form-control" id="summernote" rows="6"
								placeholder="Enter description" onfocus="this.placeholder = ''"
								onblur="this.placeholder = 'Enter Message'"></textarea>
						</div>

						<button type="submit" class="btn btn-primary">Submit</button>
					</form>




					<!-- <div class="row">
                            <div class="col-lg-3">
                                <div class="contact_info">
                                    <div class="info_item">
                                        <i class="lnr lnr-home"></i>
                                        <h6>Ha Noi, Viet Nam</h6>
        
                                    </div>
                                    <div class="info_item">
                                        <i class="lnr lnr-phone-handset"></i>
                                        <h6><a href="#">0327290030</a></h6>
                                        <p>Mon to Fri 9am to 6 pm</p>
                                    </div>
                                    <div class="info_item">
                                        <i class="lnr lnr-envelope"></i>
                                        <h6><a href="#">nqmit2001@gmail.com</a></h6>
                                        <p>Send us your query anytime!</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-9">
                                <form class="row contact_form" action="" method="post" id="contactForm" novalidate="novalidate">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <input type="text" class="form-control" id="name" name="name" placeholder="Enter your name" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter your name'">
                                        </div>
                                        <div class="form-group">
                                            <input type="email" class="form-control" id="email" name="email" placeholder="Enter email address" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter email address'">
                                        </div>
                                        <div class="form-group">
                                            <input type="text" class="form-control" id="subject" name="subject" placeholder="Enter Subject" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter Subject'">
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <textarea class="form-control" name="message" id="message" rows="1" placeholder="Enter Message" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter Message'"></textarea>
                                        </div>
                                    </div>
                                    <div class="col-md-12 text-right">
                                        <button type="submit" value="submit" class="primary-btn">Send Message</button>
                                    </div>
                                </form>
                            </div>
                        </div> -->
				</div>

				<!-- End spring form -->






				<footer class="sticky-footer bg-white">
					<div class="container my-auto">
						<div class="copyright text-center my-auto">
							<span>Copyright &copy; Your Website 2021</span>
						</div>
					</div>
				</footer>
				<!-- End of Footer -->

			</div>
			<!-- End of Content Wrapper -->

		</div>
		<!-- End of Page Wrapper -->

		<!-- Scroll to Top Button-->
		<a class="scroll-to-top rounded" href="#page-top"> <i
			class="fas fa-angle-up"></i>
		</a>

		<!-- Logout Modal-->
		<jsp:include page="/WEB-INF/views/administrator/layout/logoutmodal.jsp"></jsp:include>

		<!-- Bootstrap core JavaScript-->
		<%-- <script src="${base }/js/admin/vendor/jquery/jquery.min.js"></script>
		<script
			src="${base }/js/admin/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

		<!-- Core plugin JavaScript-->
		<script
			src="${base }/js/admin/vendor/jquery-easing/jquery.easing.min.js"></script>

		<!-- Custom scripts for all pages-->
		<script src="${base }/js/admin/sb-admin-2.min.js"></script> --%>
		<jsp:include page="/WEB-INF/views/administrator/layout/js.jsp"></jsp:include>
		<!-- Page level plugins -->
		<!--  <script src="${base }/js/admin/vendor/chart.js/Chart.min.js"></script>-->


		<!-- Page level custom scripts -->
		<!--  <script src="${base }/js/admin/demo/chart-area-demo.js"></script>-->
		<!--  <script src="${base }/js/admin/demo/chart-pie-demo.js"></script>-->
	</div>
</body>

</html>