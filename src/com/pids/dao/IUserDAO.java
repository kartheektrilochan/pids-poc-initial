package com.pids.dao;

import com.pids.entity.User;

public interface IUserDAO {
	
	public User getUserDetails(User user);
	public void save(User user);

}
