package com.nagappa.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nagappa.model.UserEntity;

public class UserEntityDAOImpl implements UserEntityDAO{

	private Transaction txn;
	private Session session;
	
	public UserEntityDAOImpl() {
		this.session = HibernateUtil.getSessionFactory().openSession();
	}
	
	public void closeSession() {
		this.session.close();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<UserEntity> getUser(String username) {
		this.txn = this.session.beginTransaction();
		String queryString = "from UserEntity u where u.username = :username";
		Query query=session.createQuery(queryString);
		query.setParameter("username", username);
		List<UserEntity> resultDB = query.getResultList();
		this.txn.commit();
		return resultDB;
	}

	@Override
	public void updateUser(UserEntity user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(UserEntity user) {
		// TODO Auto-generated method stub
		
	}

	
}
