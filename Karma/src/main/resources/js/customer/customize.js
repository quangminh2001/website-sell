/**
 * 
 */

$('.increase').on('click', function() {
	// $(this) đối tượng html đang được tác động
	// ví dụ nếu như class có trong nhiều thẻ tag thì 
	var slg = $(this).parent().find('input').val();
	slg = parseInt(slg) + 1;
	$(this).parent().find('input').val(slg);
	// lấy giá trị của thuộc tính trong js getattribute và setatchible
	var price = $(this).attr('data-price');
	var total_price = slg * price;
	var formatter = new Intl.NumberFormat('en-US', {
		style: 'currency',
		currency: 'USD',
	});
	$(this).parents("tr").find('.totalPrice').text(formatter.format(total_price));
	// thay đổi giá trị của thuộc tnhs trong jquery
	$(this).parents('tr').find('.totalPrice').attr('data-total-price', total_price);
	// duyệt qua từng phần tử 
	var total_all = 0;
	$('.totalPrice').each(function() {
		var price_1_sp = $(this).attr('data-total-price');
		total_all += Number(price_1_sp);
	})
	$("#total_price_prduct").text(formatter.format(total_all));
});


$('.reduced').on('click', function() {
	// $(this) đối tượng html đang được tác động
	// ví dụ nếu như class có trong nhiều thẻ tag thì 
	var slg = $(this).parent().find('input').val();
	if (slg == 1) {
		slg = 1;
	} else {
		slg = parseInt(slg) - 1;
		$(this).parent().find('input').val(slg);
		// lấy giá trị của thuộc tính trong js getattribute và setatchible
		var price = $(this).attr('data-price');
		var total_price = slg * price;
		var formatter = new Intl.NumberFormat('en-US', {
			style: 'currency',
			currency: 'USD',
		});
		$(this).parents("tr").find('.totalPrice').text(formatter.format(total_price));
		// thay đổi giá trị của thuộc tnhs trong jquery
		$(this).parents('tr').find('.totalPrice').attr('data-total-price', total_price);
		// duyệt qua từng phần tử 
		var total_all = 0;
		$('.totalPrice').each(function() {
			var price_1_sp = $(this).attr('data-total-price');
			total_all += Number(price_1_sp);
		})
		$("#total_price_prduct").text(formatter.format(total_all));
	}
});

$('.apply_coupon').on('click', function() {
	// $(this) đối tượng html đang được tác động
	// ví dụ nếu như class có trong nhiều thẻ tag thì 
	let coupon_value = $(this).parent().find('input').attr('valueattr');
	let total_all = $('#total_price_prduct').text().replace("$", "");
	let totalAfterCoupon = total_all - coupon_value;
	alert(totalAfterCoupon);
	let formatter = new Intl.NumberFormat('en-US', {
		style: 'currency',
		currency: 'USD',
	});
	$("#total_price_prduct").text(formatter.format(totalAfterCoupon));
});