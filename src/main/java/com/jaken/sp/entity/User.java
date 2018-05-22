package com.jaken.sp.entity;

public class User {
	public User(String id, String userName, Integer age) {
		super();
		this.id = id;
		this.userName = userName;
		this.age = age;
	}

	public User() {
		super();
	}

	private String id;
	
	private String userName;
	
	private Integer age;
	
	private String userId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
