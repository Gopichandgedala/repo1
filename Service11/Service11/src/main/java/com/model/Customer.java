package com.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Customer implements Serializable {
	// @GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	
	//@Size(min = 2, max = 100, message = "address should be in b/w 2 to 100")
	private String address;
	
	//@Pattern(regexp="(^$|[0-9]{10})")
	//@Size(min = 10, max = 10, message = "mobile should be 10 digits")
	private String mobile;
	
	//@Min(value=18,message="min age should be 18")
	//@Max(value=30,message="max age should be 30")
	private int age;
	
}
