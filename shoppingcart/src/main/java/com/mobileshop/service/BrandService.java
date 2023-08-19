package com.mobileshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mobileshop.entity.Brand;
import com.mobileshop.repository.BrandRepo;

@Service
public class BrandService {
	
	@Autowired
	BrandRepo brandRepo;

	public ResponseEntity<Brand> save(Brand brand) {
		 try {
			return new ResponseEntity<>(brandRepo.save(brand), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<List<Brand>> findAll() {
		try {
			List<Brand> list = brandRepo.findAll();
			
			if (list.isEmpty() || list.size() == 0) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Brand> findById(int id) {
        Optional<Brand> brand = brandRepo.findById(id);
		
		if (brand.isPresent()) {
			return new ResponseEntity<>(brand.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
