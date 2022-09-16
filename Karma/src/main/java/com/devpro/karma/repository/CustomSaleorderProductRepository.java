package com.devpro.karma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devpro.karma.dto.SaleorderProductCustom;
import com.devpro.karma.entities.SaleorderProduct;

@Repository
public interface CustomSaleorderProductRepository extends JpaRepository<SaleorderProduct, Integer>{
	
//	@Query("SELECT new com.devpro.karma.dto.SaleorderProductCustom(s.name,count(s)) from SaleorderProduct s group by s.name order by count(s) desc")
//	List<SaleorderProductCustom> findProductCount();
}
