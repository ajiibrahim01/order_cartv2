package com.shop.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_item")
public class OrderItem  {

    @Id
    @Column(name = "id")
    private String orderItemid;
    
    
    @Column(name = "qty")
    private int quantity;
    
    @Column(name = "total_price")
    private double totalPrice;
    @ManyToOne
    @JoinColumn(name = "product_id")  // Foreign key in the OrderItem table
    private Product product;
    
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)  
    private Order order;
    

    public OrderItem(String id,int quantity,double totalPrice) {
        this.orderItemid = id;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public OrderItem() {}

	public String getOrderItemid() {
		return orderItemid;
	}

	public void setOrderItemid(String orderItemid) {
		this.orderItemid = orderItemid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}


}
