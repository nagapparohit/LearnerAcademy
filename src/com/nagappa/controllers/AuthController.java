package com.nagappa.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.nagappa.dao.UserEntityDAOImpl;
import com.nagappa.model.UserEntity;

@Controller
public class AuthController {


	@RequestMapping("/")
	public String showHome(ModelMap map) {
		String view="login";
		try {
			String userCheck = (String)map.getAttribute("username");
			if(!userCheck.isEmpty() && userCheck!=null) {
				view = "dashboard";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return view;
	}

	@RequestMapping(value="login", method=RequestMethod.POST)
	public String isValidUser(HttpServletRequest request,@RequestParam("username")String username,@RequestParam("password")String password,ModelMap map) {
		String view="login";
		try {
			String userCheck = (String)map.getAttribute("username");
			if(!userCheck.isEmpty() && userCheck!=null) {
				view = "dashboard";
				return view;
			}
		} catch (Exception e1) {
			if(username.isEmpty() || password.isEmpty()) {
				map.addAttribute("invalidCredentials","both username and password fields are manadtory");
				return view;
			}
			UserEntityDAOImpl  userDao = new UserEntityDAOImpl();
			List<UserEntity> resultDB = userDao.getUser(username);
			userDao.closeSession();
			UserEntity result = null;
			if(!resultDB.isEmpty()) {
				for(UserEntity u : resultDB) {
					result = u;
				}
				String user = result.getUsername();
				String pass = result.getPassword();
				int isAdmin = result.getIsAdmin();
				if(password.equals(pass)) {
					view="dashboard";
					HttpSession session = request.getSession();
					session.setAttribute("username",user );
					session.setAttribute("isAdmin", isAdmin);
					map.addAttribute("password",pass);
				}else {
					map.addAttribute("invalidCredentials","you have entered invalid credentials");
				}
			}else {
				map.addAttribute("invalidCredentials","Username doesnot exists");
			}
			e1.printStackTrace();
		}
		return view;
	}

}
