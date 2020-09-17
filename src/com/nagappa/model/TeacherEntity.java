package com.nagappa.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "teacher")
public class TeacherEntity {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "contact_no")
	private String contactNo;
	
	//@ManyToMany
	//@JoinTable(name="teacher_classentity",
	//		   joinColumns=@JoinColumn(name="teacher_id"),
	//		   inverseJoinColumns=@JoinColumn(name="classentity_id"))
	//private List<ClassEntity> classEntity = new ArrayList<>();
	
	
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
