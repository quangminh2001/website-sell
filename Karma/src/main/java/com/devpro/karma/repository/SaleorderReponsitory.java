package com.devpro.karma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devpro.karma.entities.Saleorder;

@Repository
public interface SaleorderReponsitory extends JpaRepository<Saleorder, Integer> {

}
