package com.jaken.sp.entity.security;

import java.io.Serializable;

public class Principal implements Serializable{
	
	private static final long serialVersionUID = -787440459475142862L;
	
	private String userName;
	
	private String password;
	
	public Principal(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
