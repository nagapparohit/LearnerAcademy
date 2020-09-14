package com.nagappa.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nagappa.dao.ClassEntityDaoImpl;
import com.nagappa.model.ClassEntity;

@Controller
public class AssignStuToClassController {

	@RequestMapping(value = "assignS2C")
	public String AssingS2CPage(ModelMap map) {
		ClassEntityDaoImpl classDao = new ClassEntityDaoImpl();
		List<ClassEntity> listClasses = classDao.getAllClasses();
		classDao.closeClassEntityDaoImplSession();
		
		
		
		return "assignstudentClass";
	}
}
