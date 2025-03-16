package com.foodclone.Models;

public class Restaurant {
    private int restaurantId;
    private String name;
    private String address;
    private int phonenumber;
    private double rating;
    private String cuisineType;
    private int DeliveryTime;
    private String AdminUserId;
    private int IsActive;
    private String imagePath; // Changed from byte[] image

    public Restaurant(String name, String address, int phonenumber, double rating, String cuisineType, int DeliveryTime,
                      String AdminUserId, int IsActive, String imagePath) {
        this.name = name;
        this.address = address;
        this.phonenumber = phonenumber;
        this.rating = rating;
        this.cuisineType = cuisineType;
        this.DeliveryTime = DeliveryTime;
        this.AdminUserId = AdminUserId;
        this.IsActive = IsActive;
        this.imagePath = imagePath;
    }

    public Restaurant() {
    }

    public Restaurant(int restaurantId, String name, String address, int phonenumber, double rating, String cuisineType,
                      int deliveryTime, String AdminUserId, int isActive, String imagePath) {
        this.restaurantId = restaurantId;
        this.name = name;
        this.address = address;
        this.phonenumber = phonenumber;
        this.rating = rating;
        this.cuisineType = cuisineType;
        this.DeliveryTime = deliveryTime;
        this.IsActive = isActive;
        this.AdminUserId = AdminUserId;
        this.imagePath = imagePath;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public int getDeliveryTime() {
        return DeliveryTime;
    }

    public void setDeliveryTime(int deliveryTime) {
        this.DeliveryTime = deliveryTime;
    }

    public String getAdminUserId() {
        return AdminUserId;
    }

    public void setAdminUserId(String adminUserId) {
        this.AdminUserId = adminUserId;
    }

    public int getIsActive() {
        return IsActive;
    }

    public void setIsActive(int isActive) {
        this.IsActive = isActive;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return restaurantId + " " + name + " " + address + " " + phonenumber + " " + rating + " " + cuisineType + " "
                + DeliveryTime + " " + AdminUserId + " " + IsActive + " " + imagePath;
    }
}
