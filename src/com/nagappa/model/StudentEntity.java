package com.nagappa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class StudentEntity {

	@Id
	@Column(name = "adm_no")
	private int addmissionNo;
	
	@Column(name = "roll_no")
	private int rollNo;
	
	@Column(name="fname")
	private String fname;
	
	@Column(name="lname")
	private String lname;
	
	@Column(name="contact_no")
	private String contactNo;
	
	@Column(name="address")
	private String address;
	
	@OneToOne
	private ClassEntity classEntity;
	
	public StudentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentEntity(int addmissionNo, int rollNo, String fname, String lname, String contactNo, String address) {
		super();
		this.addmissionNo = addmissionNo;
		this.rollNo = rollNo;
		this.fname = fname;
		this.lname = lname;
		this.contactNo = contactNo;
		this.address = address;
	}

	public ClassEntity getClassEntity() {
		return classEntity;
	}
	public void setClassEntity(ClassEntity classEntity) {
		this.classEntity = classEntity;
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
	@Override
	public String toString() {
		return "StudentEntity [addmissionNo=" + addmissionNo + ", rollNo=" + rollNo + ", fname=" + fname + ", lname="
				+ lname + ", contactNo=" + contactNo + ", address=" + address + "]";
	}
	
	
	
}
