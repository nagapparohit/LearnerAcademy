package com.nagappa.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nagappa.model.ClassEntity;
import com.nagappa.model.StudentEntity;

public class ClassEntityDaoImpl implements ClassEntityDao{

	private Session session;
	private Transaction txn;

	public ClassEntityDaoImpl() {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		this.session = factory.openSession();
	}
	
	public void closeClassEntityDaoImplSession() {
		this.session.close();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<ClassEntity> getAllClasses() {
		this.txn = this.session.beginTransaction();
		String queryString = "from ClassEntity c";
		Query query=session.createQuery(queryString);
		List<ClassEntity> resultDB = query.getResultList();
		this.txn.commit();
		return resultDB;
	}

	@SuppressWarnings({"unchecked","rawtypes"})
	@Override
	public List<ClassEntity> getClassEntity(ClassEntity classEntity) {
		this.txn = this.session.beginTransaction();
		String queryString = "from ClassEntity c where c.section = :section and c.value=:value";
		Query query = session.createQuery(queryString);
		query.setParameter("section", classEntity.getSection());
		query.setParameter("value", classEntity.getValue());
		List<ClassEntity> resultDB = query.getResultList();
		txn.commit();
		return resultDB;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<ClassEntity> getClassEntity(char section) {
		this.txn = this.session.beginTransaction();
		String queryString = "from ClassEntity c where c.section = :section";
		Query query = session.createQuery(queryString);
		query.setParameter("section", section);
		List<ClassEntity> resultDB = query.getResultList();
		this.txn.commit();
		return resultDB;
	}

	@Override
	public void addClassEntity(ClassEntity classEntity) {
		this.txn = this.session.beginTransaction();
		this.session.save(classEntity);
		this.txn.commit();
		
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void deleteClassEntity(ClassEntity classEntity) {
		this.txn = this.session.beginTransaction();
		String queryString ="delete from ClassEntity c where c.section= :section and c.value= :value";
		Query query = session.createQuery(queryString);
		query.setParameter("section",classEntity.getSection());
		query.setParameter("value", classEntity.getValue());
		query.executeUpdate();
		this.txn.commit();
	}

	@Override
	public void updateClassEntity(ClassEntity classEntity) {
		this.txn = this.session.beginTransaction();
		System.out.println("about to update from update method");
		this.session.update(classEntity);
		this.txn.commit();
		
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void addStudentToClass(StudentEntity studentEntity,ClassEntity classEntity) {
		
		  this.txn = this.session.beginTransaction();
		  String queryString = "from ClassEntity where section=:sec and value=:value"; 
		  Query query = this.session.createQuery(queryString);
		  query.setParameter("sec",classEntity.getSection());
		  query.setParameter("value",classEntity.getValue()); 
		  List<ClassEntity> resultdb = query.getResultList();
		  this.txn.commit();
		  
		  
		  ClassEntity cls = resultdb.get(0);
		  
		  studentEntity.setClassEntity(cls);
		  //System.out.println("before adding studnet class object is "+cls.toString());
		  //cls.addStudent(studentEntity);
		  //System.out.println("after adding studnet class object is "+cls.toString()); 
		  //System.out.println("about to save student in class");
		  this.txn = this.session.beginTransaction();
		  this.session.update("com.nagappa.model.StudentEntity",studentEntity);
		  this.txn.commit();
		  
		 
		 
	}

	

}
