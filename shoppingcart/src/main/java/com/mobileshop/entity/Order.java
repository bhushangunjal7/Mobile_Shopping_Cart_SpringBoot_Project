package com.mobileshop.entity;

import java.util.Date;
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
@Table(name="table_Order")

public class Order 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int orderId;
	
	
	private Date orderDate;
	private Date orderDileveredDate;
	private String orderStatus;
	private int custId;
	private int productId;
	private String paymentSource;
	private String paymentStatus;
	
	
	@ManyToMany(targetEntity = Customer.class,cascade=CascadeType.ALL)
	@JoinColumn(name="oc-fk",referencedColumnName ="custId") 
	private List<Customer> customers;
	 
	
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Date getOrderDileveredDate() {
		return orderDileveredDate;
	}
	public void setOrderDileveredDate(Date orderDileveredDate) {
		this.orderDileveredDate = orderDileveredDate;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getPaymentSource() {
		return paymentSource;
	}
	public void setPaymentSource(String paymentSource) {
		this.paymentSource = paymentSource;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public List<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
}