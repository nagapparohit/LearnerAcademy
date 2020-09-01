package com.nagappa.model;

public class Student {

	private int addmissionNo;
	private int rollNo;
	private String fname;
	private String lname;
	private String contactNo;
	private String address;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int addmissionNo, int rollNo, String fname, String lname, String contactNo, String address) {
		super();
		this.addmissionNo = addmissionNo;
		this.rollNo = rollNo;
		this.fname = fname;
		this.lname = lname;
		this.contactNo = contactNo;
		this.address = address;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAddmissionNo() {
		return addmissionNo;
	}
	public void setAddmissionNo(int addmissionNo) {
		this.addmissionNo = addmissionNo;
	}
	
	
}
