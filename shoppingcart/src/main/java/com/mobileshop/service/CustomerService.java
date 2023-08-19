package com.mobileshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mobileshop.entity.Customer;
import com.mobileshop.repository.CustomerRepo;

@Service
public class CustomerService 
{
	@Autowired
	CustomerRepo repository;

	public List<Customer> getData() {
		return (List<Customer>) repository.findAll();
	}

	public void deleteCustomer(int i) 
	{
		repository.deleteById(i);
	}

	public ResponseEntity<Customer> save(Customer customer) {
		try {
			return new ResponseEntity<>(repository.save(customer), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<List<Customer>> findAll() {
		try {
			List<Customer> list = repository.findAll();
			
			if (list.isEmpty() || list.size() == 0) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Customer> findById(int id) {
		Optional<Customer> customer = repository.findById(id);
		
		if (customer.isPresent()) {
			return new ResponseEntity<>(customer.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	

}
