package com.nagappa.model;

import java.util.Collection;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "class_entity")
public class ClassEntity {
	
	@Id
	private int id;
	
	@Column(name = "value")
	private int value; 
	@Column(name = "section")
	private char section;
	
	@ManyToMany
	private Collection<TeacherEntity> teachers;
	
	@ManyToMany
	private Collection<SubjectEntity> subjects;
	
	@OneToMany
	private Collection<StudentEntity> students;
	
	@OneToMany
	private Collection<Map<SubjectEntity,TeacherEntity>> subTeacher;
	
	public ClassEntity() {
		super();
	}
	
	public ClassEntity(int value, char section,int id) {
		super();
		this.value = value;
		this.section = section;
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	
	
	
	
	
	
}
