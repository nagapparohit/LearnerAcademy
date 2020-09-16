package com.nagappa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nagappa.dao.ClassEntityDaoImpl;
import com.nagappa.model.ClassEntity;
import com.nagappa.model.StudentEntity;

@Controller
public class SaveStudentToClassController {

	@RequestMapping("saveS2C")
	public String saveS2C(@RequestParam("student")String student,@RequestParam("standard")String standard,ModelMap map) {
		
		int admNo = Integer.parseInt(student);
		String std = standard;
		int len = std.length();
		char sec = std.charAt(len-1);
		int classValue = Integer.parseInt(standard.substring(0, len-1));
		StudentEntity studentEntity = new StudentEntity();
		studentEntity.setAddmissionNo(admNo);
		ClassEntity classEntity = new ClassEntity();
		classEntity.setSection(sec);
		classEntity.setValue(classValue);
		
		ClassEntityDaoImpl classDao = new ClassEntityDaoImpl();
		classDao.addStudentToClass(studentEntity, classEntity);
		classDao.closeClassEntityDaoImplSession();
		return "redirect:assignS2C";
	}
}
