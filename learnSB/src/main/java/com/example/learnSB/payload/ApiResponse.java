package com.example.learnSB.payload;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse {
	
	String msg;
	boolean present;
	HttpStatus status;
	
	public ApiResponse(String msg, boolean present) {
		super();
		this.msg = msg;
		this.present = present;
	}

	public ApiResponse(String msg, boolean present, HttpStatus status) {
		super();
		this.msg = msg;
		this.present = present;
		this.status = status;
	}
	

}
