package com.shop.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "customer_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    @Column(name = "order_id")
    private int orderId;
    
    @Column(name = "customer_id")
    private int customerId;
    @Column(name = "customer_name")
    private String customerName;

    
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orders = new ArrayList<>();

    public Order(int customerId, String customerName) {
        this.customerId = customerId;
        this.customerName = customerName;
    }

    
    public Order() {}

    // Setter and getter for orderId
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderId() {
        return orderId;
    }


    public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	// Getter and setter for orders list
    public List<OrderItem> getOrders() {
        return orders;
    }

    public void addOrder(OrderItem order) {
            this.orders.add(order);
            order.setOrder(this);
    }

	public void setOrders(List<OrderItem> orders) {
		this.orders = orders;
	}
}
