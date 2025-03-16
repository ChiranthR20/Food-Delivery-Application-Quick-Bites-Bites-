package com.foodclone.dao;

import java.util.List;

import com.foodclone.Models.Restaurant;

public interface RestaurantDAO {
	public void addRestaurant(Restaurant r);

	List<Restaurant> getAllRestaurant();

	Restaurant getRestaurant(int restaurantId);

	void updateRestaurant(Restaurant r);

	void deleteRestaurant(int restaurantId);
}
