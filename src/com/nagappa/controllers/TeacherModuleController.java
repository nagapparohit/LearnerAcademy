package com.nagappa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.nagappa.dao.TeacherEntityDAOImpl;
import com.nagappa.model.TeacherEntity;

@Controller
public class TeacherModuleController {

	@RequestMapping(value = "teacherModule")
	public String teacherModule() {
		return "teacherModule";
		
	}
	
	@RequestMapping(value = "saveTeacher",method = RequestMethod.POST)
	public String saveTeacher(@RequestParam("name")String name,@RequestParam("contactNo")String contactNo,ModelMap map) {
		String view ="teacherModule";
		TeacherEntity teacher = new TeacherEntity();
		teacher.setContactNo(contactNo);
		teacher.setName(name);
		TeacherEntityDAOImpl teacherDao = new TeacherEntityDAOImpl();
		if(teacherDao.getTeachers(teacher).isEmpty()) {
			teacherDao.saveTeacherEntity(teacher);
			map.addAttribute("error","teacher successfully saved.");
		}else {
			map.addAttribute("error","teacher already exists");
		}
		teacherDao.closeTeacherEntityDAOImplSession();
		return view;
	}
}
