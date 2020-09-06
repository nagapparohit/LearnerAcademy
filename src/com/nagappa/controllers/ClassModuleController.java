package com.nagappa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nagappa.dao.ClassEntityDaoImpl;
import com.nagappa.model.ClassEntity;

@Controller
public class ClassModuleController {

	@RequestMapping(value = "classModule")
	public String addClass() {
		return "classModule";
	}
	
	@RequestMapping(value = "saveClass")
	public String saveClass(@RequestParam("section")String section,@RequestParam("value")String value,ModelMap map) {
		int val = Integer.parseInt(value);
		char c = section.charAt(0);
		ClassEntity classEntity = new ClassEntity();
		classEntity.setSection(c);
		classEntity.setValue(val);
		
		ClassEntityDaoImpl classDao = new ClassEntityDaoImpl();
		classDao.addClassEntity(classEntity);
		classDao.closeClassEntityDaoImplSession();
		map.addAttribute("error","class sucseffully saved");
		return "classModule";
	}
}
