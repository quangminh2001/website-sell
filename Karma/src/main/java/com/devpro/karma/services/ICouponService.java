package com.devpro.karma.services;

import org.springframework.stereotype.Service;

import com.devpro.karma.dto.CouponSearch;
import com.devpro.karma.entities.Coupons;
import com.devpro.karma.services.implement.PagerData;

@Service
public interface ICouponService {
	<S extends Coupons> S save(S entity) ;
	PagerData<Coupons> search(CouponSearch couponSearch);
	Coupons findByCode(String code);
}
