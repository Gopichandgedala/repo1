package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.errors.ApiError;
import com.exception.handler.CustomerException;
import com.google.inject.internal.Errors;
import com.model.Customer;
import com.model.CustomerVO;
import com.service.CustomerService;

@RestController
@RequestMapping("serv1")
public class CustomerController {
	
	CustomerController()
	{
		System.out.println("default const....................................");
	}
	
	@Autowired
	private CustomerService customerservice;
	
	
	
	@PutMapping("/updateCustomer")
	public @ResponseBody ResponseEntity<Map> updateCustomer(@RequestParam("cid") int id,@RequestParam("cname") String name)
	{
		customerservice.updateCustomer(id,name);
		
		HashMap hm=new HashMap();
		hm.put("msg","Successfully Updated "+id);
		
		
		
		
		return new ResponseEntity<Map>(hm, HttpStatus.OK);
		
		
	}
	
	
	@GetMapping(value ="/getCustomer")
	public ResponseEntity<Map> getCustomer()
	{
		
		
		return new ResponseEntity<Map>(customerservice.getAllCustomers(),HttpStatus.OK);
		
	
		
	}
	
	
	@PostMapping(value="/addCustomer", consumes = "application/json", produces = "application/json")
	public @ResponseBody ResponseEntity addCustomer(@Valid @RequestBody CustomerVO cvo,BindingResult bindingResult)
	{
		
		
		
		
		if(bindingResult.hasErrors())
		{
			ApiError error=new ApiError(400,HttpStatus.BAD_REQUEST,bindingResult.getFieldError().getDefaultMessage(),"/serv1/addCustomer");
			
	          
			throw new CustomerException(bindingResult.getFieldError().getDefaultMessage());
			
		}
		
		customerservice.addCustomer(cvo);
		return new ResponseEntity<String>("Successfully Added", HttpStatus.OK);
		
		
		
	}
	
	@DeleteMapping(value="/deleteCustomer")
	public @ResponseBody ResponseEntity<String> deleteCustomer(@RequestParam int id)
	{
		
		
		customerservice.deleteCustomer(id);
		
		
		return new ResponseEntity<String>("Successfully Deleted", HttpStatus.OK);
		
	}
	

}
