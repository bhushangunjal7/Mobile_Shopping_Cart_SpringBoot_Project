package com.mobileshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobileshop.entity.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {


}
