package com.training.springrestwithkeycloak.orders;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Orders, Integer>{

	public List<Orders> findByUsername(String username);
}
