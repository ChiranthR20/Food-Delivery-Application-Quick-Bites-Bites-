package com.foodclone.servlets;

import java.io.IOException;

import com.foodclone.Models.Cart;
import com.foodclone.Models.CartItem;
import com.foodclone.Models.Order;
import com.foodclone.Models.OrderItem;
import com.foodclone.Models.User;
import com.foodclone.dao.OrderDAO;
import com.foodclone.daoImpl.OrderDAOImpl;
import com.foodclone.daoImpl.OrderItemDAOImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/Checkout")
public class CheckoutServlet extends HttpServlet {
	
	private OrderDAO orderDAO;
	private OrderItemDAOImpl orderItemDAOImpl;
	@Override
	public void init() {
		try {
			
			orderDAO=new OrderDAOImpl();
			orderItemDAOImpl = new OrderItemDAOImpl();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to initialize OrderDAO",e);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Cart cart =(Cart) session.getAttribute("cart");
		User user=(User) session.getAttribute("user");
		
		if(cart!=null && user!=null && !cart.getItems().isEmpty()) {
			String paymentMethod=request.getParameter("payment-mode");
			String address=request.getParameter("city");
			
			
			Order order=new Order();
			order.setUid(user.getUid());
			order.setRestaurantId((int)session.getAttribute("restaurantId"));
			order.setPaymentMode(paymentMethod);
			order.setStatus("PENDING");
			
			double totalAmount=0;
			for(CartItem item:cart.getItems().values()) {
				totalAmount+=item.getPrice()*item.getQuantity();
				
			}
			
			
			order.setTotalamount(totalAmount);
			int orderId = orderDAO.addOrder(order);
			
			
			for(CartItem item:cart.getItems().values()) {
				//String name = item.getName();
				int itemId = item.getId();
				double price = item.getPrice();
				int quantity = item.getQuantity();
			double	totalPrice=price*quantity;
			
			OrderItem orderItem = new OrderItem(orderId, itemId, quantity, totalAmount);
						
				orderItemDAOImpl.addOrderItem(orderItem);
			}
			session.removeAttribute("cart");//clear cart
			
			session.setAttribute("order", order);
			response.sendRedirect("order_confirmation.jsp");
			
			
		}else {
			response.sendRedirect("Cart.jsp");
		}
	}
	
	

}
