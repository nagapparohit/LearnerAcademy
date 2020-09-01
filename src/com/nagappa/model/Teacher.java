package com.nagappa.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "teacher")
public class Teacher {

	@Id
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "contact_no")
	private String contactNo;
	
	@OneToMany
	private Collection<Subject> subjects = new ArrayList<>();
	
	@OneToOne
	private Standard std;
	
	
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Teacher(String name, String contactNo,Collection<Subject> subjects,int id,Standard std) {
		super();
		this.name = name;
		this.contactNo = contactNo;
		this.subjects = subjects;
		this.id = id;
		this.std = std;
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Standard getStd() {
		return std;
	}
	public void setStd(Standard std) {
		this.std = std;
	}
	public Collection<Subject> getSubjects() {
		return subjects;
	}
	public void setSubjects(Collection<Subject> subjects) {
		this.subjects = subjects;
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
