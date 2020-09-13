package com.nagappa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;


@Controller
public class LogoutController {

	@RequestMapping(value = "logout")
	public String logout(@SessionAttribute("username")String username,ModelMap map) {
		
		try {
			//String user=(String) map.getAttribute("username");
			map.addAttribute("username", null);
			map.addAttribute("invalidCredentials","successfully logout");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "login";
	}
}
