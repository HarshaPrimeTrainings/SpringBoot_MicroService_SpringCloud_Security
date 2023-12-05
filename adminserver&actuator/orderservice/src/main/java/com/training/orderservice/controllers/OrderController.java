package com.training.orderservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.orderservice.dao.Orders;
import com.training.orderservice.dao.OrderRepository;

@RestController
public class OrderController {

	
	@Autowired
	OrderRepository repo;
	
	@GetMapping("/greet")
	public String greet() {
		return "Hello From OrderService Instance2";
	}

	@GetMapping("/orders")
	public List<Orders> getAllOrders(){
		return (List<Orders>) repo.findAll();
	}
	
	@GetMapping("/order/{id}")
	public Orders getOrderByd(@PathVariable Integer id) {
	return repo.findById(id).orElseThrow(()->new RuntimeException("No Order Placed with oid "+id));	
	}
	
	
	@PostMapping("/save")
	public Orders saveOrder(@RequestBody Orders order) {
		return repo.save(order);
	}
	
	@GetMapping("/orders/{username}")
	public List<Orders> getOrdersByUserName(@PathVariable String username){
		return repo.findByUsername(username);
	}
	
	
}
