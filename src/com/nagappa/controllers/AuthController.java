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

import com.nagappa.dao.HibernateUtil;
import com.nagappa.model.UserEntity;

@Controller
public class AuthController {


	@RequestMapping("/")
	public String showHome() {
		return "login";
	}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String isValidUser(@RequestParam("username")String username,@RequestParam("password")String password,ModelMap map) {
		String view="login";
		
		if(username.isEmpty() || password.isEmpty()) {
			map.addAttribute("invalidCredentials","both username and password fields are manadtory");
			return view;
		}
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();

		String queryString = "from UserEntity u where u.username = :username";
		Query query=session.createQuery(queryString);
		List<UserEntity> resultDB = null; 
		try {
				resultDB = query.setParameter("username",username).getResultList();
		} catch (Exception e) {
				System.out.println("No record found in DB.");
		}
		txn.commit();
		session.close();
		UserEntity result = null;
		if(!resultDB.isEmpty()) {
			for(UserEntity u : resultDB) {
				result = u;
			}
			String user = result.getUsername();
			String pass = result.getPassword();
			if(password.equals(pass)) {
				view="dashboard";
				map.addAttribute("username",user);
				map.addAttribute("password",pass);
			}else {
				map.addAttribute("invalidCredentials","you have entered invalid credentials");
			}
		}else {
			map.addAttribute("invalidCredentials","Username doesnot exists");
		}
		return view;
	}

}
