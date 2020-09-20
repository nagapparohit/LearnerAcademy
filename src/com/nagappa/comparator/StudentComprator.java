package com.nagappa.comparator;

import java.util.Comparator;

import com.nagappa.model.StudentEntity;

public class StudentComprator implements Comparator<StudentEntity>{

	@Override
	public int compare(StudentEntity o1, StudentEntity o2) {
		return o1.getRollNo() - o2.getRollNo();
	}

	
}
