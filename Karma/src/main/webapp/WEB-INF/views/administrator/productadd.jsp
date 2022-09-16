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
						<div class="card-header h3">Infor Product</div>
						<div class="card-body">

							<sf:form modelAttribute="product"
								action="${base }/admin/product/addorupdate?id=${product.id}"
								method="post" enctype="multipart/form-data">
								<sf:hidden path="id" />
								<div class="mb-3 mt-3">
									<label for="name" class="form-label">Title:</label>
									<sf:input path="title" type="text" class="form-control"
										id="name" placeholder="Enter title product"></sf:input>
								</div>
								<div class="mb-3">
									<label for="price" class="form-label">Price:</label>
									<sf:input path="price" type="text" class="form-control"
										id="price" placeholder="Enter price" name="price"></sf:input>
								</div>
								<div class="mb-3">
									<label for="priceSale" class="form-label">Price Sale:</label>
									<sf:input path="priceSale" type="text" class="form-control"
										id="pricesale" placeholder="Enter price sale" name="pricesale"></sf:input>
								</div>
								<div class="mb-3">
									<label for="width" class="form-label">Width:</label>
									<sf:input path="width" type="text" class="form-control"
										id="width" placeholder="Example: 0mm" name="width"></sf:input>
								</div>
								<div class="mb-3">
									<label for="height" class="form-label">Height:</label>
									<sf:input path="height" type="text" class="form-control"
										id="height" placeholder="Example: 0mm" name="height"></sf:input>
								</div>
								<div class="mb-3">
									<label for="depth" class="form-label">Depth:</label>
									<sf:input path="depth" type="text" class="form-control"
										id="depth" placeholder="Example: 0mm" name="depth"></sf:input>
								</div>
								<div class="mb-3">
									<label for="weight" class="form-label">Weight:</label>
									<sf:input path="weight" type="text" class="form-control"
										id="weight" placeholder="Example: 0gm" name="weight"></sf:input>
								</div>
								<div class="mb-3">
									<label for="sdes" class="form-label">Short Desciption:</label>
									<sf:textarea path="shortDescription" class="form-control"
										id="sdes" rows="6" placeholder="Enter short description"
										onfocus="this.placeholder = ''"
										onblur="this.placeholder = 'Enter short desciption'"></sf:textarea>
								</div>
								<div class="mb-3">
									<label for="summernote" class="form-label">Detail
										Desciption:</label>
									<sf:textarea path="detailDescription" class="form-control"
										id="summernote" rows="6"
										placeholder="Enter detail description"
										onfocus="this.placeholder = ''"
										onblur="this.placeholder = 'Enter detail desciption'"></sf:textarea>
								</div>

								<div class="mb-3">
									<label for="cate" class="form-label">Category:</label>
									<sf:select path="categories" class="form-select" id="cate"
										aria-label="Default select example">
										<%-- <c:forEach items="${category}" var="cate" varStatus="loop">
											<sf:option value="${cate.id }" label="${cate.name }"></sf:option>
										</c:forEach> --%>
										<sf:options items="${ category}" itemLabel="name"
											itemValue="id" />
									</sf:select>
								</div>
								<div class="form-check">
									<sf:checkbox path="status" />
									<label class="form-check-label">Active?</label>
								</div>
								<div class="form-check">
									<sf:checkbox path="isHot" />
									<label class="form-check-label">Is hot?</label>
								</div>
								<div class="form-check">
									<sf:checkbox path="isCheck" />
									<label class="form-check-label">Is check?</label>
								</div>
								<div class="mb-3">
									<label for="avt" class="form-label">Avatar:</label> <input
										type="file" id="avt" name="avt">
								</div>
								<c:if test="${product.id  != null }">
									<img src="${base }/img/ProductImages/${product.avatar}"
										class="img-thumbnail" alt="...">
								</c:if>
								<div class="mb-3">
									<label for="img" class="form-label">Image:</label> <input
										type="file" multiple="multiple" id="img" name="img">
								</div>
								<div>
									<c:if test="${product.id  != null }">
										<c:forEach items="${ product.productImages}" var="imgs">
											<img src="${base }/img/ProductImages/${imgs.path}"
												class="img-thumbnail" alt="...">
										</c:forEach>
									</c:if>
								</div>

								<button type=submit class="btn btn-primary d-block"
									data-toggle="modal" data-target="#myModal">Submit</button>

								<!-- The Modal -->
								<div class="modal" id="myModal">
									<div class="modal-dialog">
										<div class="modal-content">

											<!-- Modal Header -->
											<div class="modal-header">
												<h4 class="modal-title">Success</h4>
												<!-- <button type="submit" class="close" data-dismiss="modal">&times;</button> -->
											</div>

											<!-- Modal body -->
											<div class="modal-body">${product.id == null ?"You added this product to database successfully" : "You revised this product to database successfully"}
											</div>

											<!-- Modal footer -->
											<!-- <div class="modal-footer">
													<button type="submit" class="btn btn-danger"
														data-dismiss="modal">Close</button>
												</div> -->

										</div>
									</div>
								</div>

							</sf:form>
						</div>

					</div>
				</div>

				<!-- End spring form -->


				<!-- Button to Open the Modal -->

				<!-- The Modal -->
				<div class="modal" id="myModal">
					<div class="modal-dialog">
						<div class="modal-content">

							<!-- Modal Header -->
							<div class="modal-header">
								<h4 class="modal-title">Success</h4>
								<button type="button" class="close" data-dismiss="modal">&times;</button>
							</div>

							<!-- Modal body -->
							<div class="modal-body">hello</div>

							<!-- Modal footer -->
							<div class="modal-footer">
								<button type="button" class="btn btn-danger"
									data-dismiss="modal">Close</button>
							</div>

						</div>
					</div>
				</div>



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