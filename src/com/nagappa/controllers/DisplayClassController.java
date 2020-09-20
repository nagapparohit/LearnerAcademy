package com.nagappa.controllers;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nagappa.comparator.StudentComprator;
import com.nagappa.dao.ClassEntityDaoImpl;
import com.nagappa.model.ClassEntity;
import com.nagappa.model.StudentEntity;
import com.nagappa.model.SubjectEntity;
import com.nagappa.model.TeacherEntity;

@Controller
public class DisplayClassController {

	@RequestMapping("displayClass")
	public String displayClass(@RequestParam("id")String id,ModelMap map) {

		ClassEntityDaoImpl classDao = new ClassEntityDaoImpl();
		ClassEntity cls = classDao.getClassbyId(Integer.parseInt(id));
		classDao.closeClassEntityDaoImplSession();
		
		char sec = Character.toUpperCase(cls.getSection());
		int stdValue = cls.getValue();
		String sup = getSuperscript(stdValue);
		map.addAttribute("reportHeader",stdValue+"<sup class='supScript'>"+sup+"</sup>"+" "+sec);
		//subjectTeacherTable
		map.addAttribute("subjectTeacherTable", getTeacherTable(cls));
		map.addAttribute("studentTable", getStudentTable(cls));
		map.addAttribute("classInfo",cls.toString());
		
		//classInfo
		return "displayClass";
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
	
	public String getTeacherTable(ClassEntity cls) {
		Map<SubjectEntity,TeacherEntity> subTeach = cls.getSubTeacher();
		String teacherStartTable = "<table class='teacherTable'>";
		String teacherTableHeader ="<tr><th>Subject Name</th><th>Teacher Name</th></tr>";
		String teacherEndTable ="</table>";
		String teacherTableRows ="";
		for (Map.Entry<SubjectEntity,TeacherEntity> entry : subTeach.entrySet()) {
			SubjectEntity sub = entry.getKey();
			TeacherEntity teach = entry.getValue();
			String subName = sub.getName();
			String teachName = teach.getName();
			String starttr ="<tr>";
			String f1 = "<td>"+subName+"</td>";
			String f2 = "<td>"+teachName+"</td>";
			String endtr ="</tr>";
			String totalRow = starttr+f1+f2+endtr;
			//System.out.println(entry.getKey() + "/" + entry.getValue());
			teacherTableRows += totalRow;
		}
		String subjectTeacherTable = teacherStartTable+teacherTableHeader+teacherTableRows+teacherEndTable;
		return subjectTeacherTable;
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
		Collections.sort(students,new StudentComprator());
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
