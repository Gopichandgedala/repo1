package com.dao;

import java.util.List;
import java.util.Map;

import com.model.Customer;
import com.model.CustomerVO;

public interface CustomerDAO {

	public Map<Long, Customer> getAllCust();
	public boolean addCust(Customer c);
	public boolean deleteCust(int id);
	public boolean updateCust(int id,String name);
	
	
}
