<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.foodclone.Models.Menu" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="menustyle.css">
  
  <title>Restaurant Menu</title>
</head>

<body>
<nav class="top-nav">
    <a href="home" class="nav-button">Home</a>
    <a href="Cart.jsp" class="nav-button">Cart</a>
  </nav>
  <div class="container">
  
    <h1 class="menu-heading">Menu</h1>
    <div class="menu-grid">
      <%
      List<Menu> allmenus = (List<Menu>) request.getAttribute("menus");
      for (Menu m : allmenus) {
      %>
        <div class="menu-card">
          <img class="menu-image" src="<%= request.getContextPath() + "/" + m.getImage() %>" alt="<%= m.getItemName() %>">
          <div class="menu-info">
            <div class="menu-name"><%= m.getItemName() %></div>
            <div class="menu-rating">⭐ <%= m.getRatings() %></div>
            <div class="menu-price">₹<%= m.getPrice() %></div>
            <div class="menu-availability">In Stock</div>
            
            
            <form action="Cart" method="post">
          <input type="hidden" name="itemId" value="<%=m.getMenuId()%>">
            <input type="hidden" name="quantity" value="1">
            <input type="hidden" name="restaurantId" value="<%=m.getRestaurantId()%>">
            <input type="hidden" name="action" value="add">
            
            <input type="submit" class="add-to-cart" value="Add to Cart">
            
            </form>
          </div>
        </div>
      <% } %>
    </div>
  </div>
</body>

</html>
