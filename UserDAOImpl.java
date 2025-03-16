package com.foodclone.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodclone.Models.User;
import com.foodclone.dao.UserDAO;


public class UserDAOImpl implements UserDAO {
	List<User> userList=new ArrayList<User>();
	private static final String SELECT_QUERY = "select * from `user` ";
	private static final String DELETE_QUERY = "delete from `user` where `UserId`=?";
	private static final String FETCH_SPECIFIC_QUERY = "select * from `user` where `UserId`=? ";
	private static final String UPDATE_QUERY = "update `user` set `email`=? where `UserId`=?";
	private static final String INSERT_QUERY = "insert into `user`(UserId,name,email,password,mobile,Role,Address) values(?,?,?,?,?,?,?)";
	private static String url = "jdbc:mysql://localhost:3306/foodtap";
	private static String username = "root";
	private static String password = "root";
	private static Connection con;
	private PreparedStatement pstmt;
	private User u;
	private int status;
	private Statement stmt;
	private ResultSet resultSet;



	public UserDAOImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addUser(User u) {
		try {

			pstmt = con.prepareStatement(INSERT_QUERY);
			pstmt.setInt(1, u.getUid());
			pstmt.setString(2, u.getUsername());
			pstmt.setString(3, u.getEmail());
			pstmt.setString(4, u.getPassword());
			pstmt.setInt(5, u.getMobile());
			pstmt.setString(6, u.getRole());
			pstmt.setString(7, u.getAddress());

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

	public List<User> getAllUsers() {
     try {
		stmt=con.createStatement();
		resultSet=stmt.executeQuery(SELECT_QUERY);



			userList = extractUserListFromResultSet(resultSet);


	} catch (Exception e) {

		e.printStackTrace();
	}
	return userList;

	}

	List<User> extractUserListFromResultSet(ResultSet resultSet) {
		try {
			while (resultSet.next()) {
				userList.add(new User(resultSet.getInt("UserId"), resultSet.getString("name"),
						resultSet.getString("email"), resultSet.getString("password"), resultSet.getInt("mobile")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}

	public User getUser(int userId) {

		try {
			pstmt = con.prepareStatement(FETCH_SPECIFIC_QUERY);
			pstmt.setInt(1, userId);
			resultSet = pstmt.executeQuery();

			userList = extractUserListFromResultSet(resultSet);

			if (!userList.isEmpty()) {
				u = userList.get(0);
			}
			else {
				System.out.println("No records found");
				System.exit(0);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;

	}

	public void updateUser(User u) {
		try {
			pstmt = con.prepareStatement(UPDATE_QUERY);
			pstmt.setString(1, u.getEmail());
			pstmt.setInt(2, u.getUid());
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

	public void deleteUser(int userId) {
		try {
			pstmt = con.prepareStatement(DELETE_QUERY);
			pstmt.setInt(1, userId);
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

	
	public  boolean registerUser(User user) {
	      String query = "INSERT INTO user (name,email,password,address) VALUES (?, ?, ?, ?)";
	        try {
	             PreparedStatement pstmt = con.prepareStatement(query) ;
	            pstmt.setString(1, user.getUsername());
	            pstmt.setString(2, user.getEmail());
	            pstmt.setString(3, user.getPassword());
	            pstmt.setString(4, user.getAddress());
	            return pstmt.executeUpdate() > 0;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return false;
	}

	
	public  User validateUser(String username, String password) {
		 String query = "SELECT * FROM user WHERE name = ? AND password = ?";
	        try {
	             PreparedStatement pstmt = con.prepareStatement(query);
	            pstmt.setString(1, username);
	            pstmt.setString(2, password);
	            ResultSet rs = pstmt.executeQuery();
	            if (rs.next()) {
	                User user = new User();
	                user.setUid(rs.getInt("userId"));
	                user.setUsername(rs.getString("name"));
	                user.setEmail(rs.getString("email"));
	                user.setAddress(rs.getString("address"));
	                return user;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
		
	}
	
	



}
