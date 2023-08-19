package com.mobileshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mobileshop.entity.Order;
import com.mobileshop.repository.OrderRepo;

@Service
public class OrderService {
	
	@Autowired
	OrderRepo repository;

	public ResponseEntity<Order> save(Order order) {
		try {
			return new ResponseEntity<>(repository.save(order), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<List<Order>> findAll() {
		try {
			List<Order> list = repository.findAll();
			
			if (list.isEmpty() || list.size() == 0) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Order> findById(int id) {
		Optional<Order> order = repository.findById(id);
		
		if (order.isPresent()) {
			return new ResponseEntity<>(order.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}


}
