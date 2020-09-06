package com.nagappa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentModuleController {

	@RequestMapping(value = "studentModule")
	public String studentModule() {
		return "studentModule";
	}
}
