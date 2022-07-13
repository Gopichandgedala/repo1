package com.service;

import java.util.List;

import com.model.Customer;
import com.model.CustomerVO;

public interface CustomerService {

	public List<Customer> getAllCustomers();
	public boolean addCustomer(CustomerVO cvo);
	public boolean deleteCustomer(int id);
	public boolean updateCustomer(int id,String name);
}
