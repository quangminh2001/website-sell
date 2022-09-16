package com.devpro.karma.services.implement;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.devpro.karma.dto.CouponSearch;
import com.devpro.karma.entities.Coupons;
import com.devpro.karma.repository.CouponRepository;
import com.devpro.karma.services.ICouponService;

@Component
public class CouponServiceImpl implements ICouponService {
	@Autowired
	private CouponRepository couponRepository;
	@PersistenceContext
	private EntityManager entityManager;
	public <S extends Coupons> S save(S entity) {
		if(entity.getId() == null) {
			entity.setCreatedDate(new Date());
		}else {
			entity.setUpdatedDate(new Date());
		}
		return couponRepository.save(entity);
	}
	public Coupons findByCode(String code) {
		String sql = "Select c from Coupons where c.code = '"+code+"'";
		Query query = entityManager.createQuery(sql);
		return (Coupons) query.getSingleResult();
	}
	public PagerData<Coupons> search(CouponSearch couponSearch){
		String sql = "select c from Coupons c where 1=1";
		if(couponSearch != null) {
			if(!StringUtils.isEmpty(couponSearch.getKeyword())) {
				sql += " and (c.code like '%" + couponSearch.getKeyword() + "%')";
			}
			if(!StringUtils.isEmpty(couponSearch.getStatus())) {
				sql += " and c.status like '%"  +couponSearch.getStatus()+"%'";
			}
		}
		Query query = entityManager.createQuery(sql);
		@SuppressWarnings("unchecked")
		List<Coupons> coupons = query.setFirstResult(10*(couponSearch.getPage()-1)).setMaxResults(10*(couponSearch.getPage()-1)+10).getResultList();
		coupons.forEach(c -> System.out.println( c.getCode()));
		PagerData<Coupons> pager = new PagerData<Coupons>();
		pager.setData(coupons);
		pager.setTotalItems(coupons.size());
		pager.setCurrentPage(couponSearch.getPage());
		return pager;
	}
	
}	
