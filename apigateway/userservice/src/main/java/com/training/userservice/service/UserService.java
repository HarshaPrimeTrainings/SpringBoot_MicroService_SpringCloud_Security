package com.training.userservice.service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.client.RestTemplate;

import com.training.userservice.UserRepository;
import com.training.userservice.dto.Orders;
import com.training.userservice.dto.userDto;
import com.training.userservice.exception.UserNotFoundException;
import com.training.userservice.model.User;

@Service
public class UserService {
		
	@Autowired
	UserRepository repo;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${orderserivce.url}")
	String orderServiceAddress;
	
	
	public String getGreet() {
		return restTemplate.getForObject(orderServiceAddress+"/greet", String.class);
	}
	

	public userDto getOrders(String username) {
		User user = getUserByName(username);
		
		userDto dto = new userDto();
		
		dto.setUid(user.getUid());
		dto.setUsername(user.getUsername());
		dto.setAddress(user.getAddress());
		dto.setEmail(user.getEmail());
		dto.setContact(user.getContact());
		
		List<Orders> orders = restTemplate.getForObject(orderServiceAddress+"/orders/"+username,List.class);
		
		dto.setOrders(orders);
		
		return dto;
	}
	
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
	
	public List<String> getUsernameByAddr(String addr){
		return repo.getByUsersByAddr(addr);
	}
	
	public List<User> getUsersByPage(int pageNumber,int pageSize){
		 Pageable paging = PageRequest.of(pageNumber, pageSize);
		  Page<User> page= repo.findAll(paging);
		return page.toList();
	}
	
	public List<User> getUserSortByUsername(String sortby){
		return (List<User>) repo.findAll(Sort.by(sortby));
	}
	
	public List<User> getUserSortByUsernameDescending(String sortby){
		return (List<User>) repo.findAll(Sort.by(sortby).descending());
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
