package com.mobileshop;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.mobileshop.entity.Brand;
import com.mobileshop.entity.Customer;
import com.mobileshop.entity.Order;
import com.mobileshop.entity.Product;
import com.mobileshop.repository.BrandRepo;
import com.mobileshop.repository.CustomerRepo;
import com.mobileshop.repository.OrderRepo;
import com.mobileshop.repository.ProductRepo;
import com.mobileshop.service.BrandService;
import com.mobileshop.service.CustomerService;
import com.mobileshop.service.OrderService;
import com.mobileshop.service.ProductService;

@SpringBootTest
class MockitoTestCases {

	
	@Mock
	ProductRepo repository;
	
	@InjectMocks
	ProductService service;
	
	@Test
	public void testForProduct()
	{
		Product product = new Product();
		product.setPrice(1000);
		product.setProductId(1);
		product.setPrice(14999);
		service.save(product);
		assertNotNull(product);
	}


	@Mock
	CustomerRepo repository1;
	
	@InjectMocks
	CustomerService service1;
	
	@Test
	public void testForCustomerName() 
	{
		Customer cust = new Customer();
		cust.setName("Bhushan");
		service1.save(cust);
		assertEquals("Bhushan", cust.getName());
	}

	
	  @Test public void testForCustomerContact()
	   {
	    Customer cust=new Customer();
	    cust.setContact(98786754);
	    service1.save(cust); 
	    assertEquals(98786754, cust.getContact());
	    }
	 

	@Mock
	OrderRepo repository2;
	
	@InjectMocks
	OrderService service2;
	
	@Test
	public void testForOrderStatus() {
		Order ord = new Order();
		ord.setOrderStatus("Shipped");
		service2.save(ord);
		assertFalse("Shipped", false);
		
	}

	@Mock
	BrandRepo repository3;
	
	@InjectMocks
	BrandService service3;

	@Test
	public void testForBrandId() {
		Brand br = new Brand();
		br.setBrandId(1);
		service3.save(br);
		assertSame(1, br.getBrandId());
	}
	
	@Mock
	OrderRepo repository4;
	
	@InjectMocks
	OrderService service4;
	
	@Test
	public void testforoderpayment() {
		repository4.deleteById(1);
		assertThat(repository4.existsById(1)).isTrue();
		}
		
	
}
