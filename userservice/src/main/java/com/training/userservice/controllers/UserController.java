package com.training.userservice.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.userservice.model.User;

@RestController()
public class UserController {

	List<User> users = new ArrayList<User>();

	public UserController() {
		users.add(new User(1, "vivek", "Hyd", "vivek@gmail.com", "996699669966"));
		users.add(new User(2, "annad", "Bang", "anand@gmail.com", "996699669966"));
		users.add(new User(3, "raju", "Cheanni", "raju@gmail.com", "996699669966"));
		users.add(new User(4, "rani", "Pune", "rani@gmail.com", "996699669966"));
		users.add(new User(5, "monika", "Delhi", "monika@gmail.com", "996699669966"));
	}

	@RequestMapping("/greet")
	public String greet() {
		return "Hello From USerService";
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<User> getusers() {
		return users;
	}

	@RequestMapping("/user/{uid}")
	public User getUserById(@PathVariable int uid) {
		return users.stream().filter(u -> u.getUid() == uid).findFirst().orElseThrow(()->new RuntimeException("User Not found"));
	}

	@RequestMapping("/user")
	public User getUserByIdRequestParam(@RequestParam int uid) {
		return users.stream().filter(u -> u.getUid() == uid).findFirst().orElseThrow(()->new RuntimeException("User Not found"));
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public User saveUser(@RequestBody User usr) {
		users.add(usr);
		return users.stream().filter(u -> u.getUid() == usr.getUid()).findFirst().orElseThrow(()->new RuntimeException("User Not found"));
	}

	@RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
	public User updateUser(@PathVariable int id,@RequestBody User usr) {
		User existingUser = users.stream().filter(u->u.getUid() == id).findFirst().orElseThrow(()->new RuntimeException("User Not found"));
	
			existingUser.setUsername( (usr.getUsername()!=null) ? usr.getUsername(): existingUser.getUsername());
			existingUser.setAddress( (usr.getAddress()!=null) ? usr.getAddress(): existingUser.getAddress());
			existingUser.setContact( (usr.getContact()!=null) ? usr.getContact(): existingUser.getContact());
			existingUser.setEmail( (usr.getEmail()!=null) ? usr.getEmail(): existingUser.getEmail());
		
		return existingUser;
	}

	@RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable int id) {
		User exiting = users.stream().filter(u->u.getUid() == id).findFirst().orElseThrow(()->new RuntimeException("User Not found"));
	    users.remove(exiting);
	    return "User Deleted Succfully";
	}
	
	
}
