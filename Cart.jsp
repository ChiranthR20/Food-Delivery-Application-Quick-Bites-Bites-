<%@page import="java.awt.event.ItemEvent"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, com.foodclone.Models.CartItem, com.foodclone.Models.Cart" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Cart Page</title>
  <style>
    body {
      font-family: 'Arial', sans-serif;
      background-color: #f8f8f8;
      margin: 0;
      padding: 0;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }

    .cart-container {
      background-color: #fff;
      border-radius: 8px;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
      width: 400px;
      padding: 20px;
    }

    .cart-header {
      font-size: 24px;
      font-weight: bold;
      margin-bottom: 20px;
      color: #333;
    }

    .cart-item {
      display: flex;
      justify-content: space-between;
      align-items: center;
      padding: 10px 0;
      border-bottom: 1px solid #eee;
    }

    .item-name {
      font-size: 16px;
      color: #333;
    }

    .item-price {
      font-size: 16px;
      color: #666;
      margin-right: 15px; /* Added spacing between price and remove button */
    }

    .item-controls {
      display: flex;
      align-items: center;
    }

    .quantity-btn {
      background-color: #f0f0f0;
      border: none;
      padding: 5px 10px;
      border-radius: 4px;
      cursor: pointer;
      font-size: 16px;
      margin: 0 5px;
    }

    .quantity-btn:hover {
      background-color: #ddd;
    }

    .quantity {
      font-size: 16px;
      margin: 0 10px;
    }

    .remove-btn {
      background-color: #ff4d4d;
      border: none;
      color: white;
      padding: 5px 10px;
      border-radius: 4px;
      cursor: pointer;
      font-size: 14px;
    }

    .remove-btn:hover {
      background-color: #ff1a1a;
    }

    .price-details {
      margin-top: 20px;
      padding-top: 10px;
      border-top: 1px solid #eee;
    }

    .price-row {
      display: flex;
      justify-content: space-between;
      margin: 10px 0;
      font-size: 16px;
      color: #333;
    }

    .total-price {
      font-weight: bold;
      font-size: 18px;
    }

    .add-more-btn {
      background-color: #f0f0f0;
      border: none;
      color: #333;
      padding: 10px 20px;
      border-radius: 4px;
      cursor: pointer;
      font-size: 16px;
      margin-top: 20px;
      width: 100%;
    }

    .add-more-btn:hover {
      background-color: #ddd;
    }

    .checkout-btn {
      background-color: #4CAF50;
      border: none;
      color: white;
      padding: 15px 20px;
      border-radius: 4px;
      cursor: pointer;
      font-size: 16px;
      margin-top: 10px; /* Reduced margin to bring closer to Add More Items button */
      width: 100%;
    }

    .checkout-btn:hover {
      background-color: #45a049;
    }
  </style>
</head>
<body>
  <div class="cart-container">
    <div class="cart-header">Your Cart</div>
    <%
    Cart cart=(Cart)session.getAttribute("cart");
    Integer restaurantId=(Integer)session.getAttribute("restaurantId");
    
    if(cart!=null && !cart.getItems().isEmpty()){
    	for(CartItem item:cart.getItems().values()){
    		
    	
    
    
    
    %>

    <!-- Cart Item 1 -->
    <div class="cart-item">
      <div class="item-name"><%=item.getName() %></div>
      <div class="item-controls">
      <form action="Cart" method="post" style="display: inline;">
      <input type="hidden" name="restaurantId" value="<%= session.getAttribute("restaurantId") %>">
      <input type="hidden" name="itemId" value="<%= item.getId() %>">
      <input type="hidden" name="action" value="update">
      <input type="hidden" name="quantity" value="<%= item.getQuantity() + 1 %>">
        <button class="quantity-btn plus" value="submit">+</button>
      </form>
      
        <span class="quantity"><%=item.getQuantity() %></span>
        
         <form action="Cart" method="post" style="display: inline;">
          <input type="hidden" name="restaurantId" value="<%= session.getAttribute("restaurantId") %>">
      <input type="hidden" name="itemId" value="<%= item.getId() %>">
      <input type="hidden" name="action" value="update">
      <input type="hidden" name="quantity" value="<%= item.getQuantity() - 1 %>">
        <button class="quantity-btn minus"<% if (item.getQuantity() == 1) { %> disabled <% } %> value="submit">-</button>
        </form>
        <span class="item-price"><%=item.getPrice() %></span>
        
        <form action="Cart" method="post">
         <input type="hidden" name="restaurantId" value="<%= session.getAttribute("restaurantId") %>">
         <input type="hidden" name="itemId" value="<%= item.getId() %>">
         <input type="hidden" name="action" value="remove">
        <button class="remove-btn">Remove</button>
        </form>
      </div>
    </div>
<%

}
%>
   

    <!-- Price Details -->
    <div class="price-details">
      <div class="price-row total-price">
        <span>Total</span>
        <span>₹<%=cart.getTotalPrice()%></span>
      </div>
    </div>
    
   

    <!-- Add More Items Button -->
    <button class="add-more-btn">
    
    <a href="menu?restaurantId=<%=session.getAttribute("restaurantId")%>" style="text-decoration: none;">Add More Items</a></button>
<%
}
%>
<%
if(session.getAttribute("cart")!=null){
	

%>
    
   <form action="CheckOut.jsp" method="post">
   <input type="submit" value="Procced to Checkout" class="checkout-btn">
   </form>
   <%
}
   %>
    
  </div>
</body>
</html>