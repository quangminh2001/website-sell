package com.devpro.karma.repository;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devpro.karma.entities.Categories;

@Repository
public interface CategoryReponsitory extends JpaRepository<Categories, Integer> {
	
	@Query("Select c from Categories c where c.status = true")
	List<Categories> findAllCategoryByStatusTrue();
}
