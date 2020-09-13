package com.nagappa.controllers;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.nagappa.dao.HibernateUtil;
import com.nagappa.dao.UserEntityDAOImpl;
import com.nagappa.model.UserEntity;

@Controller
@SessionAttributes({"username","isAdmin"})
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
	public String isValidUser(@RequestParam("username")String username,@RequestParam("password")String password,ModelMap map) {
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
					map.addAttribute("username",user);
					map.addAttribute("password",pass);
					map.addAttribute("isAdmin",isAdmin);
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
