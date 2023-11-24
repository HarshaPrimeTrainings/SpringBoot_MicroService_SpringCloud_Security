package com.training.userservice;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.training.userservice.model.User;


public interface UserRepository extends PagingAndSortingRepository<User, Integer>{

	public User findByUsername(String username); 

	public List<User> getByAddress(String address);
	
	@Query(value = "select * from user where email = :email",nativeQuery = true)
	public User getUserByEmail( String email);
	
	@Query(value = "select email from user where username = :username",nativeQuery = true)
	public String getEmailByUserName(String username);
	
	@Query(value = "select username from user where address = :address",nativeQuery = true)
	public List<String> getByUsersByAddr(String address);
	
	
}
