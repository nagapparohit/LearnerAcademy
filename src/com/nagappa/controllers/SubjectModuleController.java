package com.nagappa.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.nagappa.dao.SubjectEntityDAOImpl;
import com.nagappa.model.SubjectEntity;

@Controller
public class SubjectModuleController {

	@RequestMapping(value = "subjectModule")
	public String subjectModule(HttpServletRequest request,ModelMap map) {
		int isAdmin=0;
		try {
			HttpSession session = request.getSession(false);
			isAdmin = (int) session.getAttribute("isAdmin");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(isAdmin!=1) {
			map.addAttribute("notAnAdmin","Sorry ! Only Admin can perform operation on it. kindly login with Admin user");
			return "redirect:login";
		}else {
			return "subjectModule";
		}
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
