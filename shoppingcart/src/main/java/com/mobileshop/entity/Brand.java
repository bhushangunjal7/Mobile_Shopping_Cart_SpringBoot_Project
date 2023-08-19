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
@Table(name="table_Brand")
public class Brand 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int brandId;
	private String brandName;
	private int quantity;
	
	@ManyToMany(targetEntity = Product.class,cascade=CascadeType.ALL)
	@JoinColumn(name="pb-fk",referencedColumnName ="brandId") 
	private List<Product> products;

	public int getBrandId() {
		return brandId;
	}


	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}


	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public List<Product> getProducts() {
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
