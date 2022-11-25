package com.example.learnSB.exceptions;

@SuppressWarnings("serial")
public class ResourceNotFoundException extends RuntimeException{
	
	public int errorCode;
	public String errorMessage;
	public int userId;
	public ResourceNotFoundException(int errorCode, String errorMessage,int userId) {
		super(String.format("%s Not Found, %s:%s", userId, errorCode,errorMessage ));
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	

}