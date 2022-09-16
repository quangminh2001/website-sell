
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

<title>Admin - Register</title>

<!-- Custom fonts for this template-->
<!-- CSS -->
<link href="${base }/css/admin/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="${base }/css/admin/sb-admin-2.min.css" rel="stylesheet">
<link href="${base }/css/admin/customize.css" rel="stylesheet">
<jsp:include page="/WEB-INF/views/customer/layout/css.jsp"></jsp:include>
</head>

<body style="background-image: url('${base }/img/banner/banner-bg.jpg');">
<a href="${base }/home" class="genric-btn primary-border circle arrow mt-3 ml-3">Back to home<span class="lnr lnr-arrow-right"></span></a>
    <div class="container w-50 ">

        <div class="card o-hidden border-0 bg-gray-300 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                <div class="row">
                    
                    <div class="col-lg-12">
                        <div class="p-5">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4">Create an Account!</h1>
                            </div>
                            <form class="user">
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" name = "first" class="form-control form-control-user" id="exampleFirstName"
                                            placeholder="First Name">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="text" name = "last" class="form-control form-control-user" id="exampleLastName"
                                            placeholder="Last Name">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <input type="email" name = "email" class="form-control form-control-user" id="exampleInputEmail"
                                        placeholder="Email Address">
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="password" name = "pw" class="form-control form-control-user"
                                            id="exampleInputPassword" placeholder="Password">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="password" name = "rpw" class="form-control form-control-user"
                                            id="exampleRepeatPassword" placeholder="Repeat Password">
                                    </div>
                                </div>
                                <button type="button" onclick="registerAccount('${base}')"  class="btn btn-primary btn-user btn-block">
                                    Register Account
                                </button>
                                <hr>
                                <a  class="btn btn-google btn-user btn-block">
                                    <i class="fab fa-google fa-fw"></i> Register with Google
                                </a>
                                <a href="index.html" class="btn btn-facebook btn-user btn-block">
                                    <i class="fab fa-facebook-f fa-fw"></i> Register with Facebook
                                </a>
                            </form>
                            <hr>
                            <div class="text-center">
                                <a class="small" href="${base }/password/forget">Forgot Password?</a>
                            </div>
                            <div class="text-center">
                                <a class="small" href="${base }/login">Already have an account? Login!</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>

    <script src="${base }/js/admin/vendor/jquery/jquery.min.js"></script>
    <script src="${base }/js/admin/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="${base }/js/admin/vendor/jquery-easing/jquery.easing.min.js"></script>
	
	<!-- Custom scripts for all pages-->
	<script src="${base }/js/admin/sb-admin-2.min.js"></script>
<jsp:include page="/WEB-INF/views/administrator/layout/js.jsp"></jsp:include>
</body>

</html>