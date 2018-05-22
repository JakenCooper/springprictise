package com.jaken.sp.entity;

public class ImgResponseModel {

	private Integer code;
	
	private String id;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ImgResponseModel(Integer code, String id) {
		super();
		this.code = code;
		this.id = id;
	}
	
}
