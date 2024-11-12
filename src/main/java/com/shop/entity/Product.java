package com.shop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	@Id
	@Column(name = "id")
	private String id;
	@Column(name = "name")
	private String name;
	@Column(name = "type")
	private String type;
	@Column(name = "price")
	private double price;
	
	
	public Product() {}
	public Product(String id, String name, String type, double price) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.price = price;
	}

	
	public void setId(String id ) {
		this.id = id;
	}
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
