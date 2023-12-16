package com.training.springrestwithkeycloak.orders;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OrderController {

	
	@Autowired
	OrderRepository repo;
	

	@RolesAllowed("order_user")
	@GetMapping("/orders")
	public List<Orders> getAllOrders(){
		return (List<Orders>) repo.findAll();
	}
	
	@GetMapping("/order/{id}")
	public Orders getOrderByd(@PathVariable Integer id) {
	return repo.findById(id).orElseThrow(()->new RuntimeException("No Order Placed with oid "+id));	
	}
	
	
	
}
