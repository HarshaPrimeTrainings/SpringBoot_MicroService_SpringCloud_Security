package com.training.springsecuritywebdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.springsecuritywebdemo.dao.User;
import com.training.springsecuritywebdemo.dao.UserRepository;
import com.training.springsecuritywebdemo.dto.UserDto;

@RestController
public class UserController {

	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	UserRepository repo;
	
	
	
	@PostMapping("/signup")
	public UserDto saveUser(@RequestBody User u) {
		String encodedpwd = encoder.encode(u.getPassword());
		u.setPassword(encodedpwd);
		repo.save(u);
		
		UserDto savedUser = new UserDto();
		savedUser.setUsername(u.getUsername());
		savedUser.setEnabled(u.getEnabled());
		savedUser.setRole(u.getRole());
		savedUser.setPassword(u.getPassword());
		
		return savedUser;
	}
	
}
