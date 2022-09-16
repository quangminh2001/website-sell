package com.devpro.karma.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devpro.karma.entities.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{
	@Query("Select u from Users u where u.status = 0 and u.username = ?1")
	Optional<Users> findUsersByUsername(String username);
	
}
