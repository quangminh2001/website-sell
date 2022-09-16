/**
 * 
 */

function addToCart(baseUrl, productID) {
	var cartItem = {
		productId: productID,
		quantity: 1,
	};
	jQuery.ajax({
		url: baseUrl + "/ajax/addToCart",
		type: "post",					   //-> method type của Request Mapping	
		contentType: "application/json",   //-> nội dung gửi lên dạng json <=> javascript object
		data: JSON.stringify(cartItem),

		dataType: "json", // kiểu dữ liệu trả về từ Controller
		success: function(jsonResponse) { // gọi ajax thành công
			$("#iconTotalCart").html(jsonResponse.totalItems);
		},
		error: function(jqXhr, textStatus, errorMessage) { // gọi ajax thất bại
			alert("error");
		}

	});
}

function deleteToCart(baseUrl, productID) {
	var cartItem = {
		productId: productID,
		quantity: -1,
	};
	jQuery.ajax({
		url: baseUrl + "/ajax/addToCart",
		type: "post",					   //-> method type của Request Mapping	
		contentType: "application/json",   //-> nội dung gửi lên dạng json <=> javascript object
		data: JSON.stringify(cartItem),

		dataType: "json", // kiểu dữ liệu trả về từ Controller
		success: function(jsonResponse) { // gọi ajax thành công
			$("#iconTotalCart").html(jsonResponse.totalItems);
		},
		error: function(jqXhr, textStatus, errorMessage) { // gọi ajax thất bại
			alert("error");
		}

	});
}
function deleteItemFromCart(baseUrl, productID) {
	Swal.fire({
		title: 'Are you sure?',
		text: "You won't be able to revert this!",
		icon: 'warning',
		showCancelButton: true,
		confirmButtonColor: '#3085d6',
		cancelButtonColor: '#d33',
		confirmButtonText: 'Yes, delete it!'
	}).then((result) => {
		if (result.isConfirmed) {
			
			var cartItem = {
				productId: productID,
			};
			jQuery.ajax({
				url: baseUrl + "/ajax/deleteItemFromCart",
				type: "post",					   //-> method type của Request Mapping	
				contentType: "application/json",   //-> nội dung gửi lên dạng json <=> javascript object
				data: JSON.stringify(cartItem),
				dataType: "json", // kiểu dữ liệu trả về từ Controller
				success: function(jsonResponse) { // gọi ajax thành công
					window.setTimeout(this,3000);
					location.reload();
				},
				error: function(jqXhr, textStatus, errorMessage) { // gọi ajax thất bại
					alert("error");
				}

			});
			Swal.fire(
				'Deleted!',
				"You deleted this product from cart",
				'success',
			)
			timer: 10000;
		}
	})



}
function saveContact(baseUrl) {
	// tạo javascript object.  
	var requestBody = {
		email: jQuery("#idEmail").val(), // lay theo id
	};
	// $ === jQuery
	// json == javascript object

	jQuery.ajax({
		url: baseUrl + "/subcriber/ajax", //->request mapping
		type: "post",					   //-> method type của Request Mapping	
		contentType: "application/json",   //-> nội dung gửi lên dạng json <=> javascript object
		data: JSON.stringify(requestBody),

		dataType: "json", // kiểu dữ liệu trả về từ Controller
		success: function(jsonResult) { // gọi ajax thành công
			alert(jsonResult.code + " - " + jsonResult.message);
		},
		error: function(jqXhr, textStatus, errorMessage) { // gọi ajax thất bại
			alert("error");
		}
	});
}

function saveCon(baseUrl) {
	// tạo javascript object.  
	var requestBody = {
		firstName: jQuery("#first_name").val(),
		lastName: jQuery("#last_name").val(),
		message: jQuery("#message").val(),
		email: jQuery("#email").val(), // lay theo id
	};
	// $ === jQuery
	// json == javascript object
	jQuery.ajax({
		url: baseUrl + "/contact/save", //->request mapping
		type: "post",					   //-> method type của Request Mapping	
		contentType: "application/json",   //-> nội dung gửi lên dạng json <=> javascript object
		data: JSON.stringify(requestBody),
		dataType: "json", // kiểu dữ liệu trả về từ Controller
		success: function(messageReponse) { // gọi ajax thành công
			Swal.fire({
				position: 'top-end',
				icon: 'success',
				title: 'We will respond you as soon as possible',
				showConfirmButton: false,
				timer: 2500,
				position: 'center'
			})
		},
		error: function(jqXhr, textStatus, errorMessage) { // gọi ajax thất bại
			alert("error");
		}
	});
}

