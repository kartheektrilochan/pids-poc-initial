package com.pids.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pids.dao.IUserDAO;
import com.pids.entity.User;


@Service("userLoginService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)

public class UserLoginServiceImpl implements IUserLoginService{

	@Autowired
	private IUserDAO daoObj;

	@Override
	public User getUserDetails(User user) {
		return daoObj.getUserDetails(user);
	}

	@Override
	public void save(User user) {
		 daoObj.save(user);
	}
	

}
