package com.nagappa.dao;

import java.util.List;

import com.nagappa.model.ClassEntity;
import com.nagappa.model.StudentEntity;

public interface ClassEntityDao {

	public List<ClassEntity> getAllClasses();
	public List<ClassEntity> getClassEntity(char section);
	public List<ClassEntity> getClassEntity(ClassEntity classEntity);
	public void addClassEntity(ClassEntity classEntity);
	public void deleteClassEntity(ClassEntity classEntity);
	public void updateClassEntity(ClassEntity classEntity);
	public void addStudentToClass(StudentEntity studentEntity,ClassEntity classEntity);
	
}
