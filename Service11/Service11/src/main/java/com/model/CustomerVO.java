package com.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerVO {

	
	@NotNull(message="Name should not be null")
	private String name;
	
	@NotNull(message="Address should not be null")
	private String address;
	
	@Size(min = 10, max = 10, message = "The length of mobile must be  10 characters.")
	private String mobile;
	@Min(value=18,message="min age should be 18")
	@Max(value=30,message="max age should be 30")
	private String age;
	
	
}
