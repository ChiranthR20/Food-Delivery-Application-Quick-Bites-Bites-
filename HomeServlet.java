package com.foodclone.servlets;

import java.io.IOException;
import java.util.List;

import com.foodclone.daoImpl.*;
import com.foodclone.Models.Restaurant;
import com.foodclone.dao.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("home servlet called");
		
		RestaurantDAOImpl resimpl = new RestaurantDAOImpl();
		List<Restaurant> allrestaurants = resimpl.getAllRestaurant();
		
	
		req.setAttribute("restaurants", allrestaurants);
		RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
		rd.forward(req, resp);
		
		
	}
	
	
	
	

}
