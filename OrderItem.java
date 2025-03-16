package com.foodclone.Models;

public class OrderItem {

	private int orderitemid;
	private int orderId;
	private int menuid;
	private int quantity;
	private double totalamount;

	public OrderItem() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the orderitemid
	 */
	public int getOrderitemid() {
		return orderitemid;
	}

	/**
	 * @param orderitemid the orderitemid to set
	 */
	public void setOrderitemid(int orderitemid) {
		this.orderitemid = orderitemid;
	}

	/**
	 * @return the orderId
	 */
	public int getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the menuid
	 */
	public int getMenuid() {
		return menuid;
	}

	/**
	 * @param menuid the menuid to set
	 */
	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the totalamount
	 */
	public double getTotalamount() {
		return totalamount;
	}

	/**
	 * @param totalamount the totalamount to set
	 */
	public void setTotalamount(double totalamount) {
		this.totalamount = totalamount;
	}

	public OrderItem( int orderId, int menuid, int quantity, double totalamount) {
		super();
		
		this.orderId = orderId;
		this.menuid = menuid;
		this.quantity = quantity;
		this.totalamount = totalamount;
	}

	@Override
	public String toString() {
		return orderitemid + " " + orderId + " " + menuid + " " + quantity + " " + totalamount;
	}

}
