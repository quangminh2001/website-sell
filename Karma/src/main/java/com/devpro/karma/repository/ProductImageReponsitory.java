package com.devpro.karma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devpro.karma.entities.ProductImages;

@Repository
public interface ProductImageReponsitory extends JpaRepository<ProductImages, Integer> {

}
