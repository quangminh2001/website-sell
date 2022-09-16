package com.devpro.karma.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.devpro.karma.entities.Products;

public interface CustomService {
	List<Products> search();
	List<BigDecimal> customerSaleorder();
}
