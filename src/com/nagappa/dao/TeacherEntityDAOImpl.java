package com.nagappa.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nagappa.model.TeacherEntity;

public class TeacherEntityDAOImpl implements TeacherEntityDAO{
	
	private Session session;
	private Transaction txn;

	public TeacherEntityDAOImpl() {
		super();
		SessionFactory factory = HibernateUtil.getSessionFactory();
		this.session = factory.openSession();
	}
	
	public void closeTeacherEntityDAOImplSession() {
		this.session.close();

	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<TeacherEntity> getAllTeachers() {
		this.txn = this.session.beginTransaction();
		String queryString ="from TeacherEntity";
		Query query = this.session.createQuery(queryString);
		List<TeacherEntity> teachers =query.getResultList();
		this.txn.commit();
		return teachers;
	}

	@SuppressWarnings({"unchecked","rawtypes"})
	@Override
	public List<TeacherEntity> getTeachers(String name) {
		this.txn = this.session.beginTransaction();
		String queryString = "from TeacherEntity where name = :name";
		Query query = this.session.createQuery(queryString);
		query.setParameter("name",name);
		List<TeacherEntity> teachers = query.getResultList();
		this.txn.commit();
		return teachers;
	}

	@SuppressWarnings({"unchecked","rawtypes"})
	@Override
	public List<TeacherEntity> getTeachers(TeacherEntity teacher) {
		this.txn = this.session.beginTransaction();
		String queryString = "from TeacherEntity where name=:name and contactNo= :contactNo";
		Query query = this.session.createQuery(queryString);
		query.setParameter("name",teacher.getName());
		query.setParameter("contactNo",teacher.getContactNo());
		List<TeacherEntity> teachers = query.getResultList();
		this.txn.commit();
		return teachers;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void deleteTeacherEntity(TeacherEntity teacher) {
		this.txn = this.session.beginTransaction();
		String queryString = "delete from TeacherEntity where name:name and contactNo= :contactNo";
		Query query = this.session.createQuery(queryString);
		query.setParameter("name", teacher.getName());
		query.setParameter("contactNo",teacher.getContactNo());
		query.executeUpdate();
		this.txn.commit();
	}
	
	
}
