package com.foodclone.dao;

import java.util.List;

import com.foodclone.Models.User;

public interface UserDAO {

	public void addUser(User u);


	List<User> getAllUsers();

	User getUser(int userId);

	void updateUser(User u);

	void deleteUser(int userId);
	 User validateUser(String username, String password);
	 boolean registerUser(User user);
}
