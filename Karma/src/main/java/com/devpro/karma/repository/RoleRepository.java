package com.devpro.karma.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devpro.karma.entities.Roles;

public interface RoleRepository extends JpaRepository<Roles, Integer>{

	Roles findByName(String string);

}
