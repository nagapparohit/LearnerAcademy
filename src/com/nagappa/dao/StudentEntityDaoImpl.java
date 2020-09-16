package com.nagappa.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nagappa.model.StudentEntity;

public class StudentEntityDaoImpl implements StudentEntityDao{

	private Transaction txn;
	private Session session;
	
	
	public StudentEntityDaoImpl() {
		super();
		this.session = HibernateUtil.getSessionFactory().openSession();
	}

	public void closeSession() {
		this.session.close();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<StudentEntity> getAllStudent() {
		this.txn = this.session.beginTransaction();
		String queryString = "from StudentEntity";
		Query query = this.session.createQuery(queryString);
		List<StudentEntity>  students = query.getResultList();
		this.txn.commit();
		return students;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<StudentEntity> getStudentByAdmNo(int admNo) {
		this.txn = this.session.beginTransaction();
		String queryString = "from StudentEntity where addmissionNo = :admNo";
		Query query = this.session.createQuery(queryString);
		query.setParameter("admNo", admNo);
		List<StudentEntity>  students = query.getResultList();
		this.txn.commit();
		return students;
	}

	
}
