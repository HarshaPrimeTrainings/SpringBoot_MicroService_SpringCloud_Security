package com.training.userservice;

import org.springframework.data.repository.CrudRepository;

import com.training.userservice.model.User;


public interface UserRepository extends CrudRepository<User, Integer>{

}
