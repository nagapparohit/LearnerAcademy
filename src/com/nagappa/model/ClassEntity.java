package com.nagappa.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "class_entity")
public class ClassEntity {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	private int id;
	
	@Column(name = "value")
	private int value; 
	@Column(name = "section")
	private char section;
	
	@OneToMany(mappedBy = "classEntity")
	private List<StudentEntity> students = new ArrayList<>();
	
	@ManyToMany
	private Map<SubjectEntity,TeacherEntity> subTeacher;
	
	public ClassEntity() {
		super();
	}
	
	public ClassEntity(int value, char section) {
		super();
		this.value = value;
		this.section = section;
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

	public List<StudentEntity> getStudents() {
		return students;
	}

	public void addStudent(StudentEntity student) {
		this.students.add(student);
	}
	
	public void removeStudent(StudentEntity student) {
		this.students.remove(student);
	}
	
	

	public Map<SubjectEntity, TeacherEntity> getSubTeacher() {
		return subTeacher;
	}

	public void setSubTeacher(Map<SubjectEntity, TeacherEntity> subTeacher) {
		this.subTeacher = subTeacher;
	}
	
	
	
	
	
	
	
}
