package com.bootcamp.dao;

import java.util.Collection;

import com.bootcamp.model.User;

public interface UserDAO {
	public User findOne(String id);

	public Collection<User> findAll();

	public void save(User user);
	
	public User update(User user);

	public void delete(User user);

	public void deleteById(String id);
	
	public User seachByUsernamePassword(String username, String password);
}