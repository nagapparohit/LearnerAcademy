package com.nagappa.dao;

import java.util.List;

import com.nagappa.model.SubjectEntity;

public interface SubjectEntityDao {

	public List<SubjectEntity> getAllSubject();
	public List<SubjectEntity> getSubject(String name);
	public List<SubjectEntity> getSubject(int code);
	public List<SubjectEntity> getSubject(SubjectEntity subject);
	public void deleteSubject(SubjectEntity subject);
	public void updateSubject(SubjectEntity subject);
	public void addSubject(SubjectEntity subject);
	public SubjectEntity getSubjectById(int id);
	
}
