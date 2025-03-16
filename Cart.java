 package com.foodclone.Models;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.DoubleStream;

import jakarta.servlet.http.HttpServletRequest;

public class Cart {
	

	
	
	 private static Map<Integer, CartItem> cart;

	    public Cart() {
	        this.cart = new HashMap<Integer,CartItem>();
	    }

	    public  void addCartItem(CartItem ci) {
	    	int id=ci.getId();
	        if (cart.containsKey(id)) {
	            CartItem existingItem = cart.get(id);
	            existingItem.setQuantity(existingItem.getQuantity() + ci.getQuantity());
	        } else {
	            cart.put(id, ci);
	        }
	    }

	    public  void updateCartItem(int itemId, int quantity) {
	        if (cart.containsKey(itemId)) {
	            if (quantity > 0) {
	                cart.get(itemId).setQuantity(quantity);
	            } else {
	                cart.remove(itemId);//if quantity is <0 then remove the item by using item id
	            }
	        }
	    }

	    public  void removeCartItem(int itemId) {
	        cart.remove(itemId);
	    }
	    
	    public Map<Integer,CartItem> getItems(){
	    	return cart;
	    }
	    public double getTotalPrice() {
	    	return cart.values().stream().mapToDouble(cart-> cart.getPrice()*cart.getQuantity()).sum();
	    }

	    public void clear() {
	    	cart.clear();
	    }
	  
		

}
