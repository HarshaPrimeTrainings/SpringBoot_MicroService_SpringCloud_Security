package com.training.springsecuritywebdemo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDto {
	
	private String username;	
	@JsonIgnore
	private String password;
	private Boolean enabled;
	private String role;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	

}
