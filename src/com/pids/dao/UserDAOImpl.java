package com.pids.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pids.entity.User;

@Repository("userDao")
public class UserDAOImpl implements IUserDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public User getUserDetails(User user) {
		return (User) sessionFactory.getCurrentSession().get(User.class, user.getEmailId());
	}
	
	
	@Override
	public List<User>  find(String queryParam) {
		Query query=sessionFactory.getCurrentSession().getNamedQuery("User.findByDeviceId");
		query.setString("deviceId", queryParam);
		List<User>userList=query.list();
		return userList;
	}

	@Override
	public void save(User user) {
		System.out.println("Saving data.....");
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		session.save(user);
		session.flush();
		tx.commit();
		System.out.println("Saving data");
	}


	
}
