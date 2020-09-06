package com.nagappa.dao;

import java.util.List;

import com.nagappa.model.ClassEntity;

public interface ClassEntityDao {

	public List<ClassEntity> getAllClasses();
	public List<ClassEntity> getClassEntity(char section);
	public void addClassEntity(ClassEntity classEntity);
	public void deleteClassEntity(ClassEntity classEntity);
	public void updateClassEntity(ClassEntity classEntity);
	
}
