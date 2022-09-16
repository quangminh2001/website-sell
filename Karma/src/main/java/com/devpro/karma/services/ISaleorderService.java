package com.devpro.karma.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devpro.karma.dto.SaleorderSearch;
import com.devpro.karma.entities.Saleorder;
import com.devpro.karma.services.implement.PagerData;

@Service
public interface ISaleorderService {
	Saleorder saveOrUpdate(Saleorder saleorder);

	PagerData<Saleorder> searchSaleorder(SaleorderSearch saleorderSearch, Integer quanlityPerPage);

	Saleorder findById(Integer id);
	
	List<Saleorder> findAll();
}
