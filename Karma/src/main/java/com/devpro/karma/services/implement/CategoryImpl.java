package com.devpro.karma.services.implement;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.devpro.karma.component.Utilities;
import com.devpro.karma.dto.CategorySearchModel;
import com.devpro.karma.entities.Categories;
import com.devpro.karma.repository.CategoryReponsitory;
import com.devpro.karma.services.ICategoryService;

@Component
public class CategoryImpl implements ICategoryService {
	@Autowired
	private CategoryReponsitory categoryReponsitory;

	@PersistenceContext
	private EntityManager entityManager;

	public List<Categories> findAll() {
		return categoryReponsitory.findAll();
	}

	
	
	public List<Categories> findAllCategoryByStatusTrue() {
		return categoryReponsitory.findAllCategoryByStatusTrue();
	}



	public Optional<Categories> findById(Integer id) {
		return categoryReponsitory.findById(id);
	}


	public <S extends Categories> S save(S entity) {
		return categoryReponsitory.save(entity);
	}


	public Categories saveOrUpdate(Categories category) {
		if (category.getId() == null) {
			category.setCreatedDate(new Date());
		} else {
			Categories categoryInDB = categoryReponsitory.findById(category.getId()).get();
			category.setCreatedDate(categoryInDB.getCreatedDate());
			category.setUpdatedDate(new Date());
		}
		category.setSeo(Utilities.slugify(category.getName()));
		return categoryReponsitory.save(category);
	}

	public PagerData<Categories> searchCategory(CategorySearchModel categorySearch) {
		PagerData<Categories> pager = new PagerData<Categories>();
		String sql = "Select c from Categories c where 1=1 ";
		if (categorySearch != null) {
			if (!StringUtils.isEmpty(categorySearch.keyword)) {
				sql += " and ( c.name like '%" + categorySearch.keyword + "%' or c.description like '%"
						+ categorySearch.keyword + "%')";
			}
			if(!StringUtils.isEmpty(categorySearch.getSeo()))
				sql += " and c.seo = '" +categorySearch.getSeo()+"' ";
			if(!StringUtils.isEmpty(categorySearch.getStatus()))
				sql += " and c.status = '"+categorySearch.getStatus()+"'";
		}
		System.out.println(sql);
		Query query = entityManager.createQuery(sql);
		int page = categorySearch.getPage();
		@SuppressWarnings("unchecked")
		List<Categories> listData = query.setFirstResult((page - 1) * 10).setMaxResults((page - 1) * 10 + 10)
				.getResultList();
		pager.setCurrentPage(page);
		pager.setData(listData);
		pager.setTotalItems(Integer.parseInt(categoryReponsitory.count() + ""));

		return pager;
	}
}
