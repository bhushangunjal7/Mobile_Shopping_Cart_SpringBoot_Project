
package com.mobileshop;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mobileshop.entity.Product;
import com.mobileshop.repository.ProductRepo;

@SpringBootTest
class JunitTestCases {

	@Autowired
	ProductRepo repository;

	@Test
	public void testForProduct() {
		Product product = new Product();
		product.getBrandId();
		product.setProductId(1);
		product.setPrice(56999);
		repository.save(product);
		assertNotNull(product);
	}

	

	@Test
	public void testForproduct2() {
		Product product = new Product();
		product.setPrice(1000);;
		repository.save(product);
		assertEquals(1000, product.getPrice());
	}
	
	
	@Test
	public void testForproduct3() {
		repository.deleteById(1); 
		assertThat(repository.existsById(1)).isFalse();
	}
	
	
	@Test
	public void testForproduct4() {
		Product product = new Product();
		product.setProductName("One-Plus");;;
		repository.save(product);
		assertEquals("One-Plus", product.getProductName());
	}
	
	

}
