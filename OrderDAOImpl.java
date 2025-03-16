package com.foodclone.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodclone.dao.OrderDAO;
import com.foodclone.Models.*;



public class OrderDAOImpl implements OrderDAO {
	List<Order> orderList = new ArrayList<Order>();
	private static final String SELECT_QUERY = "select * from `order` ";
	private static final String DELETE_QUERY = "delete from `order` where `orderId`=?";
	private static final String FETCH_SPECIFIC_QUERY = "select * from `order` where `orderId`=? ";
	private static final String UPDATE_QUERY = "update `order` set `status`=? where `orderId`=?";
	private static final String INSERT_QUERY = "insert into `order`(order_id,restaurant_id,user_id,totalamount,status,payment_mode) values(?,?,?,?,?,?)";
	private static String url = "jdbc:mysql://localhost:3306/foodtap";
	private static String username = "root";
	private static String password = "root";
	private static Connection con;
	private PreparedStatement pstmt;
	private Order o;
	private String status;
	private Statement stmt;
	private ResultSet resultSet;

	public OrderDAOImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<Order> getAllOrder() {

		try {
			stmt = con.createStatement();
			resultSet = stmt.executeQuery(SELECT_QUERY);

			orderList = extractOrderListFromResultSet(resultSet);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return orderList;
	}

	List<Order> extractOrderListFromResultSet(ResultSet resultSet) {
		try {
			while (resultSet.next()) {
				orderList.add(new Order(resultSet.getInt("order_id"), resultSet.getInt("restaurant_id"),
						resultSet.getInt("user_id"), resultSet.getDouble("totalamount"), resultSet.getString("status"),
						resultSet.getString("paymentMode")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderList;
	}

	@Override
	public Order getOrder(int orderId) {
		try {
			pstmt = con.prepareStatement(FETCH_SPECIFIC_QUERY);
			pstmt.setInt(1, orderId);
			resultSet = pstmt.executeQuery();

			orderList = extractOrderListFromResultSet(resultSet);

			if (!orderList.isEmpty()) {
				o = orderList.get(0);
			} else {
				System.out.println("No records found");
				System.exit(0);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}

	@Override
	public void updateOrder(Order o) {
		try {
			pstmt = con.prepareStatement(UPDATE_QUERY);
			pstmt.setString(1, o.getStatus());
			pstmt.setInt(2, o.getOrderId());
		int	i = pstmt.executeUpdate();
			if (i != 0) {
				System.out.println("Updated successfully");
			} else {
				System.out.println("Not updated");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteOrder(int orderId) {
		try {
			pstmt = con.prepareStatement(DELETE_QUERY);
			pstmt.setInt(1, orderId);
			int i = pstmt.executeUpdate();
			if (i!= 0) {
				System.out.println("deleted successfully");
			} else {
				System.out.println("not deleted successfully");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public int addOrder(Order o) {
		int order_id=0;
		try {

			
			pstmt = con.prepareStatement(INSERT_QUERY,Statement.RETURN_GENERATED_KEYS);
			
			pstmt.setInt(1, o.getOrderId());
			pstmt.setInt(2, o.getRestaurantId());
			pstmt.setInt(3, o.getUid());
			pstmt.setDouble(4, o.getTotalamount());
			pstmt.setString(5, o.getStatus());
			pstmt.setString(6, o.getPaymentMode());

			int i = pstmt.executeUpdate();
			ResultSet res = pstmt.getGeneratedKeys();
			
			while(res.next()) {
				 order_id = res.getInt(1);
			}
			
			if (i != 0) {
				System.out.println("Success");
			} else {
				System.out.println("Failure");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return order_id;
	}

}
