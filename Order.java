package com.foodclone.Models;

public class Order {
	private int orderId;
	private int RestaurantId;
	private int uid;

	private double totalamount;
	private String status;
	private String paymentMode;

	public Order(int orderId, int restaurantId, int uid, double orderamount, String status, String paymentMode) {
		super();
		this.orderId = orderId;
		RestaurantId = restaurantId;
		this.uid = uid;
		this.totalamount = orderamount;
		this.status = status;
		this.paymentMode = paymentMode;
	}

	public Order() {
		// TODO Auto-generated constructor stub
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
	 * @return the restaurantId
	 */
	public int getRestaurantId() {
		return RestaurantId;
	}

	/**
	 * @param restaurantId the restaurantId to set
	 */
	public void setRestaurantId(int restaurantId) {
		RestaurantId = restaurantId;
	}

	/**
	 * @return the uid
	 */
	public int getUid() {
		return uid;
	}

	/**
	 * @param uid the uid to set
	 */
	public void setUid(int uid) {
		this.uid = uid;
	}

	/**
	 * @return the orderamount
	 */
	public double getTotalamount() {
		return totalamount;
	}

	/**
	 * @param orderamount the orderamount to set
	 */
	public void setTotalamount(double totalamount) {
		this.totalamount = totalamount;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the paymentMode
	 */
	public String getPaymentMode() {
		return paymentMode;
	}

	/**
	 * @param paymentMode the paymentMode to set
	 */
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	@Override
	public String toString() {
		return orderId + " " + RestaurantId + " " + uid + " " + totalamount + " " + status + " " + paymentMode;
	}

}
