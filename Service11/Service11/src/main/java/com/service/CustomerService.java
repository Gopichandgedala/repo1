package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.model.Customer;
import com.model.CustomerVO;

public interface CustomerService {

	public Map getAllCustomers();
	public boolean addCustomer(CustomerVO cvo);
	public boolean deleteCustomer(int id);
	public boolean updateCustomer(int id,String name);
}
