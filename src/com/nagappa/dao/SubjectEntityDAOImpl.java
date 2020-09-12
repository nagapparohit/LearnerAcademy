package com.nagappa.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nagappa.model.SubjectEntity;

public class SubjectEntityDAOImpl implements SubjectEntityDao{

	private Transaction txn;
	private Session session;
	
	public SubjectEntityDAOImpl() {
		super();
		SessionFactory factory = HibernateUtil.getSessionFactory();
		this.session = factory.openSession();
	}
	public void closeSubjectEntityDAOImplSession() {
		this.session.close();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<SubjectEntity> getAllSubject() {
		this.txn = this.session.beginTransaction();
		String queryString = "from SubjectEntity";
		Query query = this.session.createQuery(queryString);
		List<SubjectEntity> resultDB = query.getResultList();
		this.txn.commit();
		return  resultDB;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<SubjectEntity> getSubject(int code) {
		this.txn = this.session.beginTransaction();
		String queryString = "from SubjectEntity s where s.code = :code";
		Query query = this.session.createQuery(queryString);
		query.setParameter("code", code);
		List<SubjectEntity> subject = query.getResultList();
		this.txn.commit();
		return subject;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<SubjectEntity> getSubject(String name) {
		this.txn = this.session.beginTransaction();
		String queryString = "from SubjectEntity s where s.name = :name";
		Query query = this.session.createQuery(queryString);
		query.setParameter("code", name);
		List<SubjectEntity> subject = query.getResultList();
		this.txn.commit();
		return subject;
	}


	@SuppressWarnings("rawtypes")
	@Override
	public void deleteSubject(SubjectEntity subject) {
		this.txn = this.session.beginTransaction();
		String queryString = "delete from SubjectEntity s where s.name= :name and s.code = :code";
		Query query = this.session.createQuery(queryString);
		query.setParameter("name", subject.getName());
		query.setParameter("code", subject.getCode());
		query.executeUpdate();
		this.txn.commit();
	}

	@Override
	public void updateSubject(SubjectEntity subject) {
		
		
	}
	@Override
	public void addSubject(SubjectEntity subject) {
		this.txn = this.session.beginTransaction();
		this.session.save(subject);
		this.txn.commit();
		
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<SubjectEntity> getSubject(SubjectEntity subject) {
		this.txn = this.session.beginTransaction();
		String queryString = "from SubjectEntity s where s.name = :name and s.code =:code";
		Query query = this.session.createQuery(queryString);
		query.setParameter("name", subject.getName());
		query.setParameter("code", subject.getCode());
		List<SubjectEntity> resultDB = query.getResultList();
		this.txn.commit();
		return resultDB;
	}

	
}
