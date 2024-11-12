package com.shop.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.shop.dto.OrderDto;
import com.shop.entity.Order;
import com.shop.dto.OrderItemDto;
import com.shop.entity.OrderItem;

@ApplicationScoped
public class OrderService {
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public int submitOrder(OrderDto order) {
		int result = 0;
		try {
			Order pushedOrder = new Order();
			pushedOrder.setCustomerId(order.getCustomerId());
			pushedOrder.setCustomerName(order.getCustomerName());
			for(OrderItemDto item : order.getOrders()) {
				OrderItem orderItem = new OrderItem();
				orderItem.setId(UUID.randomUUID().toString());
				orderItem.setName(item.getName());
				orderItem.setPrice(item.getPrice());
				orderItem.setQuantity(item.getQuantity());
				orderItem.setType(item.getType());
				pushedOrder.addOrder(orderItem);
			}
			em.persist(pushedOrder);
			em.flush();
            result=1;
        } catch (Exception e) {
            
            System.err.println("Exception occurred: " + e.getMessage());
            throw e;
        }

		return result;
	}
}
