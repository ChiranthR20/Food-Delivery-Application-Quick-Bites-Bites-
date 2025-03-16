package com.foodclone.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodclone.dao.RestaurantDAO;
import com.foodclone.Models.*;

public class RestaurantDAOImpl implements RestaurantDAO {
	List<Restaurant> restaurantList = new ArrayList<Restaurant>();
	private static final String SELECT_QUERY = "select * from `restaurant` ";
	private static final String DELETE_QUERY = "delete from `restaurant` where `restaurantId`=?";
	private static final String FETCH_SPECIFIC_QUERY = "select * from `restaurant` where `RestaurantId`=? ";
	private static final String UPDATE_QUERY = "update `restaurant` set `name`=? where `restaurantId`=?";
	private static final String INSERT_QUERY = "insert into `restaurant`(restaurantId,name,address,phonenumber,rating,cuisineType,DeliveryTime,AdminUserId,Isactive) values(?,?,?,?,?,?,?,?,?)";
	private static String url = "jdbc:mysql://localhost:3306/foodtap";
	private static String username = "root";
	private static String password = "root";
	private static Connection con;
	private PreparedStatement pstmt;
	private Restaurant r;
	private int status;
	private Statement stmt;
	private ResultSet resultSet;

	public RestaurantDAOImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addRestaurant(Restaurant r) {
		try {

			pstmt = con.prepareStatement(INSERT_QUERY);
			pstmt.setInt(1, r.getRestaurantId());
			pstmt.setString(2, r.getName());
			pstmt.setString(3, r.getAddress());
			pstmt.setInt(4, r.getPhonenumber());
			pstmt.setDouble(5, r.getRating());
			pstmt.setString(6, r.getCuisineType());
			pstmt.setInt(7, r.getDeliveryTime());
			pstmt.setString(8, r.getAdminUserId());
			pstmt.setInt(9, r.getIsActive());
			pstmt.setString(10, r.getImagePath());

			status = pstmt.executeUpdate();
			if (status != 0) {
				System.out.println("Success");
			} else {
				System.out.println("Failure");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<Restaurant> getAllRestaurant() {
		// TODO Auto-generated method stub
		try {
			stmt = con.createStatement();
			resultSet = stmt.executeQuery(SELECT_QUERY);

			restaurantList = extractRestaurantListFromResultSet(resultSet);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return restaurantList;
	}

	List<Restaurant> extractRestaurantListFromResultSet(ResultSet resultSet) {
		try {
			while (resultSet.next()) {
				restaurantList.add(new Restaurant(resultSet.getInt("restaurantId"), resultSet.getString("name"),
						resultSet.getString("address"), resultSet.getInt("phonenumber"), resultSet.getDouble("rating"),
						resultSet.getString("cuisineType"), resultSet.getInt("DeliveryTime"),
						resultSet.getString("AdminUserId"), resultSet.getInt("isactive"),resultSet.getString("image")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return restaurantList;
	}

	public Restaurant getRestaurant(int restaurantId) {
		try {
			pstmt = con.prepareStatement(FETCH_SPECIFIC_QUERY);
			pstmt.setInt(1, restaurantId);
			resultSet = pstmt.executeQuery();

			restaurantList = extractRestaurantListFromResultSet(resultSet);

			if (!restaurantList.isEmpty()) {
				r = restaurantList.get(0);
			} else {
				System.out.println("No records found");
				System.exit(0);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;

	}

	public void updateRestaurant(Restaurant r) {
		try {
			pstmt = con.prepareStatement(UPDATE_QUERY);
			pstmt.setString(1, r.getName());
			pstmt.setInt(2, r.getRestaurantId());
			status = pstmt.executeUpdate();
			if (status != 0) {
				System.out.println("Updated successfully");
			} else {
				System.out.println("Not updated");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void deleteRestaurant(int restaurantId) {
		try {
			pstmt = con.prepareStatement(DELETE_QUERY);
			pstmt.setInt(1, restaurantId);
			status = pstmt.executeUpdate();
			if (status != 0) {
				System.out.println("deleted successfully");
			} else {
				System.out.println("not deleted successfully");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

