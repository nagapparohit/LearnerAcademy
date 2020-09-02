package com.nagappa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "teacher")
public class TeacherEntity {

	@Id
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "contact_no")
	private String contactNo;
	
	
	public TeacherEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TeacherEntity(String name, String contactNo,int id) {
		super();
		this.name = name;
		this.contactNo = contactNo;
		this.id = id;
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
