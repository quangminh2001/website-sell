package com.devpro.karma.services;

import java.util.List;

import com.devpro.karma.entities.Users;

public interface UserService {
	Users createUser(Users user);
	List<Users> findAll();
	Users findById(Integer id);
	 Users save(Users user);
}
