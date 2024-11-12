package com.shop.service;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;
import javax.transaction.*;

import com.shop.dto.ProductDto;
import com.shop.entity.Product;


@ApplicationScoped
public class ProductService {
	
	@PersistenceContext
	private EntityManager em;
	

	
	@Transactional
	public void addProduct(Product product) {

		

		try {
           
            em.persist(product);
            em.flush();
            System.out.println("product added successfully: "+ product.getName());
        } catch (Exception e) {
            
            System.err.println("Exception occurred: " + e.getMessage());
            throw e; 
        }

	}
	
	public List<ProductDto> findAll() {
		List<ProductDto> productList = new ArrayList<>();

		TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p", Product.class);
		List<Product> products = query.getResultList();
		for(Product product : products) {
			ProductDto newProduct = new ProductDto(product.getId(),product.getName(),product.getType(),product.getPrice());
			productList.add(newProduct);
		}
		return productList;
	}
	
	public ProductDto findById(String id) {
		ProductDto productDto = new ProductDto();
		Product product = em.find(Product.class, id);
		
		productDto.setId(product.getId());
		productDto.setName(product.getName());
		productDto.setType(product.getType());
		productDto.setPrice(product.getPrice());
		
		return productDto;
		
	}
	@Transactional
	public int updateProduct(Product product) {
		int result = 0;
		Product tempProduct = em.find(Product.class, product.getId());
		if (tempProduct.getId()== null) {
			System.err.println("id not found");
			return result;
		}
		try {
			tempProduct.setName(product.getName());
			tempProduct.setType(product.getType());
			tempProduct.setPrice(product.getPrice());
			result = 1;
			return result;
        } catch (Exception e) {
            System.err.println("Exception occurred: " + e.getMessage());
            throw e; 
        }
		
		
	}
}