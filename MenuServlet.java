package com.foodclone.servlets;

import java.io.IOException;
import java.util.List;

import com.foodclone.Models.Menu;
import com.foodclone.daoImpl.MenuDAOImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/menu")
public class MenuServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	int id = Integer.parseInt(req.getParameter("restaurantId"));
	
	MenuDAOImpl menuDao = new MenuDAOImpl();
	List<Menu> menu = menuDao.getAllMenu(id);
	
	req.setAttribute("menus", menu);
	
	RequestDispatcher rd = req.getRequestDispatcher("menu.jsp");
	rd.forward(req, resp);

	}

}
