<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List,com.foodclone.Models.Restaurant" %>
    <%@ page import="java.util.Base64" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>QuickBite - Food Delivery</title>
  <link rel="stylesheet" href="restaurantstyle.css">
  
  <!-- Font Awesome for Icons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>
  <!-- Top Navigation Bar -->
  <div class="navbar">
    <div class="logo">QuickBite</div>
    <div class="icons">
      <i class="fas fa-search" title="Search"></i>
      <a href="Cart.jsp">
      <i class="fas fa-shopping-cart" title="Cart"></i>
      </a>
      <i class="fas fa-user" title="Guest" >
      </i>
      <a href="login.jsp">
      <i class="fas fa-sign-out-alt" title="Logout"></i>
      </a>
    </div>
  </div>

  <!-- Header -->
  <div class="header">
    <h1>Welcome to QuickBite</h1>
    <p>Order your favorite food from the best restaurants in town!</p>
  </div>

  <!-- Search Bar -->
  <div class="search-bar">
    <input type="text" placeholder="Search for restaurants or cuisines...">
  </div>

<div class="restaurant-cards">
  <%
  List<Restaurant> allrestaurants = (List<Restaurant>) request.getAttribute("restaurants");
  for (Restaurant r : allrestaurants) {
     
  %>
    <!-- Restaurant Card -->
    <a href="menu?restaurantId=<%= r.getRestaurantId()%>">
    <div class="card">
     <img src="<%= request.getContextPath() + "/" + r.getImagePath() %>" alt="<%= r.getName() %>">
      <h3><%= r.getName() %></h3>
      <p>Cuisine: <%= r.getCuisineType() %></p>
      <p class="rating">⭐ <%= r.getRating() %></p>
      <p class="delivery-time">🕒 <%= r.getDeliveryTime() %> mins</p>
    </div>
    </a>
  <% } %>
</div>

    <!-- Restaurant Card 2 -->
   
    <!-- Restaurant Card 3 -->
   
  </div>
</body>
</html> 