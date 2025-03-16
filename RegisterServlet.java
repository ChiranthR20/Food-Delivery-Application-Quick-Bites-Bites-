package com.foodclone.servlets;

import java.io.IOException;

import com.foodclone.Models.User;
import com.foodclone.dao.UserDAO;
import com.foodclone.daoImpl.UserDAOImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet  extends HttpServlet{

	private UserDAO userDao=new UserDAOImpl();
	
 @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 String username = request.getParameter("username");
     String password = request.getParameter("password");
     String confirmPassword = request.getParameter("confirmPassword");
     String email = request.getParameter("email");
     String address = request.getParameter("address");

     if (!password.equals(confirmPassword)) {
         request.setAttribute("error", "Passwords do not match");
         request.getRequestDispatcher("register.jsp").forward(request, response);
         return;
     }

     User user = new User();
     user.setUsername(username);
     user.setPassword(password);
     user.setEmail(email);
     user.setAddress(address);

     if (userDao.registerUser(user)) {
         response.sendRedirect("login.jsp");
     } else {
         request.setAttribute("error", "Registration failed");
         request.getRequestDispatcher("register.jsp").forward(request, response);
     }
}
}
