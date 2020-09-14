package com.nagappa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AssignStuToClassController {

	@RequestMapping(value = "assignS2C")
	public String AssingS2UPage() {
		return "assignstudentClass";
	}
}
