package com.nagappa.controllers;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.nagappa.dao.HibernateUtil;
import com.nagappa.model.UserEntity;

@Controller
public class SignupController {

	
	@RequestMapping(value = "signup")
	public String signupForm() {
		return "signup";
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "register")
	public String register(@RequestParam("username")String username,@RequestParam("password")String password,ModelMap map) {
		
		String view="signup";
		if(username.isEmpty() || password.isEmpty()) {
			map.addAttribute("alreadyExists", "Username and password are mandatory fields");
			return view;
		}
		Transaction txn = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		txn = session.beginTransaction();
		
		String queryString = "from UserEntity u where u.username = :username";
		Query query=session.createQuery(queryString);
		List<UserEntity> resultDB = query.setParameter("username",username).getResultList();
		txn.commit();
		
		if(resultDB.isEmpty()) {
			txn = session.beginTransaction();
			UserEntity user = new UserEntity();
			user.setUsername(username);
			user.setPassword(password);
			user.setIsActive(0);
			user.setIsAdmin(0);
			session.save(user);
			txn.commit();
			session.close();
			view = "login";
			map.addAttribute("invalidCredentials","User succesfully registered.");
		
			
		}else {
			map.addAttribute("alreadyExists", username+" user alreday exists . choose different username.");
			session.close();
		}
		
		return view;
	}
	
}
