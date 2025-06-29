package com.iginite2025.addressbook.entity;

public class Address {
	private int id;
	private String name;
	private String email_id;
	private String phone_number;
	private String address;
	
	public Address(int id, String name, String email_id, String phone_number, String address) {
		super();
		this.id = id;
		this.name = name;
		this.email_id = email_id;
		this.phone_number = phone_number;
		this.address = address;
	}

	public Address() {
		// TODO Auto-generated constructor stub
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getPhoneNumber() {
		return phone_number;
	}
	public void setPhoneNumber(String phone_number) {
		this.phone_number = phone_number;
	}
	
}
