package com.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.Customer;
import com.model.CustomerVO;
import com.service.CustomerService;

@RestController
public class CustomerController {
	
	CustomerController()
	{
		System.out.println("default const....................................");
	}
	
	@Autowired
	private CustomerService customerservice;
	
	
	
	@PutMapping("/updateCustomer")
	public @ResponseBody String updateCustomer(@RequestParam int id,@RequestParam String name)
	{
		customerservice.updateCustomer(id,name);
		
		
		
		
		return "Succsss update "+id;
		
	
		
	}
	
	
	@GetMapping("/getCustomer")
	public @ResponseBody List<Customer> getCustomer()
	{
		
		
		return customerservice.getAllCustomers();
		
	
		
	}
	
	
	@PostMapping(value="/addCustomer", consumes = "application/json", produces = "application/json")
	public @ResponseBody String addCustomer(@Valid @RequestBody CustomerVO cvo)
	{
		
		
		customerservice.addCustomer(cvo);
		
		
		return "Success added";
		
	}
	
	@DeleteMapping(value="/deleteCustomer")
	public @ResponseBody String deleteCustomer(@RequestParam int id)
	{
		
		
		customerservice.deleteCustomer(id);
		
		
		return "Success deleted";
		
	}
	

}
