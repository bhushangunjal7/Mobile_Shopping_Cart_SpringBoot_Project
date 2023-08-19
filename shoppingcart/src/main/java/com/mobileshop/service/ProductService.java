package com.mobileshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mobileshop.entity.Product;
import com.mobileshop.repository.ProductRepo;

@Service
public class ProductService {
	
	@Autowired
	ProductRepo repository;

	public ResponseEntity<Product> save(Product product) 
	{
		try {
			return new ResponseEntity<>(repository.save(product), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<List<Product>> findAll() {
		try {
			List<Product> list = repository.findAll();
			
			if (list.isEmpty() || list.size() == 0) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	public ResponseEntity<Product> findById(int id) {
	Optional<Product> product = repository.findById(id);
		
		if (product.isPresent()) {
			return new ResponseEntity<>(product.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
