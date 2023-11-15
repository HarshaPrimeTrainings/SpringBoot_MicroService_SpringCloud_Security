package com.training.userservice.controllers;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.userservice.model.User;
import com.training.userservice.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService servivce;
	

	
	@PostMapping(value = "/greet",produces = {"application/text"},consumes  = {"application/json"})
	public ResponseEntity<String>  greet(@RequestBody String name) {
		return new ResponseEntity<String>("Hello From UserService "+ name,HttpStatus.ACCEPTED);
	}

	@GetMapping(value =  "/users")
	public ResponseEntity<List<User>> getusers() {
		return new ResponseEntity<List<User>>(servivce.getUsers(),HttpStatus.OK);
	}

	
	@GetMapping(value = "/user/{uid}")
	public ResponseEntity<User> getUserById(@PathVariable int uid) {
		return new ResponseEntity<User>(servivce.getUserById(uid),HttpStatus.OK);
	}

	
	@PostMapping(value = "/save")
	public ResponseEntity<User> saveUser(@RequestBody User usr) {
		return new ResponseEntity<User>(servivce.saveUser(usr),HttpStatus.CREATED);
	}

	@PutMapping(value = "/update/{id}")
	public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User usr) {
		return new ResponseEntity<User>(servivce.updateUser(id, usr),HttpStatus.CREATED);
	}
	
	@PatchMapping(value = "/update/{id}")
	public ResponseEntity<User> updateuserpartially(@PathVariable int id, @RequestBody Map<String, Object> feilds) {
		return new ResponseEntity<User>(servivce.updatePartially(id, feilds),HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int id) {
		return new ResponseEntity<String>(servivce.deleteUser(id),HttpStatus.ACCEPTED);
	}

}
