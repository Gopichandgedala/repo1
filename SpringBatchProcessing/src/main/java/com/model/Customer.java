package com.model;

import java.io.Serializable;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
public class Customer implements Serializable {
	private long id;
	private String name;
	private String address;
	private String mobile;
	private int age;
	
}
