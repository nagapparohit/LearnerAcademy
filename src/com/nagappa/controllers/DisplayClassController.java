package com.nagappa.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nagappa.dao.ClassEntityDaoImpl;
import com.nagappa.model.ClassEntity;
import com.nagappa.model.StudentEntity;

@Controller
public class DisplayClassController {

	@RequestMapping("displayClass")
	public String displayClass(@RequestParam("id")String id,ModelMap map) {

		ClassEntityDaoImpl classDao = new ClassEntityDaoImpl();
		ClassEntity cls = classDao.getClassbyId(Integer.parseInt(id));
		classDao.closeClassEntityDaoImplSession();
		
		map.addAttribute("studentTable", getStudentTable(cls));
		map.addAttribute("classInfo",cls.toString());
		//classInfo
		return "displayClass";
	}
	
	public String getStudentTable(ClassEntity cls) {
		String studentStartTable ="<table class='studentTable'>";
		String studentTableHeader = "<tr><th>Roll No</th>"
				+ "<th>Admission No</th>"
				+ "<th>first Name</th>"
				+ "<th>Last Name</th>"
				+ "<th>Address No</th>"
				+ "<th>contact No</th></tr>";
		String studentEndTable = "</table>";
		String studentTableRows ="";
		List<StudentEntity> students = cls.getStudents();
		for(StudentEntity stu : students) {
			int admNo = stu.getAddmissionNo();
			int rollNo = stu.getRollNo();
			String address = stu.getAddress();
			String fname = stu.getFname();
			String lname = stu.getLname();
			String contactNo = stu.getContactNo();
			String starttr = "<tr>";
			String f1 = "<td>"+rollNo+"</td>";
			String f2 = "<td>"+admNo+"</td>";
			String f3 = "<td>"+fname+"</td>";
			String f4 = "<td>"+lname+"</td>";
			String f5 = "<td>"+address+"</td>";
			String f6 = "<td>"+contactNo+"</td>";
			String endtr = "</tr>";
			String totalRow = starttr+f1+f2+f3+f4+f5+f6+endtr;
			studentTableRows += totalRow;		
		}
		String studentTable = studentStartTable+studentTableHeader+studentTableRows+studentEndTable;
		return studentTable;
	}
	
	
}