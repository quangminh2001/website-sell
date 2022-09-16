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

<title>Admin - Saleorder</title>

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
					<form method="get" action="${base }/admin/saleorder/list"
						class=" mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
						<div class="row">
							<h3 class="d-block col-9 h2">
								<select class="d-inline-block form-select w-25 col-2 "
									name="numberPerPage">
									<option value="20" ${numberPage == 20 ? "selected" : ""}>Show
										20</option>
									<option value="40" ${numberPage == 40 ? "selected" : ""}>Show
										40</option>
									<option value="80" ${numberPage == 80 ? "selected" : ""}>Show
										80</option>
								</select><span class="h6 m-0 p-0"> / page </span>
							</h3>
							<!-- Topbar Search -->
							<div class="col-3">

								<div class="input-group">
									<input type="text" hidden id="page" name="page"> <input
										type="text" class="form-control bg-light border-0 small"
										placeholder="Search for..." aria-label="Search"
										aria-describedby="basic-addon2" value="${searchModel.keyword}"
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
									<th>Code</th>
									<th>Customer Name</th>
									<th>Total price</th>
									<th>Created Date</th>
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
										<td>${item.code}</td>
										<td>${item.customerName}</td>
										<td><fmt:setLocale value="en_US" scope="session" /> <fmt:formatNumber
												value=" ${item.total}" type="currency" /></td>
										<td>${item.createdDate}</td>

										<td id="status${item.id }">${item.statusorder }</td>
										<td><a class="btn btn-primary" data-bs-toggle="modal"
											data-bs-target="#myModal${i }">Detail</a> <!-- The Modal -->
											<div class="modal" id="myModal${i }">
												<div class="modal-dialog modal-dialog-scrollable">
													<div class="modal-content">

														<!-- Modal Header -->
														<div class="modal-header">
															<h4 class="modal-title">Code: ${item.code }</h4>
															<button type="button" class="btn-close"
																data-bs-dismiss="modal"></button>
														</div>

														<!-- Modal body -->
														<div class="modal-body">
															<div>Receiver: ${item.customerName } .</div>
															<div>Email: ${item.customerEmail }.</div>
															<div>Phonenumber: ${item.customerPhone }.</div>
															<div>Address: ${item.customerAddress }.</div>
															<div>Created Date: ${item.createdDate }.</div>

															<div>
																Total:
																<fmt:setLocale value="en_US" scope="session" />
																<fmt:formatNumber value=" ${item.total}" type="currency" />
															</div>
															<div>Status: ${item.statusorder }</div>
															<div class=" card p-2">
																Note:
																<p>${item.note }</p>
															</div>

														</div>

														<!-- Modal footer -->
														<div class="modal-footer">
															<button type="button" class="btn btn-danger"
																data-bs-dismiss="modal">Close</button>
														</div>

													</div>
												</div>
											</div> <span class="dropdown">
												<button class="btn btn-danger dropdown-toggle" type="button"
													id="dropdownMenuButton" data-toggle="dropdown"
													aria-haspopup="true" aria-expanded="false">Status</button>
												<div class="dropdown-menu"
													aria-labelledby="dropdownMenuButton">
													<a class="dropdown-item"
														href="javascript:changeStatusOrder('${base }',${item.id },'Pending');">Pending</a>
													<a class="dropdown-item"
														href="javascript:changeStatusOrder('${base }',${item.id },'Delivering');">Delivering</a>
													<a class="dropdown-item"
														href="javascript:changeStatusOrder('${base }',${item.id },'Canceled because there
														is not enough stock');">
														Canceled because there is not enough stock </a> <a
														class="dropdown-item"
														href="javascript:changeStatusOrder('${base }',${item.id },'Canceled because the buyer could not be contacted ');">
														Canceled because the buyer could not be contacted </a> <a
														class="dropdown-item" href="javascript:changeStatusOrder('${base }',${item.id },'Canceled because the customer
														canceled the order');"> Canceled because the customer
														canceled the order </a> <a class="dropdown-item"
														href="javascript:changeStatusOrder('${base }',${item.id },'Finished');">
														Finished </a>
													<!-- <a class="dropdown-item" href="#"> Canceled
														because the buyer could not be contacted </a> -->
												</div>
										</span></td>
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
	</div>
	<jsp:include page="/WEB-INF/views/administrator/layout/js.jsp"></jsp:include>
	<script type="text/javascript">
			$(document).ready(function() {
				$("#paging").pagination({
					currentPage : ${pagerData.currentPage},
					items : ${pagerData.totalItems},
					itemsOnPage : ${perPage},
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