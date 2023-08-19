package com.mobileshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mobileshop.entity.Brand;
import com.mobileshop.exception.ResourceNotFoundException;
import com.mobileshop.repository.BrandRepo;
import com.mobileshop.service.BrandService;

@RestController
public class BrandController {
	
	@Autowired
	private BrandRepo repository;
	
	@Autowired
	private BrandService service;
	
	
	@PostMapping("/brands")
	public String saveBrand(@RequestBody Brand brand) {
		service.save(brand);
		return "All Data Inserted Sucessfully In our Database";	
		}
	
	@GetMapping("/brands")
	public ResponseEntity<List<Brand>> getAllBrands() {
		return service.findAll();
	}
	/*
	@GetMapping("/brands/{id}")
	public ResponseEntity<Brand> getBrand(@PathVariable int id) {
		return service.findById(id);
	}*/
	
	@GetMapping("/brands/{id}")
	public Brand getBrandsById(@PathVariable (value ="id") int brandId){
	return this.repository.findById(brandId)
	.orElseThrow(() -> new ResourceNotFoundException("In Our Database requested data not found with ID : " + brandId) );
	}
		
}
