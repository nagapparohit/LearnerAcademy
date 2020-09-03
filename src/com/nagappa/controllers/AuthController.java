package com.nagappa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

	
	@RequestMapping("/")
	public String showHome() {
		return "login";
	}
	
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String isValidUser(@RequestParam("username")String username,@RequestParam("password")String password,ModelMap map) {
		map.addAttribute("somekey","somevalue");
		map.addAttribute("username",username);
		map.addAttribute("password",password);
		return "dashboard";
	}
	
}
