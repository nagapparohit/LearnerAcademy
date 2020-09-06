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
import com.nagappa.model.StudentEntity;
import com.nagappa.model.UserEntity;

@Controller
public class StudentModuleController {

	@RequestMapping(value = "studentModule")
	public String studentModule() {
		return "studentModule";
	}
	
	@RequestMapping(value ="addStudent")
	public String addStudent() {
		return "addStudent";
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "saveStudent")
	public String saveStudent(@RequestParam("admNo")String admNo,@RequestParam("address")String address,
			@RequestParam("contactNo")String contactNo,@RequestParam("fname")String fname,@RequestParam("lname")String lname,
			@RequestParam("rollNo")String rollNo,ModelMap map) {
		String view="addStudent";
		if(admNo.isEmpty() || address.isEmpty() || contactNo.isEmpty()|| fname.isEmpty()| lname.isEmpty()||rollNo.isEmpty()) {
			map.addAttribute("error","all fields are manadtory.");
			return view;
		}
		int admissionNo = Integer.parseInt(admNo);
		int rno = Integer.parseInt(rollNo);
		Transaction txn = null;
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		txn = session.beginTransaction();

		String queryString = "from StudentEntity s where s.addmissionNo = :admNo";
		Query query=session.createQuery(queryString);
		List<UserEntity> resultDB = query.setParameter("admNo",admissionNo).getResultList();
		txn.commit();
		
		if(resultDB.isEmpty()) {
			txn = session.beginTransaction();
			StudentEntity student = new StudentEntity();
			student.setAddmissionNo(admissionNo);
			student.setAddress(address);
			student.setContactNo(contactNo);
			student.setFname(fname);
			student.setLname(lname);
			student.setRollNo(rno);
			session.save(student);
			txn.commit();
			session.close();
			view = "studentModule";
			map.addAttribute("error","Student saved successfully.");
		}else {
			map.addAttribute("error","student with "+admNo+" already exists");
		}
		return view;
		
	}
}
