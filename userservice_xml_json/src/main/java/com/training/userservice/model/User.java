package com.training.userservice.model;


public class User {

	private int uid;
	private String username;
	private String address;
	private String email;
	private String contact;
	
	public User() {
		
	}

	public User(int uid, String username, String address, String email, String contact) {
		super();
		this.uid = uid;
		this.username = username;
		this.address = address;
		this.email = email;
		this.contact = contact;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
	
	
}
