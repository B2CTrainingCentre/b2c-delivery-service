package com.b2c.userservice.model;

public class Customer {
	private int id;
	private String name;
	private String mobile;
	private String email;
	private String status;
	
	public Customer(int id, String name, String mobile, String email, String status) {
		super();
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.status = status;
	}
	
	public Customer(String name, String mobile, String email) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.email = email;
	}

	public Customer() {
		super();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
