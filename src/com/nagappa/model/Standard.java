package com.nagappa.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "standard")
public class Standard {
	
	@Id
	private int id;
	
	@Column(name = "value")
	private int value; 
	@Column(name = "section")
	private char section;
	
	@OneToMany
	Collection<Student> students = new ArrayList<>();
	
	public Standard() {
		super();
	}
	public Standard(int value, char section,Collection<Student> student,int id) {
		super();
		this.value = value;
		this.section = section;
		this.students = student;
		this.id = id;
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Collection<Student> getStudents() {
		return students;
	}
	public void setStudents(Collection<Student> students) {
		this.students = students;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public char getSection() {
		return section;
	}
	public void setSection(char section) {
		this.section = section;
	}
	@Override
	public String toString() {
		return "Standard [value=" + value + ", section=" + section + "]";
	}
	
	
	
}
