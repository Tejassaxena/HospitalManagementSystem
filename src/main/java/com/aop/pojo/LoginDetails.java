package com.aop.pojo;

import org.springframework.stereotype.Component;

@Component
public class LoginDetails {
	private String username;
	private String password;

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

	public LoginDetails() {
		// TODO Auto-generated constructor stub
	}

	public LoginDetails(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginDetails [username=" + username + ", password=" + password + "]";
	}

}
