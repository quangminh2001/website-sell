package com.devpro.karma.services.implement;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devpro.karma.dto.SaleorderProductCustom;
import com.devpro.karma.entities.Products;
import com.devpro.karma.repository.CustomSaleorderProductRepository;
import com.devpro.karma.services.CustomService;
import com.devpro.karma.services.IProductService;
import com.devpro.karma.services.ISaleorderService;

@Service
public class CustomServiceImpl implements CustomService {
	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private IProductService iProductService;


	
	public List<Products> search() {
		String sql = "SELECT product_id as 'productID', count(*) as 'count' FROM karma.tbl_saleorder_products group by product_id order by count(*) desc limit 0, 8";
		@SuppressWarnings("unchecked")
		List<Object[]> listObj = entityManager.createNativeQuery(sql).getResultList();
		List<Products> listProductBestSelling = new ArrayList<Products>();
		for (Object[] object : listObj) {
			listProductBestSelling.add(iProductService.findById(Integer.parseInt(object[0].toString())));
		}
		return listProductBestSelling;
	}
	public List<BigDecimal> customerSaleorder() {
		String sql = "SELECT month(s.created_date), sum(s.total) FROM karma.tbl_saleorder s where s.statusorder ='Finished' group by month(s.created_date)";
		
		@SuppressWarnings("unchecked")
		List<Object[]> listObj = entityManager.createNativeQuery(sql).getResultList();
		
		List<BigDecimal> liMap = new ArrayList<BigDecimal>();
		for(Object[] objects : listObj) {
			liMap.add(new BigDecimal(objects[1].toString()));
		}
		
		return liMap;
	}
}
