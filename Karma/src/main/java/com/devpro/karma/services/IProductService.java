package com.devpro.karma.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.devpro.karma.dto.ProductSearchModel;
import com.devpro.karma.entities.Products;
import com.devpro.karma.services.implement.PagerData;

@Service
public interface IProductService {
	int count();

	List<Products> findAll();

	<S extends Products> S save(S entity);

	Products findById(Integer id);

	Products SaveOrUpdate(Products product, MultipartFile multipartAvt, MultipartFile[] multipartImgs)
			throws IllegalStateException, IOException;

	ProductSearchModel findModelSearch(HttpServletRequest request);
	
	PagerData<Products> searchProduct(ProductSearchModel productSearch, int itemPerPage);
}
