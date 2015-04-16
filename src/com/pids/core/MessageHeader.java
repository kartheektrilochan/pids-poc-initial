package com.pids.core;


/*
 * This POJO is for JSON Header, holding status of the rest calls
 * */
public class MessageHeader {
	
	private String status;
	private String errorCode;
	private String errorMsg;
	
	public MessageHeader(){
		
	}
	
	public MessageHeader(String status, String errorCode, String errorMsg) {
		this.status = status;
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	

}
