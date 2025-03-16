package com.foodclone.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodclone.Models.Menu;
import com.foodclone.dao.MenuDAO;

public class MenuDAOImpl implements MenuDAO {
    private static final String SELECT_QUERY_BY_RESTAURANT = "SELECT * FROM `menu` WHERE `restaurantId`=?";
    private static final String DELETE_QUERY = "DELETE FROM `menu` WHERE `menuId`=?";
    private static final String FETCH_SPECIFIC_QUERY = "SELECT * FROM `menu` WHERE `menuId`=?";
    private static final String UPDATE_QUERY = "UPDATE `menu` SET `ItemName`=? WHERE `menuId`=?";
    private static final String INSERT_QUERY = "INSERT INTO `menu`(menuId, restaurantId, ItemName, Description, Price, IsAvailable, ratings,imagePath) VALUES(?,?,?,?,?,?,?,?)";
    private static String url = "jdbc:mysql://localhost:3306/foodtap";
    private static String username = "root";
    private static String password = "root";
    private static Connection con;
    private PreparedStatement pstmt;
    private Menu m;
    private int status;
    private ResultSet resultSet;

    public MenuDAOImpl() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Menu> getAllMenu(int restaurantId) {
        List<Menu> menuList = new ArrayList<>();
        try {
            pstmt = con.prepareStatement(SELECT_QUERY_BY_RESTAURANT);
            pstmt.setInt(1, restaurantId);
            resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                menuList.add(new Menu(resultSet.getInt("menuId"), resultSet.getInt("restaurantId"),
                        resultSet.getString("ItemName"), resultSet.getString("Description"),
                        resultSet.getDouble("Price"), resultSet.getInt("IsAvailable"),
                        resultSet.getDouble("ratings"),resultSet.getString("imagePath")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return menuList;
    }

    @Override
    public Menu getMenu(int menuId) {
        try {
            pstmt = con.prepareStatement(FETCH_SPECIFIC_QUERY);
            pstmt.setInt(1, menuId);
            resultSet = pstmt.executeQuery();

            if (resultSet.next()) {
                return new Menu(resultSet.getInt("menuId"), resultSet.getInt("restaurantId"),
                        resultSet.getString("ItemName"), resultSet.getString("Description"),
                        resultSet.getDouble("Price"), resultSet.getInt("IsAvailable"),
                        resultSet.getDouble("ratings"),resultSet.getString("imagePath"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateMenu(Menu m) {
        try {
            pstmt = con.prepareStatement(UPDATE_QUERY);
            pstmt.setString(1, m.getItemName());
            pstmt.setInt(2, m.getMenuId());
            status = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteMenu(int menuId) {
        try {
            pstmt = con.prepareStatement(DELETE_QUERY);
            pstmt.setInt(1, menuId);
            status = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addMenu(Menu m) {
        try {
            pstmt = con.prepareStatement(INSERT_QUERY);
            pstmt.setInt(1, m.getMenuId());
            pstmt.setInt(2, m.getRestaurantId());
            pstmt.setString(3, m.getItemName());
            pstmt.setString(4, m.getDescription());
            pstmt.setDouble(5, m.getPrice());
            pstmt.setInt(6, m.getIsAvailable());
            pstmt.setDouble(7, m.getRatings());
            pstmt.setString(8, m.getImage());
            status = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
