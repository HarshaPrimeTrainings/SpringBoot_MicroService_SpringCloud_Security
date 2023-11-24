package com.training.userservice.service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import com.training.userservice.UserRepository;
import com.training.userservice.exception.UserNotFoundException;
import com.training.userservice.model.User;

@Service
public class UserService {
		
	@Autowired
	UserRepository repo;

	public List<User> getUsers(){
		return (List<User>) repo.findAll();
	}
	
	public User getUserById(int uid) {
		return repo.findById(uid)
		.orElseThrow(() -> new UserNotFoundException("User Not found with id "+ uid));
	}
	
	public User saveUser(User user) {
		return repo.save(user);
	}
	
	
	public User getUserByName(String username) {
		return repo.findByUsername(username);
	}
	
	public User getUserByEmail(String email) {
		return repo.getUserByEmail(email);
	}
	
	public String getEmailByUserName(String username) {
		return repo.getEmailByUserName(username);
	}
	
	public List<User> getUserByAddres(String addr) {
		return repo.getByAddress(addr);
	}
	
	public User updateUser(int uid , User usr) {
		
		User existingUser =getUserById(uid);

		existingUser.setUsername(usr.getUsername());
		existingUser.setAddress(usr.getAddress());
		existingUser.setContact(usr.getContact());
		existingUser.setEmail(usr.getEmail());
		
		return repo.save(existingUser);
	}
	
	public User updatePartially(int uid, Map<String, Object> feilds) {
		User existingUser =getUserById(uid);
		
		feilds.forEach((k, v) -> {
			Field feild = ReflectionUtils.findField(User.class, k);
			feild.setAccessible(true);
			ReflectionUtils.setField(feild, existingUser, v);
		});
		return repo.save(existingUser);
	}
	
	public String deleteUser(int uid) {
		repo.deleteById(uid);
		return "User Deleted Succefully";
	}
	
}
