package com.training.userservice.service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import com.training.userservice.exception.UserNotFoundException;
import com.training.userservice.model.User;

@Service
public class UserService {

	List<User> users = new ArrayList<User>();

	public UserService() {
		users.add(new User(1, "vivek", "Hyd", "vivek@gmail.com", "996699669966"));
		users.add(new User(2, "annad", "Bang", "anand@gmail.com", "996699669966"));
		users.add(new User(3, "raju", "Cheanni", "raju@gmail.com", "996699669966"));
		users.add(new User(4, "rani", "Pune", "rani@gmail.com", "996699669966"));
		users.add(new User(5, "monika", "Delhi", "monika@gmail.com", "996699669966"));
	}
	
	public List<User> getUsers(){
		return users;
	}
	
	public User getUserById(int uid) {
		return users.stream().filter(u -> u.getUid() == uid).findFirst()
		.orElseThrow(() -> new UserNotFoundException("User Not found with id "+ uid));
	}
	
	public User saveUser(User user) {
		users.add(user);
		return getUserById(user.getUid());
	}
	
	
	public User updateUser(int uid , User usr) {
		
		User existingUser =getUserById(uid);

		existingUser.setUsername(usr.getUsername());
		existingUser.setAddress(usr.getAddress());
		existingUser.setContact(usr.getContact());
		existingUser.setEmail(usr.getEmail());
		return existingUser;
	}
	
	public User updatePartially(int uid, Map<String, Object> feilds) {
		User existingUser =getUserById(uid);
		
		feilds.forEach((k, v) -> {
			Field feild = ReflectionUtils.findField(User.class, k);
			feild.setAccessible(true);
			ReflectionUtils.setField(feild, existingUser, v);
		});
		return existingUser;
	}
	
	public String deleteUser(int uid) {
		User existingUser =getUserById(uid);
		users.remove(existingUser);
		return "User Deleted Succefully";
	}
	
}
