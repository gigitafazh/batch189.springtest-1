package com.bootcamp.service;

import java.util.Collection;

import com.bootcamp.model.User;

public interface UserService {
	public User findOne(String id);

	public Collection<User> findAll();

	public void save(User user);
	
	public User update(User user);

	public void delete(User user);

	public void deleteById(String id);

	public User searchByUsernamePassword(String username, String password);
}