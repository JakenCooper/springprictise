package com.jaken.sp.entity;

import java.util.Date;

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
	
	private String password;
	
	private Date createTime;
	
	private Date lastLoginTime;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

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
}
