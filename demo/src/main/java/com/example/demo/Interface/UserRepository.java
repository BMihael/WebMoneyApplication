package com.example.demo.Interface;

import org.springframework.data.repository.CrudRepository;

import  com.example.demo.User;

public interface UserRepository  extends CrudRepository<User, Long>{
	////Iterable<User> findAll();
	////User save(User user);
	
	///void delete(String username);
	///User findOne(String username);
	///void update(String username, User userNew,User user);
}
