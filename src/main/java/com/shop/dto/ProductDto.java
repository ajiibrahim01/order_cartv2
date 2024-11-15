package com.shop.dto;

import javax.inject.Inject;

import com.shop.service.ProductService;


public class ProductDto {
	private String id;
	private String name;
	private String type;
	private double price;
	
	
	public ProductDto() {}
	
	public ProductDto(String id, String name, String type, double price) {
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
