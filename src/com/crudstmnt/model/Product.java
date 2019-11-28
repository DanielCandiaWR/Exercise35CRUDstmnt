package com.crudstmnt.model;

public class Product {
	private int id;
	private String productName;
	private double productPrice;
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return this.id;
	}
	
	public void setProductName(String name) {
		this.productName = name;
	}
	public String getProductName() {
		return this.productName;
	}
	
	public void setProductPrice(double price) {
		this.productPrice = price;
	}
	public double getProductPrice() {
		return this.productPrice;
	}
	
	public String toString() {
		return String.format("'%s',%d", this.productName, this.productPrice);
	}
}
