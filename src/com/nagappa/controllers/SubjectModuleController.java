package com.nagappa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.nagappa.dao.SubjectEntityDAOImpl;
import com.nagappa.model.SubjectEntity;

@Controller
@SessionAttributes({"username","isAdmin"})
public class SubjectModuleController {

	@RequestMapping(value = "subjectModule")
	public String subjectModule() {
		return "subjectModule";
	}
	
	@RequestMapping(value = "saveSubject",method = RequestMethod.POST)
	public String saveSubject(@RequestParam("name")String name,@RequestParam("code")String code,ModelMap map) {
		String view = "subjectModule";
		int intCode =0;
		try {
			intCode = Integer.parseInt(code);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		SubjectEntity sub = new SubjectEntity();
		sub.setCode(intCode);
		sub.setName(name);
		SubjectEntityDAOImpl subjectDAO = new SubjectEntityDAOImpl();
		if(subjectDAO.getSubject(intCode).isEmpty()) {
			subjectDAO.addSubject(sub);
			map.addAttribute("error","subject succefully saved");
		}else {
			map.addAttribute("error","subject with code"+intCode+" already exists");
		}
		
		subjectDAO.closeSubjectEntityDAOImplSession();
		return view;
	}
}
