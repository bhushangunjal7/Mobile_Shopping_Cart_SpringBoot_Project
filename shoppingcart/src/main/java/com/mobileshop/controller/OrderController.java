package com.mobileshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mobileshop.entity.Order;
import com.mobileshop.service.OrderService;

@RestController
public class OrderController {
	

	@Autowired
	OrderService orderService;
	
	@PostMapping("/orders")
	public ResponseEntity<Order> saveCustomer(@RequestBody Order order) {
		return orderService.save(order);
	}
	
	@GetMapping("/orders")
	public ResponseEntity<List<Order>> getAllOrders() {
		return orderService.findAll();
	}
	
	@GetMapping("/orders/{id}")
	public ResponseEntity<Order> getOrder(@PathVariable int id) {
		return orderService.findById(id);
	}
	
}
