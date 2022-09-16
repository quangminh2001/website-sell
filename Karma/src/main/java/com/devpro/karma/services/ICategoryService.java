package com.devpro.karma.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.devpro.karma.dto.CategorySearchModel;
import com.devpro.karma.entities.Categories;
import com.devpro.karma.services.implement.PagerData;

@Service
public interface ICategoryService {
	List<Categories> findAll();
	Categories saveOrUpdate(Categories category);
	Optional<Categories> findById(Integer id);
	PagerData<Categories>  searchCategory(CategorySearchModel categorySearch);
	 <S extends Categories> S save(S entity) ;
	 List<Categories> findAllCategoryByStatusTrue();
}
