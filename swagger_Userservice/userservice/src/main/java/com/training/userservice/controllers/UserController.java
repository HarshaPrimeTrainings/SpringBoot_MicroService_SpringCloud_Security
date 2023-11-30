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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.userservice.dto.userDto;
import com.training.userservice.model.User;
import com.training.userservice.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService servivce;
	
	@GetMapping("/greet")
	public String  orderServie() {
		return servivce.getGreet();
	}

	@GetMapping("/orders/{username}")
	public userDto getOrdersByUsername(@PathVariable String username) {
		return servivce.getOrders(username);
	}
	
	
	@PostMapping(value = "/greet")
	public ResponseEntity<String>  greet() {
		return new ResponseEntity<String>("Hello From UserService",HttpStatus.OK);
	}

	@GetMapping(value =  "/users")
	public ResponseEntity<List<User>> getusers() {
		return new ResponseEntity<List<User>>(servivce.getUsers(),HttpStatus.OK);
	}

	@GetMapping("/username/{name}")
	public ResponseEntity<User> getUserByName(@PathVariable String name){
		return new ResponseEntity<User>(servivce.getUserByName(name),HttpStatus.OK);
	}
	
	@GetMapping("/userbyaddr/{addr}")
	public ResponseEntity <List<User>> getUserByAddr(@PathVariable String addr){
		return new ResponseEntity<List<User>>(servivce.getUserByAddres(addr),HttpStatus.OK);
	}
	
	@GetMapping(value = "/user/{uid}")
	public ResponseEntity<User> getUserById(@PathVariable int uid) {
		return new ResponseEntity<User>(servivce.getUserById(uid),HttpStatus.OK);
	}

	@GetMapping(value = "/userbyemail/{email}")
	public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
		return new ResponseEntity<User>(servivce.getUserByEmail(email),HttpStatus.OK);
	}
	
	@GetMapping(value = "/email/{username}")
	public ResponseEntity<String> getEmailByUserName(@PathVariable String username) {
		return new ResponseEntity<String>(servivce.getEmailByUserName(username),HttpStatus.OK);
	} 
	
	@GetMapping(value = "/usernames/{addr}")
	public ResponseEntity<List<String>> getUsernameByAddr(@PathVariable String addr) {
		return new ResponseEntity<List<String>>(servivce.getUsernameByAddr(addr),HttpStatus.OK);
	} 
	
	@GetMapping(value = "/userbypage/{pageSize}/{pageNumber}")
	public  ResponseEntity <List<User>> getEmailByUserName(@PathVariable int pageNumber,@PathVariable int pageSize) {
		return new  ResponseEntity <List<User>>(servivce.getUsersByPage(pageNumber,pageSize),HttpStatus.OK);
	} 
	
	@GetMapping(value = "/userbysort/{sortby}")
	public  ResponseEntity <List<User>> getSortedUsers(@PathVariable String sortby) {
		return new  ResponseEntity <List<User>>(servivce.getUserSortByUsername(sortby),HttpStatus.OK);
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
