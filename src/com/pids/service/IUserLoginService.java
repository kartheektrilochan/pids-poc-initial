package com.pids.service;

import java.util.List;

import com.pids.entity.User;

public interface IUserLoginService {
	
	public User getUserDetails(User user);
	public void save(User user);
	public List<User> findByDeviceId(String deviceId);
}
