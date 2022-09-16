/**
 * 
 */
function reset(baseUrl) {
	jQuery.ajax({
		url: baseUrl + "admin/product/list",
		type: "get",
	});
}

function registerAccount(baseUrl) {
	var password = jQuery("#exampleInputPassword").val();
	var repassword = jQuery("#exampleRepeatPassword").val();
	if (password !== repassword) {
		Swal.fire({
			icon: 'error',
			title: 'Oops...',
			text: 'Password is not equal repassword!',
		})
	} else {
		var user = {
			username: jQuery("#exampleFirstName").val() + jQuery("#exampleLastName").val(),
			email: jQuery("#exampleInputEmail").val(),
			password: password,
		}
		jQuery.ajax({
			url: baseUrl + "/register/account",
			type: "post",					   //-> method type của Request Mapping	
			contentType: "application/json",   //-> nội dung gửi lên dạng json <=> javascript object
			data: JSON.stringify(user),

			dataType: "json", // kiểu dữ liệu trả về từ Controller
			success: function(jsonResponse) { // gọi ajax thành công
				Swal.fire({
					icon: 'success',
					title: 'Success',
					text: 'You registered successfully',
				})
			},
			error: function(jqXhr, textStatus, errorMessage) { // gọi ajax thất bại
				alert("error");
			}

		});
	}

}


function blockOrActiveProduct(baseUrl, productID) {
	// tạo javascript object.  
	Swal.fire({
		title: 'Do you want to alter this product?',
		showDenyButton: true,
		showCancelButton: true,
		confirmButtonText: 'Save',
		denyButtonText: `Don't save`,
	}).then((result) => {
		/* Read more about isConfirmed, isDenied below */
		if (result.isConfirmed) {
			Swal.fire('Saved!', '', 'success')
			var requestBody = {
				id: productID,
			};
			// $ === jQuery
			// json == javascript object
			jQuery.ajax({
				url: baseUrl + "/admin/product/list/blockOrActive", //->request mapping
				type: "post",					   //-> method type của Request Mapping	
				contentType: "application/json",   //-> nội dung gửi lên dạng json <=> javascript object
				data: JSON.stringify(requestBody),
				dataType: "json", // kiểu dữ liệu trả về từ Controller
				success: function(json) { // gọi ajax thành công
					location.reload();
				},
				error: function(jqXhr, textStatus, errorMessage) { // gọi ajax thất bại
					alert("error");
				}
			});
		} else if (result.isDenied) {
			Swal.fire('Changes are not saved', '', 'info')
		}
	})
}
function blockOrActiveCategory(baseUrl, categoryId) {
	// tạo javascript object.  
	Swal.fire({
		title: 'Do you want to alter this category?',
		showDenyButton: true,
		showCancelButton: true,
		confirmButtonText: 'Save',
		denyButtonText: `Don't save`,
	}).then((result) => {
		/* Read more about isConfirmed, isDenied below */
		if (result.isConfirmed) {
			Swal.fire('Saved!', '', 'success');
			var requestBody = {
				id: categoryId,
			};
			// $ === jQuery
			// json == javascript object
			jQuery.ajax({
				url: baseUrl + "/admin/category/list/blockOrActive", //->request mapping
				type: "post",					   //-> method type của Request Mapping	
				contentType: "application/json",   //-> nội dung gửi lên dạng json <=> javascript object
				data: JSON.stringify(requestBody),
				dataType: "json", // kiểu dữ liệu trả về từ Controller
				success: function(json) { // gọi ajax thành công
					location.reload();
				},
				error: function(jqXhr, textStatus, errorMessage) { // gọi ajax thất bại
					alert("error");
				}
			});
		} else if (result.isDenied) {
			Swal.fire('Changes are not saved', '', 'info')
		}
	})
}
function reload(){
	location.reload();
}
function blockOrActivePost(baseUrl, categoryId) {
	// tạo javascript object.  
	Swal.fire({
		title: 'Do you want to alter this post?',
		showDenyButton: true,
		showCancelButton: true,
		confirmButtonText: 'Save',
		denyButtonText: `Don't save`,
	}).then((result) => {
		/* Read more about isConfirmed, isDenied below */
		if (result.isConfirmed) {
			Swal.fire('Saved!', '', 'success');
			var requestBody = {
				id: categoryId,
			};
			// $ === jQuery
			// json == javascript object
			jQuery.ajax({
				url: baseUrl + "/admin/post/list/blockOrActive", //->request mapping
				type: "post",					   //-> method type của Request Mapping	
				contentType: "application/json",   //-> nội dung gửi lên dạng json <=> javascript object
				data: JSON.stringify(requestBody),
				dataType: "json", // kiểu dữ liệu trả về từ Controller
				success: function(json) { // gọi ajax thành công
					reload();
				},
				error: function(jqXhr, textStatus, errorMessage) { // gọi ajax thất bại
					alert("error");
				}
			});
			
		} else if (result.isDenied) {
			Swal.fire('Changes are not saved', '', 'info')
		}
	})
}

function blockOrActiveUser(baseUrl, userid) {
	// tạo javascript object.  
	Swal.fire({
		title: 'Do you want to alter the status this user?',
		showDenyButton: true,
		showCancelButton: true,
		confirmButtonText: 'Save',
		denyButtonText: `Don't save`,
	}).then((result) => {
		/* Read more about isConfirmed, isDenied below */
		if (result.isConfirmed) {
			Swal.fire('Saved!', '', 'success');
			var requestBody = {
				id: userid,
			};
			// $ === jQuery
			// json == javascript object
			jQuery.ajax({
				url: baseUrl + "/admin/user/list/blockOrActive", //->request mapping
				type: "post",					   //-> method type của Request Mapping	
				contentType: "application/json",   //-> nội dung gửi lên dạng json <=> javascript object
				data: JSON.stringify(requestBody),
				dataType: "json", // kiểu dữ liệu trả về từ Controller
				success: function(json) { // gọi ajax thành công
					reload();
				},
				error: function(jqXhr, textStatus, errorMessage) { // gọi ajax thất bại
					alert("error");
				}
			});
			
		} else if (result.isDenied) {
			Swal.fire('Changes are not saved', '', 'info')
		}
	})
}
function changeStatusOrder(baseUrl, orderId, status) {
	// tạo javascript object.  
	Swal.fire({
		title: 'Do you want to alter status this order ?',
		showDenyButton: true,
		showCancelButton: true,
		confirmButtonText: 'Save',
		denyButtonText: `Don't save`,
	}).then((result) => {
		/* Read more about isConfirmed, isDenied below */
		if (result.isConfirmed) {
			Swal.fire('Saved!', '', 'success');
			var requestBody = {
				id: orderId,
				statusorder: status
			};
			// $ === jQuery
			// json == javascript object
			jQuery.ajax({
				url: baseUrl + "/admin/saleorder/list/blockOrActive", //->request mapping
				type: "post",					   //-> method type của Request Mapping	
				contentType: "application/json",   //-> nội dung gửi lên dạng json <=> javascript object
				data: JSON.stringify(requestBody),
				dataType: "json", // kiểu dữ liệu trả về từ Controller
				success: function(json) { // gọi ajax thành công
					$("#status"+orderId).html(json.status);
				},
				error: function(jqXhr, textStatus, errorMessage) { // gọi ajax thất bại
					alert("error");
				}
			});
			
		} else if (result.isDenied) {
			Swal.fire('Changes are not saved', '', 'info')
		}
	})
}

function deletedContact(baseUrl, contactId) {
	// tạo javascript object.  
	Swal.fire({
		title: 'Do you want to delete this contact?',
		showDenyButton: true,
		showCancelButton: true,
		confirmButtonText: 'Save',
		denyButtonText: `Don't save`,
	}).then((result) => {
		/* Read more about isConfirmed, isDenied below */
		if (result.isConfirmed) {
			Swal.fire('Saved!', '', 'success');
			var requestBody = {
				id: contactId,
			};
			// $ === jQuery
			// json == javascript object
			jQuery.ajax({
				url: baseUrl + "/admin/contact/list/delete", //->request mapping
				type: "post",					   //-> method type của Request Mapping	
				contentType: "application/json",   //-> nội dung gửi lên dạng json <=> javascript object
				data: JSON.stringify(requestBody),
				dataType: "json", // kiểu dữ liệu trả về từ Controller
				success: function(json) { // gọi ajax thành công
					$("#"+contactId).removeAttr("style").hide();
				},
				error: function(jqXhr, textStatus, errorMessage) { // gọi ajax thất bại
					alert("error");
				}
			});
			
		} else if (result.isDenied) {
			Swal.fire('Changes are not saved', '', 'info')
		}
	})
}