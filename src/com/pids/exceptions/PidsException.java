package com.pids.exceptions;

public class PidsException extends Exception{
	
	public static String INVALID_DATA_EXCEPTION="Data is not valid";
	
	public PidsException(String s){
		super(s);
	}
}
