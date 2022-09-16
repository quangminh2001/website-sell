package com.devpro.karma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devpro.karma.entities.Coupons;

@Repository
public interface CouponRepository extends JpaRepository<Coupons, Integer> {

}
