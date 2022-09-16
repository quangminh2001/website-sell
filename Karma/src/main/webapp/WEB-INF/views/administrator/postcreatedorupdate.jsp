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
<meta name="description" content="">
<link rel="shortcut icon" href="${base }/img/fav.png">
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
				<div class="container-fluid">
					<div class="card p-5">
						<div class="card-header h3">Infor Post</div>
						<div class="card-body">
							<sf:form modelAttribute="post"
								action="${base }/admin/post/addorupdate?id=${post.id}"
								method="post" enctype="multipart/form-data">
								<sf:hidden path="id" />

								<div class="mb-3 mt-3">
									<label for="name" class="form-label">Title:</label>
									<sf:input path="title" type="text" class="form-control"
										id="name" placeholder="Enter title"></sf:input>
								</div>
								<div class="mb-3 mt-3">
									<label for="name" class="form-label">Short:</label>
									<sf:input path="shortContent" type="text" class="form-control"
										id="name" placeholder="Enter short description"></sf:input>
								</div>

								<div class="mb-3">
									<label for="cate" class="form-label">Category:</label>
									<sf:select path="categoryName" class="form-select"
										aria-label="Default select example">

										<sf:option value="social-life">Social life</sf:option>
										<sf:option value="politics">Politics</sf:option>
										<sf:option value="food">Food</sf:option>
									</sf:select>
								</div>
								<div class="mb-3">
									<label for="summernote" class="form-label"> Content:</label>
									<sf:textarea path="content" class="form-control"
										id="summernote" rows="6" placeholder="Enter content"
										onfocus="this.placeholder = ''"
										onblur="this.placeholder = 'Enter content'"></sf:textarea>
								</div>

								<div class="form-check">
									<sf:checkbox path="status" />
									<label class="form-check-label">Active?</label>
								</div>

								<div class="mb-3">
									<label for="avt" class="form-label">Poster:</label> <input
										type="file" id="avt" name="avt">
								</div>
								<c:if test="${post.id  != null }">
									<img src="${base }/img/ProductImages/${post.path}"
										class="img-thumbnail" alt="...">
								</c:if>

								<button type=submit class="btn btn-primary d-block"
									data-toggle="modal" data-target="#myModal">Submit</button>
							</sf:form>
						</div>

					</div>
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
		<jsp:include
			page="/WEB-INF/views/administrator/layout/logoutmodal.jsp"></jsp:include>
	</div>
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
</body>

</html>