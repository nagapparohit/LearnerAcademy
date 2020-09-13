package com.nagappa.controllers;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LogoutController {

	@RequestMapping(value = "logout")
	public String logout(HttpServletRequest request,ModelMap map) {
		
		try {
			HttpSession session = request.getSession(false);
			session.setAttribute("username", null);
			session.setAttribute("isAdmin", null);
			map.addAttribute("invalidCredentials","successfully logout");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "login";
	}
}
