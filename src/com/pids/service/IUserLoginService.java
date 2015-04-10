package com.pids.service;

import com.pids.entity.User;

public interface IUserLoginService {
	
	public User getUserDetails(User user);
	public void save(User user);
}
