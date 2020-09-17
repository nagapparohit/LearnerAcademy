package com.nagappa.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nagappa.dao.ClassEntityDaoImpl;
import com.nagappa.dao.SubjectEntityDAOImpl;
import com.nagappa.dao.TeacherEntityDAOImpl;
import com.nagappa.model.ClassEntity;
import com.nagappa.model.StudentEntity;
import com.nagappa.model.SubjectEntity;
import com.nagappa.model.TeacherEntity;

@Controller
public class AssignTeachSubToClass {

	@RequestMapping(value = "assignTS2C")
	public String assignTS2C(ModelMap map) {
		
		//get all the subject
		SubjectEntityDAOImpl subDao = new SubjectEntityDAOImpl();
		List<SubjectEntity> listSub = subDao.getAllSubject();
		subDao.closeSubjectEntityDAOImplSession();
		
		//get all the teacher
		TeacherEntityDAOImpl teachDao = new TeacherEntityDAOImpl();
		List<TeacherEntity> listTeach = teachDao.getAllTeachers();
		teachDao.closeTeacherEntityDAOImplSession();
		
		//get all the classes
		ClassEntityDaoImpl classDao = new ClassEntityDaoImpl();
		List<ClassEntity> listClass = classDao.getAllClasses();
		classDao.closeClassEntityDaoImplSession();
		
		String selectClassOpenTag = "<select name='standard' id='standard'>";
		String selectClassCloseTag = "</select>";
		String classOptionTag="";
		for(ClassEntity std : listClass) {
			char sec = std.getSection();
			int value = std.getValue();
			String key=String.valueOf(value)+sec;
			
			classOptionTag += "<option value='"+key+"'>"+value+" "+sec+"</option>";
		}
		String finalSelectClassString = selectClassOpenTag+classOptionTag+selectClassCloseTag;
		
		
		String selectSubOpenTag = "<select name='subject' id='subject'>";
		String selectSubCloseTag ="</select>";
		String subOptionTag ="";
		for(SubjectEntity sub : listSub) {
			int id = sub.getId();
			int code = sub.getCode();
			String name = sub.getName();
			subOptionTag += "<option value='"+id+"'>"+name+"-->"+code+"</option>";
		}
		String finalSelectSubString = selectSubOpenTag+subOptionTag+selectSubCloseTag;
		
		
		String selectTeachOpenTag = "<select name='teacher' id='teacher'>";
		String selectTeacherCloseTag ="</select>";
		String subTeacherTag ="";
		for(TeacherEntity teach : listTeach) {
			int id = teach.getId();
			String name = teach.getName();
			subTeacherTag += "<option value='"+id+"'>"+name+"</option>";
		}
		String finalSelectTeacherString = selectTeachOpenTag+subTeacherTag+selectTeacherCloseTag;
		
		
		map.addAttribute("teacherList", finalSelectTeacherString);
		map.addAttribute("subjectList",finalSelectSubString);
		map.addAttribute("classList", finalSelectClassString);
		
		return "assignTSC";
	}
	
}