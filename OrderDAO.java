package com.foodclone.dao;

import java.util.List;

import com.foodclone.Models.Order;


public interface OrderDAO {
	public int addOrder(Order o);
	List<Order> getAllOrder();

	Order getOrder(int orderId);

	void updateOrder(Order o);

	void deleteOrder(int orderId);
}
