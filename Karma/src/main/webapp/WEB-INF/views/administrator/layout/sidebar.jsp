<ul
	class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
	id="accordionSidebar">

	<!-- Sidebar - Brand -->
	<a
		class="sidebar-brand d-flex align-items-center justify-content-center"
		href="${base }/home">
		<div class="sidebar-brand-icon rotate-n-15">
			<img src="${base }/img/fav.png" class="img-fluid" alt="">
		</div>
		<div class="sidebar-brand-text mx-3">Karma</div>
	</a>

	<!-- Divider -->
	<hr class="sidebar-divider my-0">

	<!-- Nav Item - Dashboard -->
	<li class="nav-item active"><a class="nav-link" href="${base }/admin/index">
			<i class="fas fa-fw fa-tachometer-alt"></i> <span>Dashboard</span>
	</a></li>

	<!-- Divider -->
	<hr class="sidebar-divider">

	<!-- Heading -->
	<!-- 	<div class="sidebar-heading">Interface</div> -->

	<!-- Nav Item - Pages Collapse Menu -->

	<li class="nav-item"><a class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapseTwoCategory"
		aria-expanded="true" aria-controls="collapseTwoCategory"> <i
			class="fa-solid fa-people-roof"></i> <span>Category</span>
	</a>
		<div id="collapseTwoCategory" class="collapse"
			aria-labelledby="headingTwo" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<a class="collapse-item" href="${base }/admin/category/list">Category
					List</a> <a class="collapse-item"
					href="${base }/admin/category/addorupdate">Add Category</a>
			</div>
		</div></li>
	<hr class="sidebar-divider">

	<li class="nav-item"><a class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapseTwo1"
		aria-expanded="true" aria-controls="collapseTwo1"> <i
			class="fa-solid fa-shoe-prints"></i> <span>Product</span>
	</a>
		<div id="collapseTwo1" class="collapse" aria-labelledby="headingTwo"
			data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<a class="collapse-item" href="${base }/admin/product/list">Products
					List</a> <a class="collapse-item"
					href="${base }/admin/product/addorupdate">Add product</a>
			</div>
		</div></li>


	<%-- <li class="nav-item"><a class="nav-link" href="${base }/admin/product/list"> <!-- <i class="fas fa-fw fa-table"></i> -->
			<i class="fa-solid fa-shoe-prints"></i> <span>Product</span></a></li> --%>
	<hr class="sidebar-divider">
	<li class="nav-item"><a class="nav-link"
		href="${base }/admin/saleorder/list"> <!-- <i class="fas fa-fw fa-table"></i> -->
			<i class="fa-solid fa-bag-shopping"></i> <span>Order</span></a></li>
	<hr class="sidebar-divider">
	<li class="nav-item"><a class="nav-link"
		href="${base }/admin/post/list"> <!-- <i class="fas fa-fw fa-table"></i> -->
			<i class="fa-brands fa-usps"></i> <span>Post</span></a></li>
	<hr class="sidebar-divider">
	<li class="nav-item"><a class="nav-link"
		href="${base }/admin/coupons/list"> <!-- <i class="fas fa-fw fa-table"></i> -->
			<i class="fa-solid fa-ticket"></i> <span>Coupon</span></a></li>
	<hr class="sidebar-divider">

	<!-- 	<li class="nav-item"><a class="nav-link" href="#"> <i class="fas fa-fw fa-table"></i>
			<i class="fa-solid fa-user"></i> <span>Profile</span></a></li>
	<hr class="sidebar-divider"> -->
	<li class="nav-item"><a class="nav-link"
		href="${base }/admin/contact"> <!-- <i class="fas fa-fw fa-table"></i> -->
			<i class="fa-solid fa-address-card"></i> <span>Contact</span></a></li>
	<hr class="sidebar-divider"></hr>
	<li class="nav-item"><a class="nav-link" href="${base }/admin/user/list"> <!-- <i class="fas fa-fw fa-table"></i> -->
			<i class="fa-solid fa-users"></i> <span>User</span></a></li>
	<!-- Sidebar Toggler (Sidebar) -->
	<div class="text-center d-none d-md-inline">
		<button class="rounded-circle border-0" id="sidebarToggle"></button>
	</div>

</ul>