package com.foodclone.Models;

public class Menu {
	private int menuId;
	private int restaurantId;
	private String ItemName;
	private String description;
	private Double price;
	private int isAvailable;
	private double ratings;
	private String image;
	
	

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * @return the menuId
	 */
	public int getMenuId() {
		return menuId;
	}

	/**
	 * @param menuId the menuId to set
	 */
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	/**
	 * @return the restaurantId
	 */
	public int getRestaurantId() {
		return restaurantId;
	}

	/**
	 * @param restaurantId the restaurantId to set
	 */
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return ItemName;
	}

	/**
	 * @param itemName the itemName to set
	 */
	public void setItemName(String itemName) {
		ItemName = itemName;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * @return the isAvailable
	 */
	public int getIsAvailable() {
		return isAvailable;
	}

	/**
	 * @param isAvailable the isAvailable to set
	 */
	public void setIsAvailable(int isAvailable) {
		this.isAvailable = isAvailable;
	}

	/**
	 * @return the ratings
	 */
	public double getRatings() {
		return ratings;
	}

	/**
	 * @param ratings the ratings to set
	 */
	public void setRatings(double ratings) {
		this.ratings = ratings;
	}

	public Menu(int menuId, int restaurantId, String itemName, String description, Double price, int isAvailable,
			double ratings,String image) {
		super();
		this.menuId = menuId;
		this.restaurantId = restaurantId;
		ItemName = itemName;
		this.description = description;
		this.price = price;
		this.isAvailable = isAvailable;
		this.ratings = ratings;
		this.image=image;
	}

	public Menu() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return menuId + " " + restaurantId + " " + ItemName + " " + description + " " + price + " " + isAvailable + " "
				+ ratings+" "+image;

	}

}
