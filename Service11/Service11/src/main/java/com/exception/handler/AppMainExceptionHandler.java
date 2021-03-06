package com.exception.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.errors.ApiError;

@ControllerAdvice
public class AppMainExceptionHandler {


@ExceptionHandler(value= {ArrayIndexOutOfBoundsException.class})
public ResponseEntity<Object> handleArryIndex(ArrayIndexOutOfBoundsException ex,WebRequest request)
{
	
	String errmsg=ex.getLocalizedMessage();
	   
	ApiError error=new ApiError(500,HttpStatus.INTERNAL_SERVER_ERROR,errmsg,"");
	
	
	return new ResponseEntity<>(error,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
	
	
	
}


@ExceptionHandler(value= {CustomerException.class})
public ResponseEntity<Object> handleCustomerException(CustomerException ex,WebRequest request)
{
	
	String errmsg=ex.getLocalizedMessage();
	   
	ApiError error=new ApiError(500,HttpStatus.INTERNAL_SERVER_ERROR,errmsg,request.getContextPath());
	
	
	return new ResponseEntity<>(error,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
	
	
	
}

	
	
}
