package com.devpro.karma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devpro.karma.entities.Products;

@Repository
public interface ProductReponsitory extends JpaRepository<Products, Integer> {

}
