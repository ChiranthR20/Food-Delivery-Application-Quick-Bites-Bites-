package com.foodclone.dao;


import java.util.List;

import com.foodclone.Models.Menu;



public interface MenuDAO {
	public void addMenu(Menu m);

	List<Menu> getAllMenu(int restaurantId);

	Menu getMenu(int menuId);

	void updateMenu(Menu m);

	void deleteMenu(int menuId);
}
