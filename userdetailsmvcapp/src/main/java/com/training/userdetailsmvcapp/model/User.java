package com.training.userdetailsmvcapp.model;

public class User {

	private int id;
	private String userName;
	private String contact;
	private String address;
	
	public User() {
		
	}
	
	public User(int id, String userName, String contact, String address) {
		super();
		this.id = id;
		this.userName = userName;
		this.contact = contact;
		this.address = address;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
}
