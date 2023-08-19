package com.mobileshop.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="table_product")

public class Product 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int productId;
	private String productName;
	private float price;
	private int brandId;
	
	@ManyToMany(targetEntity = Order.class,cascade=CascadeType.ALL)
	@JoinColumn(name="po-fk",referencedColumnName ="productId") 
	private List<Order> orders;
	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price + ", brandId="
				+ brandId + ", orders=" + orders + "]";
	}
	
	
	
	

	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
}