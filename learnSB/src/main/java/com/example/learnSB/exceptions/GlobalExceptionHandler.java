package com.example.learnSB.exceptions;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.learnSB.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> ResourceNotFound(ResourceNotFoundException data){
		String msg= data.getMessage();
		return new ResponseEntity<ApiResponse>(new ApiResponse(msg, false, HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
		
	}
			
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, Object>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
		Map<String, Object> errorInfo = new HashMap<>();
//		ex.getBindingResult().getAllErrors().forEach(data-> {
//			System.out.println(data.getDefaultMessage()+"TEST1");
//			System.out.println(((FieldError) data).getField() +"TEST2");
//			System.out.println(((FieldError) data).getRejectedValue()+"TEST2");
//			System.out.println(((FieldError) data).toString()+"TEST3");
//			System.out.println("===============================================");
//			if(((FieldError) data).getField().equals	("password")) {
//				Map<String, String> innerError = new HashMap<>();
//				innerError.put(null, null);
//			}
//		});
		
		List<ObjectError> listData = ex.getBindingResult().getAllErrors();
		Map<String, String> singleError = new HashMap<>();
		IntStream.range(0,listData.size()).forEach(i -> {
			if(((FieldError)listData.get(i)).getField().equalsIgnoreCase("password")) {
				singleError.put(((FieldError)listData.get(i)).getField() +"_"+i, listData.get(i).getDefaultMessage());
			}
			errorInfo.put(((FieldError)listData.get(i)).getField(), listData.get(i).getDefaultMessage());
			if(((FieldError)listData.get(i)).getField().equalsIgnoreCase("password")) {
				errorInfo.put(((FieldError)listData.get(i)).getField(), singleError);
			}
			System.out.println(singleError+ " errorInfo errorInfo errorInfo errorInfoerrorInfo");
		});
//		return null;
		return new ResponseEntity<Map<String, Object>>(errorInfo, HttpStatus.BAD_REQUEST);
	}
}
