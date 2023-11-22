package com.training.userservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.userservice.dao.UserDao;
import com.training.userservice.dao.UserDetails;

@RestController
public class UserController {

	@Autowired
	UserDao dao;
	
	@PostMapping("/save")
	public String saveUser(@RequestBody UserDetails user) {
	return dao.saveUser(user);
	}
	
	@GetMapping("/users")
	public List<UserDetails> getAllUsers(){
		return dao.geatAllUsers();
	}
	
	@GetMapping("/user/{uid}")
	public UserDetails getUser(@PathVariable Integer uid) {
		return dao.getUser(uid);
	}
	
	@DeleteMapping("/delete/{uid}")
	public String delteUser(@PathVariable Integer uid) {
		return dao.deleteUser(uid);
	}
	
}
