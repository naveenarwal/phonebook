package com.dollop.entity;

public class Contacts {
	
	int id;
    int userId;
	private String name,email,mobile;
	public Contacts() {
		super();
	
	}
	public Contacts(String name, String email,String mobile) {
		super();
		this.name = name;
		this.email = email;
		this.mobile = mobile;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Contacts [id=" + id + ", userId=" + userId + ", name=" + name + ", email=" + email + ", mobile="
				+ mobile + "]";
	}
	

}

	
