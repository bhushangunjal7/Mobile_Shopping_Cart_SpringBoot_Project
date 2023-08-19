package com.mobileshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mobileshop.entity.Customer;
import com.mobileshop.exception.ResourceNotFoundException;
import com.mobileshop.repository.CustomerRepo;
import com.mobileshop.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService custService;
	
	@Autowired
	CustomerRepo repository;
	
	@PostMapping("/customers")
	public String saveCustomer(@RequestBody Customer customer) {
		custService.save(customer);
		return "Customer Data Added Successfully";
	}
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		return custService.findAll();
	}
	/*
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable int id) {
		return custService.findById(id);
	}*/
	
	@GetMapping("/customers/{id}")
	public Customer getCustomerById(@PathVariable (value ="id") int custId){
	return this.repository.findById(custId)
	.orElseThrow(() -> new ResourceNotFoundException("In Our Database requested Customer data not found with ID : " + custId) );
	}
}
	
	
