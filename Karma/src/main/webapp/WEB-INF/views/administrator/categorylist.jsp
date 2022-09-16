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
					<form method="get" action="${base}/admin/category/list"
						class=" mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
						<div class="row">
							<h3 class="d-block col-9 h2">
								<span class="h6 m-0 p-0">Status: </span> <select
									class="d-inline-block form-select w-25 col-2 " name="status">
									<option value="" selected>All</option>

									<option value="1" ${categorySearch.status == 1 ? "selected" : "" }>Active</option>
									<option value="0" ${categorySearch.status == 0 ? "selected" : "" }>Block</option>
								</select>

							</h3>
							<!-- Topbar Search -->
							<div class="col-3">

								<div class="input-group">
									<input type="text" hidden id="page" name="page" value="">
									<input type="text" class="form-control bg-light border-0 small"
										placeholder="Search for..." aria-label="Search"
										aria-describedby="basic-addon2" value="${categorySearch.keyword}"
										name="keyword"></input>
									<div class="input-group-append">
										<button class="btn btn-primary" id="btnSearch" type="submit">
											<i class="fas fa-search fa-sm"></i>
										</button>
									</div>
								</div>

							</div>
						</div>
						<table class="table table-striped table-bordered" width="100%"
							cellspacing="0">
							<thead>
								<tr>
									<th>Order</th>
									<th>Name</th>
									<th>Created Date</th>
									<th>Updated Date</th>
									<th>Status</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<c:set var="i" value="0"></c:set>
								<c:forEach items="${pagerData.data}" var="item" varStatus="loop">
									<tr>
										<c:set var="i" value="${i+1}"></c:set>
										<td><c:out value="${i}"></c:out></td>
										<td>${item.name}</td>
										<td>${item.createdDate}</td>
										<td>${item.updatedDate}</td>
										<td>${item.status == true ? "Active" : "Block"}</td>

										<td><a
											href="${base }/admin/category/addorupdate?id=${item.id}"
											class="btn btn-primary">Edit</a>
											<form class="d-inline">
												<button type="button"
													onclick="blockOrActiveCategory('${base}','${item.id}')"
													class="btn btn-danger">${item.status == true ? "Block" : "Acive"}</button>
											</form> <%-- <a href="${base }/admin/product/blockOrActive?id=${item.id}"
										type="button" class="btn btn-danger">${item.status == true ? "Block" : "Acive"}</a></td> --%>
									</tr>
								</c:forEach>
							</tbody>
						</table>

						<div>
							<section>
								<div id="paging"></div>
							</section>
						</div>
					</form>
					<!-- List form -->
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

		<jsp:include page="/WEB-INF/views/administrator/layout/js.jsp"></jsp:include>
		<script type="text/javascript">
			$(document).ready(function() {
				$("#paging").pagination({
					currentPage : ${pagerData.currentPage},
					items : ${pagerData.totalItems},
					itemsOnPage : 10,
					cssStyle : 'light-theme',
					onPageClick : function(pageNumber, event) {
						$('#page').val(pageNumber);
						$('#btnSearch').trigger('click');
					},
				})
			});
		</script>
</body>

</html>