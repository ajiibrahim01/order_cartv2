package com.shop.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_item")
public class OrderItem  {

    @Id
    @Column(name = "id")
    private String id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "type")
    private String type;
    
    @Column(name = "price")
    private double price;
    
    @Column(name = "qty")
    private int quantity;
    
    
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)  // Foreign key in the order_items table
    private Order order;

    public OrderItem(String id, String name, String type, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
    }

    public OrderItem() {}



    // Getters and setters for all fields
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

}
