package com.foodclone.dao;

import java.util.List;

import com.foodclone.Models.OrderItem;


public interface OrderItemDAO {

	public void addOrderItem(OrderItem o);

	List<OrderItem> getAllOrderItems();

	OrderItem getOrderItem(int orderitemid);

	void updateOrderItem(OrderItem o);

	void deleteOrderItem(int orderId);

}
