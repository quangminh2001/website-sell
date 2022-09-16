package com.devpro.karma.services.implement;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

@Service
public class TestService {
	@PersistenceContext
	EntityManager entityManager;

	public void testConnect() {
		String sql = "select * from categorytempt";
		 System.out.println(entityManager.createNativeQuery(sql).getResultList().stream().count());
		
	}
}
