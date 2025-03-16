package com.foodclone.servlets;

import java.io.IOException;
import java.sql.SQLException;

import com.foodclone.Models.Cart;
import com.foodclone.Models.CartItem;
import com.foodclone.Models.Menu;
import com.foodclone.daoImpl.MenuDAOImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/Cart")
public class CartServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session=request.getSession();
		Cart  cart =(Cart)session.getAttribute("cart");
		
		
		
		int newResturantId =Integer.parseInt(request.getParameter("restaurantId"));
		Integer currentResturantId=(Integer)session.getAttribute("restaurantId");//restaurantId
		
		if(cart==null || newResturantId!=currentResturantId) {
			cart=new Cart();
			session.setAttribute("cart", cart);
			session.setAttribute("restaurantId",newResturantId);
		}
		
		
		


		
		String action=request.getParameter("action");
		try {
			if("add".equals(action)) {
				addItemToCart(request, cart);
			}else if("update".equals(action)) {
				updateCartItem(request, cart);
			}else if("remove".equals(action)) {
				removeItemFromCart(request, cart);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("Cart.jsp");
		
	}
	private void  addItemToCart(HttpServletRequest request,Cart cart) throws ClassNotFoundException,SQLException
	{
		

	    int itemId = Integer.parseInt(request.getParameter("itemId"));
	    int quantity = Integer.parseInt(request.getParameter("quantity"));

	    MenuDAOImpl menuimpl = new MenuDAOImpl();
	    Menu menuItem = menuimpl.getMenu(itemId);

	    if (menuItem != null) {
	        CartItem item = new CartItem(
	            menuItem.getMenuId(),
	            menuItem.getItemName(),
	           
	            menuItem.getPrice(),
	            quantity
	        );
	        cart.addCartItem(item);
	    }
	}
	private void updateCartItem(HttpServletRequest request,Cart cart)
	{
		int itemId=Integer.parseInt(request.getParameter("itemId"));
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		
		System.out.println("Updating item: " + itemId + " to quantity: " + quantity);
		cart.updateCartItem(itemId, quantity);
		
	}
	
	private void removeItemFromCart(HttpServletRequest request,Cart cart)
	{
		int itemId=Integer.parseInt(request.getParameter("itemId"));
		cart.removeCartItem(itemId);
		 System.out.println("Removed item ID: " + itemId); 
	}
}