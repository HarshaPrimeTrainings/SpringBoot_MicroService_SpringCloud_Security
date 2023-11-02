package com.training.userdetailsmvcapp.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.training.userdetailsmvcapp.model.User;

@Controller
public class UserController {
	ArrayList<User> userList = new ArrayList<>();
	
	
	public UserController() {
		userList.add(new User(1, "Chandler", "123456", "NY"));
		userList.add(new User(2, "Joe Tribiany", "00231", "NY"));
		userList.add(new User(3, "Phebe", "13123", "NY"));
		userList.add(new User(4, "Manica", "95654", "NY"));
		userList.add(new User(5, "Ross", "8528", "NY"));
	}
	

	@RequestMapping(value = {"/","/home"})
	public ModelAndView listOfusers() {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("users", userList);		
		mav.setViewName("home");
		
		return mav;
	}
	
	@RequestMapping("/add")
	public String adduser() {
		return "adduser";
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveUser(User user) {
		int id = userList.get(userList.size()-1).getId();
		int newId = id+1;
		user.setId(newId);
		userList.add(user);
		return "redirect:/";
	}
	
	
}
