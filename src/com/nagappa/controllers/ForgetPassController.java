package com.nagappa.controllers;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.nagappa.dao.HibernateUtil;
import com.nagappa.model.UserEntity;

@Controller
public class ForgetPassController {

	@RequestMapping(value = "forget_password")
	public String forgetPassword() {
		return "forgetPassword";
	}
	
	@SuppressWarnings({ "rawtypes", "unused", "unchecked" })
	@RequestMapping(value = "newPassword",method = RequestMethod.POST)
	public String saveNewPass(@RequestParam("username")String username,@RequestParam("password")String newPassword,ModelMap map) {
		String view="login";
		
		Transaction txn = null;
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		txn = session.beginTransaction();
		String queryString = "from UserEntity u where u.username = :username";
		Query query=session.createQuery(queryString);
		List<UserEntity> resultDB = query.setParameter("username",username).getResultList();
		txn.commit();
		if(!resultDB.isEmpty()) {
			String updatePassword = "update UserEntity u set u.password = :newPassword where u.username = :username";
			txn = session.beginTransaction();
			Query updateQuery = session.createQuery(updatePassword);
			updateQuery.setParameter("username", username);
			updateQuery.setParameter("newPassword", newPassword);
			int status = updateQuery.executeUpdate();
			txn.commit();
			map.addAttribute("invalidCredentials","Password changed successfully");
		}else {
			view = "forgetPassword";
			map.addAttribute("usernotexist", username + " does not exists.kindly enter valid user");
			session.close();
		}
		return view;
	}
	
}
