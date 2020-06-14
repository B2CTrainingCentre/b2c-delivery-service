package com.b2c.userservice.model;

public class Agent {
	private int id;
	private String name;
	private String phonenumber;
	private String status;
	
	public Agent(int id, String name, String phonenumber, String status) {
		super();
		this.id = id;
		this.name = name;
		this.phonenumber = phonenumber;
		this.status = status;
	}

	public Agent(String name, String phonenumber) {
		super();
		this.name = name;
		this.phonenumber = phonenumber;
	}

	public Agent() {
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

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
