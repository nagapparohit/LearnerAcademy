package com.nagappa.controllers;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nagappa.comparator.ClassComparator;
import com.nagappa.dao.ClassEntityDaoImpl;
import com.nagappa.dao.UserEntityDAOImpl;
import com.nagappa.model.ClassEntity;
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

	@RequestMapping(value="login", method= {RequestMethod.POST,RequestMethod.GET})
	public String isValidUser(HttpServletRequest request
			,@RequestParam(name="username",value="",required = false)String username
			,@RequestParam(name="password",value="",required = false)String password
			,@RequestParam(name="notAnAdmin",value="",required=false)String notAnAdmin
			,ModelMap map) {
		String view="login";
		try {
			HttpSession session = request.getSession(false);
			if (session != null) {
				String userCheck = (String) session.getAttribute("username");
				//	String userCheck = (String)map.getAttribute("username");
				if (!userCheck.isEmpty() && userCheck != null) {
					view = "dashboard";
					map.addAttribute("notAnAdmin",notAnAdmin);
					map.addAttribute("classesDiv", getDivString());
					return view;
				} 
			}else {
				throw new Exception();
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
					map.addAttribute("classesDiv", getDivString());
					
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

	public String getDivString() {
		//System.out.println("startign div method");
		ClassEntityDaoImpl allClassesDao = new ClassEntityDaoImpl();
		List<ClassEntity> allClasses = allClassesDao.getAllClasses();
		allClassesDao.closeClassEntityDaoImplSession();
		Collections.sort(allClasses,new ClassComparator());
		String classNameforDiv = "classesDiv";
		String divToAddDashboard = "";
		//classesDiv is sting in jsp page
		for(ClassEntity cls :allClasses) {
			String startDiv = "<div class='"+classNameforDiv+"'>";
			int id=cls.getId();
			char sec = cls.getSection();
			int std = cls.getValue();
			String link = "<a href='displayClass?id="+id+"' target='_blank'>"+std+"<sup class='supScript'>"+getSuperscript(std)+"</sup>"+" "+sec+"</a>";
			String endDiv = "</div>";
			divToAddDashboard += startDiv+link+endDiv;
		}
		
		//System.out.println("ending div method");
		return divToAddDashboard;
	}
	
	public String getSuperscript(int x) {
		if(x != 1 && x != 2 && x!= 3) {
			return "th";
		}else if(x==1) {
			return "st";
		}else if(x==2) {
			return "nd";
		}else {
			return "rd";
		}
	}
	
}
