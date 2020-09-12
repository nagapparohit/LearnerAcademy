package com.nagappa.dao;

import java.util.List;

import com.nagappa.model.TeacherEntity;

public interface TeacherEntityDAO {

	List<TeacherEntity> getAllTeachers();
	List<TeacherEntity> getTeachers(String name);
	List<TeacherEntity> getTeachers(TeacherEntity teacher);
	void deleteTeacherEntity(TeacherEntity teacher);
	void saveTeacherEntity(TeacherEntity teacher);
	
}
