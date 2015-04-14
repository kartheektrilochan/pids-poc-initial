package com.pids.dao;

import java.util.List;

import com.pids.entity.User;

public interface IUserDAO {
	
	public User getUserDetails(User user);
	public void save(User user);
	public List<User> find(String queryParam);

}
