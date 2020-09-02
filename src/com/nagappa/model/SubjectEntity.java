package com.nagappa.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "subject")
public class SubjectEntity {

	@Id
	private int id;
	
	@Column(name = "code")
	private int code;
	@Column(name="name")
	private String name;
	
	@ManyToMany
	private Collection<TeacherEntity> teacher;
	
	public SubjectEntity() {
		super();
		
	}
	public SubjectEntity(int code, String name,int id) {
		super();
		this.code = code;
		this.name = name;
		this.id= id;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Subject [code=" + code + ", name=" + name + "]";
	}
	
	
}
