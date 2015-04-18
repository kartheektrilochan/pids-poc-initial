package com.pids.utils;

import java.util.Map;

import org.apache.commons.collections.map.HashedMap;

public class PidsQueries {
	
	public static Map<String,String> QUERIES=new HashedMap();
	
	/*Users*/
	public final static String USERS_FINDALL="User.findAll";
	public final static String USERS_FINFALL_Q="SELECT u FROM User u";
	
	public final static String USER_FINDBYDEVICEID="User.findByDeviceId";
	public final static String USERS_FINDBYDEVICEID_Q="SELECT u FROM User u where u.deviceId=:deviceId";
	

}
