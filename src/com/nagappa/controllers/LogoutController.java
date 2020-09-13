package com.nagappa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"username","isAdmin"})
public class LogoutController {

	@SuppressWarnings("unused")
	@RequestMapping(value = "logout")
	public String logout(ModelMap map) {
		
		try {
			String username=(String) map.getAttribute("username");
			map.addAttribute("username", "");
			map.addAttribute("invalidCredentials","successfully logout");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "login";
	}
}
