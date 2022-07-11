package com.consume;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.model.Customer;

@RestController
public class Caller {

	Caller()
	{
		System.out.println("caller const------------------------------");
	}
	
	
	@Autowired
	private RestTemplate restt;
 @GetMapping("/getCustomerCaller")
 public @ResponseBody List getCustomer()
	{
	System.out.println("call getcustomer caller-------------------------------");
		
		//return restt.getForObject("http://localhost:8084/getCustomer", List.class);
		
	return restt.getForObject("http://service1/getCustomer", List.class);
	
		
	}
	
	
	
}
