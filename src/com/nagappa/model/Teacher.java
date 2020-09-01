package com.nagappa.model;

public class Teacher {

	private String name;
	private String contactNo;
	
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Teacher(String name, String contactNo) {
		super();
		this.name = name;
		this.contactNo = contactNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	@Override
	public String toString() {
		return "Teacher [name=" + name + ", contactNo=" + contactNo + "]";
	}
	
	
}
