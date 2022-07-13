package com.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerVO {

	
	private String name;
	private String address;
	private String mobile;
	private String age;
	
	
}
