package com.bootcamp.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.model.User;
import com.bootcamp.service.UserService;

@RestController
@RequestMapping("/secure/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<Collection<User>> findAll(@RequestParam(value = "nama", required = false) String nama) {
		Collection<User> list = userService.findAll();

		ResponseEntity<Collection<User>> result = new ResponseEntity<>(list, HttpStatus.OK);
		return result;
	}

	@RequestMapping(value = "/{kode}", method = RequestMethod.GET)
	public ResponseEntity<User> findOne(@PathVariable("kode") String kode) {
		User user = userService.findOne(kode);

		ResponseEntity<User> result = new ResponseEntity<>(user, HttpStatus.OK);
		return result;
	}

	@RequestMapping(value = "/search/", method = RequestMethod.GET)
	public ResponseEntity<User> searchByUserNamePassword(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password) {
		User user = userService.searchByUsernamePassword(username, password);

		ResponseEntity<User> result = new ResponseEntity<>(user, HttpStatus.OK);
		return result;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<User> save(@RequestBody User user) {
		userService.save(user);

		ResponseEntity<User> result = new ResponseEntity<>(HttpStatus.OK);
		return result;
	}

	@RequestMapping(value = "/{kode}", method = RequestMethod.DELETE)
	public ResponseEntity<User> deleteById(@PathVariable("kode") String kode) {
		userService.deleteById(kode);

		ResponseEntity<User> result = new ResponseEntity<>(HttpStatus.OK);
		return result;
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public ResponseEntity<User> update(@RequestBody User user) {
		userService.update(user);

		ResponseEntity<User> result = new ResponseEntity<>(HttpStatus.OK);
		return result;

	}
}