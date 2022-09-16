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




				<!-- List form -->
				<div class="container-fluid p-5">
					<form class="mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search"
						method="get">
						<div class="row">
							<h3 class="d-block col-9 h2">
								<span class="h6 m-0 p-0">Status: </span> <select
									class="d-inline-block form-select w-25 col-2 " name="status"
									aria-label="Default select example">
									<option value="-1" ${-1 == searchModel.status?"selected":""}>All</option>
									<option value="0" ${0 == searchModel.status?"selected":""}>No
										seen</option>
									<option value="1" ${1 == searchModel.status?"selected":""}>Seen</option>
								</select>
							</h3>
							<!-- Topbar Search -->
							<div class="col-3">
								<div class="input-group">
									<input type="text" class="form-control bg-light border-0 small"
										name="keyword" placeholder="Search for..."
										value="${searchModel.keyword}" aria-label="Search"
										aria-describedby="basic-addon2"> <input type="text"
										id="page" name="page" hidden value="">
									<div class="input-group-append">
										<button id="btnSearch" class="btn btn-primary" type="submit">
											<i class="fas fa-search fa-sm"></i>
										</button>
									</div>
								</div>
							</div>
						</div>

						<table id="demo" class="table table-striped table-bordered"
							width="100%" cellspacing="0">
							<thead>
								<tr>
									<th>Order</th>
									<th>Name</th>
									<th>Email</th>
									<th>Created Date</th>
									<th>Status</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<c:set var="i" value="0" scope="page"></c:set>
								<c:forEach items="${searchContact.data}" var="item"
									varStatus="loop">
									<tr id="${item.id }">
										<c:set var="i" value="${i+1}"></c:set>
										<td>${i + (searchContact.currentPage-1)*10}</td>
										<td>${item.firstName}${item.lastName}</td>
										<td>${item.email}</td>
										<td>${ item.createdDate}</td>

										<td><c:if test="${ item.status == false}">No seen</c:if>
											<c:if test="${item.status == true }">Seen</c:if></td>
										<td><a href="${base }/admin/contact/${item.id}"
											class="btn btn-primary">Detail</a>
											
											<button type="button"
													onclick="deletedContact('${base}','${item.id}')"
													class="btn btn-danger">Delete</button>
											</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</form>
					<!-- List form -->

					<div>
						<section>
							<div id="paging"></div>
						</section>
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
		<jsp:include page="/WEB-INF/views/administrator/layout/js.jsp"></jsp:include>
		<script type="text/javascript">
			$(document).ready(function() {
				$("#paging").pagination({
					currentPage : ${searchContact.currentPage},
					items : ${searchContact.totalItems},
					itemsOnPage : 10,
					cssStyle : 'light-theme',
					onPageClick : function(pageNumber, event) {
						$('#page').val(pageNumber);
						$('#btnSearch').trigger('click');
					},
				})
			});
		</script>
	</div>
</body>

</html>