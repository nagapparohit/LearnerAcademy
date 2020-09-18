package com.nagappa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nagappa.dao.ClassEntityDaoImpl;
import com.nagappa.dao.SubjectEntityDAOImpl;
import com.nagappa.dao.TeacherEntityDAOImpl;
import com.nagappa.model.ClassEntity;
import com.nagappa.model.SubjectEntity;
import com.nagappa.model.TeacherEntity;

@Controller
public class SaveTeachStuClassController {
	
	@RequestMapping("saveTS2C")
	public String saveTS2C(@RequestParam("standard")String std,@RequestParam("subject")String sub,
						   @RequestParam("teacher")String teacher,ModelMap map) {
		
		
		int classId = Integer.parseInt(std);
		int subjectId = Integer.parseInt(sub);
		int teacherId = Integer.parseInt(teacher);
		
		
		TeacherEntityDAOImpl teachDao = new TeacherEntityDAOImpl();
		TeacherEntity teach = teachDao.getTeacherById(teacherId);
		teachDao.closeTeacherEntityDAOImplSession();
		
		SubjectEntityDAOImpl subDao = new SubjectEntityDAOImpl();
		SubjectEntity subject = subDao.getSubjectById(subjectId);
		subDao.closeSubjectEntityDAOImplSession();
		
		ClassEntityDaoImpl classDao = new ClassEntityDaoImpl();
		ClassEntity cls = classDao.getClassbyId(classId);
		classDao.assignSubToTeacherInClass(subject, teach, cls);
		classDao.closeClassEntityDaoImplSession();
	
		
		return "redirect:assignTS2C";
	}
	
}