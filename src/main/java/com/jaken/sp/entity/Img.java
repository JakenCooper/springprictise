package com.jaken.sp.entity;

public class Img {

	private String id;

	private String userId;

	private String path;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Img() {
		super();
	}

	public Img(String id, String userId, String path) {
		super();
		this.id = id;
		this.userId = userId;
		this.path = path;
	}

}
