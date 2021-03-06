
package com.errors;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ApiError {

    private HttpStatus status;
    private String message;
    private List<String> errors;
    private int statusCode;
    private Date timestamp;
    private String errormsg;
    private String path;
    public ApiError(HttpStatus status, String message, List<String> errors) {
        super();
        this.status = status;
        this.message = message;
        this.errors = errors;
    }
    public ApiError(String msg)
    {
    	super();
    	this.message=msg;
    }
    
    public ApiError(int statusCode,HttpStatus status,String errormsg,String path) {
        super();
       
        this .timestamp=new Date();
        this.statusCode=statusCode;
        this.status=status;
        
        this.errormsg=errormsg;
        this.path=path;
    }

    
    public ApiError(HttpStatus status, String message, String error) {
        super();
        this.status = status;
        this.message = message;
        errors = Arrays.asList(error);
    }
}