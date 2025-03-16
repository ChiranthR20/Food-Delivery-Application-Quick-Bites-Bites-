package com.foodclone.Models;

public class User {
	private int uid;
	private String username;
	private String email;
	private String password;
	private int mobile;

	private String Role;
	private String Address;

	public User(int uid, String username, String email, String password, int mobile, String role, String address) {
		super();
		this.uid = uid;
		this.username = username;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.Role = role;
		this.Address = address;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the uid
	 */
	public int getUid() {
		return uid;
	}

	/**
	 * @param uid the uid to set
	 */
	public void setUid(int uid) {
		this.uid = uid;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the mobile
	 */
	public int getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public User(int uid, String username, String email, String password, int mobile) {
		super();
		this.uid = uid;
		this.username = username;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return uid + " " + username + " " + email + " " + password + " " + mobile;
	}

	public User(String username, String email, String password, int mobile) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
	}

	public User(String email, int uid) {
		this.email = email;
		this.uid = uid;

	}

	public void UserDAOImpl(int uid, String username, String password, int mobile) {
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.mobile = mobile;

	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return Role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.Role = role;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return Address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.Address = address;
	}

}
