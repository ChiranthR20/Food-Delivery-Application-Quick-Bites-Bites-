package com.foodclone.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodclone.Models.*;
import com.foodclone.dao.OrderItemDAO;


public class OrderItemDAOImpl implements OrderItemDAO {
	List<OrderItem> orderItemList = new ArrayList<OrderItem>();
	private static final String SELECT_QUERY = "select * from `orderitem` ";
	private static final String DELETE_QUERY = "delete from `orderitem` where `orderId`=?";
	private static final String FETCH_SPECIFIC_QUERY = "select * from `orderitem` where `orderitemId`=? ";
	private static final String UPDATE_QUERY = "update `orderitem` set `quantity`=? where `orderId`=?";
	private static final String INSERT_QUERY = "insert into `orderitem`(order_item_id,order_id,menu_id,quantity,total_price) values(?,?,?,?,?)";
	private static String url = "jdbc:mysql://localhost:3306/foodtap";
	private static String username = "root";
	private static String password = "root";
	private static Connection con;
	private PreparedStatement pstmt;
	private OrderItem o;
	private int status;
	private Statement stmt;
	private ResultSet resultSet;

	public OrderItemDAOImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addOrderItem(OrderItem o) {
		try {

			pstmt = con.prepareStatement(INSERT_QUERY);
			pstmt.setInt(1, o.getOrderitemid());
			pstmt.setInt(2, o.getOrderId());
			pstmt.setInt(3, o.getMenuid());
			pstmt.setInt(4, o.getQuantity());
			pstmt.setDouble(5, o.getTotalamount());

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

	@Override
	public List<OrderItem> getAllOrderItems() {
		try {
			stmt = con.createStatement();
			resultSet = stmt.executeQuery(SELECT_QUERY);

			orderItemList = extractorderItemListFromResultSet(resultSet);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return orderItemList;

	}

	List<OrderItem> extractorderItemListFromResultSet(ResultSet resultSet) {
		try {
			while (resultSet.next()) {
				orderItemList.add(new OrderItem( resultSet.getInt("orderId"),
						resultSet.getInt("menuid"), resultSet.getInt("quantity"), resultSet.getDouble("totalamount")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderItemList;
	}

	@Override
	public OrderItem getOrderItem(int orderitemid) {

		try {
			pstmt = con.prepareStatement(FETCH_SPECIFIC_QUERY);
			pstmt.setInt(1, orderitemid);
			resultSet = pstmt.executeQuery();

			orderItemList = extractorderItemListFromResultSet(resultSet);

			if (!orderItemList.isEmpty()) {
				o = orderItemList.get(0);
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
	public void updateOrderItem(OrderItem o) {
		try {
			pstmt = con.prepareStatement(UPDATE_QUERY);
			pstmt.setInt(1, o.getQuantity());
			pstmt.setInt(2, o.getOrderId());
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

	@Override
	public void deleteOrderItem(int orderId) {
		try {
			pstmt = con.prepareStatement(DELETE_QUERY);
			pstmt.setInt(1, orderId);
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
