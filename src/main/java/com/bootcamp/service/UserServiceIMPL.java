package com.bootcamp.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootcamp.dao.UserDAO;
import com.bootcamp.model.User;

@Service
@Transactional
public class UserServiceIMPL implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public User findOne(String id) {
		return userDAO.findOne(id);
	}

	@Override
	public Collection<User> findAll() {
		return userDAO.findAll();
	}
	
	@Override
	public void save(User user) {
		userDAO.save(user);
	}

	@Override
	public User update(User user) {
		return userDAO.update(user);
	}

	@Override
	public void delete(User user) {
		userDAO.delete(user);
	}

	@Override
	public void deleteById(String id) {
		userDAO.deleteById(id);
	}

	@Override
	public User searchByUsernamePassword(String username, String password) {
		return userDAO.seachByUsernamePassword(username, password);
	}
}