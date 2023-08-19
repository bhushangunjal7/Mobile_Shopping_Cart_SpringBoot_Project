package com.mobileshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobileshop.entity.Brand;

@Repository
public interface BrandRepo extends JpaRepository<Brand, Integer> {

}
