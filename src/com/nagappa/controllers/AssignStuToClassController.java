package com.nagappa.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nagappa.dao.ClassEntityDaoImpl;
import com.nagappa.dao.StudentEntityDaoImpl;
import com.nagappa.model.ClassEntity;
import com.nagappa.model.StudentEntity;

@Controller
public class AssignStuToClassController {

	@RequestMapping(value = "assignS2C")
	public String AssingS2CPage(ModelMap map) {
		ClassEntityDaoImpl classDao = new ClassEntityDaoImpl();
		List<ClassEntity> listClasses = classDao.getAllClasses();
		classDao.closeClassEntityDaoImplSession();
		
		StudentEntityDaoImpl studentDao = new StudentEntityDaoImpl();
		List<StudentEntity> listStudent = studentDao.getAllStudent();
		studentDao.closeSession();
		
		String selectStudentOpenTag = "<select name='student' id='student'>";
		String selectStudentCloseTag ="</select>";
		String studentsOptionTag="";
		for(StudentEntity student : listStudent) {
			int admNo = student.getAddmissionNo();
			String fname = student.getFname();
			String lname = student.getLname();
			studentsOptionTag += "<option value='"+admNo+"'> Admission No : "+admNo+" --> "+fname+" "+lname+"</option>";
		}
		String finalSelectStudentString = selectStudentOpenTag+studentsOptionTag+selectStudentCloseTag;
		String selectClassOpenTag = "<select name='standard' id='standard'>";
		String selectClassCloseTag = "</select>";
		String classOptionTag="";
		for(ClassEntity std : listClasses) {
			char sec = std.getSection();
			int value = std.getId();
			String key=String.valueOf(value)+sec;
			
			classOptionTag += "<option value='"+key+"'>"+value+" "+sec+"</option>";
		}
		String finalSelectClassString = selectClassOpenTag+classOptionTag+selectClassCloseTag;
		map.addAttribute("selectStudent", finalSelectStudentString);
		map.addAttribute("selectClass", finalSelectClassString);
		return "assignstudentClass";
	}
}
