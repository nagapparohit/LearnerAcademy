package com.nagappa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nagappa.dao.ClassEntityDaoImpl;
import com.nagappa.model.ClassEntity;

@Controller
public class DisplayClassController {

	@RequestMapping("displayClass")
	public String displayClass(@RequestParam("id")String id,ModelMap map) {
		
		ClassEntityDaoImpl classDao = new ClassEntityDaoImpl();
		ClassEntity cls = classDao.getClassbyId(Integer.parseInt(id));
		classDao.closeClassEntityDaoImplSession();
		map.addAttribute("classInfo",cls.toString());
		//classInfo
		return "displayClass";
	}
}
