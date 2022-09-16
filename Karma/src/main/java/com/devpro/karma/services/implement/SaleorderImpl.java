package com.devpro.karma.services.implement;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.devpro.karma.dto.SaleorderSearch;
import com.devpro.karma.entities.Saleorder;
import com.devpro.karma.repository.SaleorderReponsitory;
import com.devpro.karma.services.ISaleorderService;

@Component
public class SaleorderImpl implements ISaleorderService {
	@Autowired
	private SaleorderReponsitory saleorderRepos;

	@PersistenceContext
	private EntityManager entityManager;

	public <S extends Saleorder> S save(S entity) {
		return saleorderRepos.save(entity);
	}
	
	public List<Saleorder> findAll() {
		return saleorderRepos.findAll();
	}
	
	public Saleorder findById(Integer id) {
		return saleorderRepos.findById(id).get();
	}

	public Saleorder saveOrUpdate(Saleorder saleorder) {
		if (saleorder.getId() == null) {
			saleorder.setCreatedDate(new Date());
			saleorder.setCode("HD" + System.currentTimeMillis());
			return saleorderRepos.save(saleorder);
		} else {
			Saleorder saleorderInDB = saleorderRepos.findById(saleorder.getId()).get();
			saleorder.setCreatedDate(saleorderInDB.getCreatedDate());
			saleorder.setUpdatedDate(new Date());
			return saleorderRepos.save(saleorder);
		}
	}

	public PagerData<Saleorder> searchSaleorder(SaleorderSearch saleorderSearch, Integer quanlityPerPage) {

		String sql = "select s from Saleorder s where 1=1";
		if (saleorderSearch != null) {
			if (!StringUtils.isEmpty(saleorderSearch.keyword)) {
				sql += " and (s.customerName like '%" + saleorderSearch.keyword + "%' or s.statusorder like '%"
						+ saleorderSearch.keyword + "%' or s.customerEmail like '%" + saleorderSearch.keyword + "%' )";
			}
			if (!StringUtils.isEmpty(saleorderSearch.getStatus()))
				sql += " and s.statusorder = '" + saleorderSearch.getStatus() + "'";
			if (!StringUtils.isEmpty(saleorderSearch.getByMonth())) {

			}
//				sql += " and s"
		}
		PagerData<Saleorder> pager = new PagerData<Saleorder>();
		Integer page = saleorderSearch.currentPage;
		@SuppressWarnings("unchecked")
		List<Saleorder> listData = entityManager.createQuery(sql).setFirstResult((page - 1) * quanlityPerPage)
				.setMaxResults((page - 1) * quanlityPerPage + quanlityPerPage).getResultList();
		pager.setCurrentPage(page);
		pager.setData(listData);

		pager.setTotalItems(listData.size());
		return pager;
	}
}
