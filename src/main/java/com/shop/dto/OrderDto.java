package com.shop.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.shop.entity.OrderItem;


public class OrderDto {
	
    private int orderId;

    private int customerId;
    private String customerName;

    private static List<OrderItemDto> orders = new ArrayList<>();

    public OrderDto(int customerId, String customerName) {
        this.customerId = customerId;
        this.customerName = customerName;
    }

    
    public OrderDto() {}

    public double totalPrice() {
        double total = 0;
        for (OrderItemDto order : orders) {
            total += order.itemPrice();
        }
        return total;
    }

    // Setter and getter for orderId
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderId() {
        return orderId;
    }

    // Setter and getter for customerId
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getCustomerId() {
        return customerId;
    }

    // Setter and getter for customerName
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    // Getter and setter for orders list
    public List<OrderItemDto> getOrders() {
        return orders;
    }

    public void addOrder(OrderItemDto order) {
        boolean isExist = false;
        for (OrderItemDto item : this.orders) {
            if (item.getId().equals(order.getId())) {
                int prevQuantity = item.getQuantity();
                item.setQuantity(prevQuantity + order.getQuantity());
                isExist = true;
                break;
            }
        }
        if (!isExist) {
            this.orders.add(order);
        }
    }
}
