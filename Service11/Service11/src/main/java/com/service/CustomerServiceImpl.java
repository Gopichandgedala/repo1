package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CustomerDAO;
import com.mappers.CustomerMapper;
import com.model.Customer;
import com.model.CustomerVO;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerdao;
	
	@Autowired
	private CustomerMapper customermapper;
	
	@Override
	public Map getAllCustomers() {
		// TODO Auto-generated method stub
		
		return customerdao.getAllCust();
		
	}

	@Override
	public boolean addCustomer(CustomerVO cvo) {
		// TODO Auto-generated method stub
		            
		        
		Customer c=customermapper.customerVoToCustomer(cvo);
		/*Customer c=new Customer();
		c.setId(0L);
		c.setName(cvo.getName());
		c.setAddress(cvo.getAddress());
		c.setMobile(cvo.getMobile());
		c.setAge(Integer.parseInt(cvo.getAge()));*/
		customerdao.addCust(c); 
		
		return true;
	}

	@Override
	public boolean deleteCustomer(int id) {
		// TODO Auto-generated method stub
		
		customerdao.deleteCust(id);
		return true;
	}

	@Override
	public boolean updateCustomer(int id, String name) {
		// TODO Auto-generated method stub
		
		
		customerdao.updateCust(id, name);
		
		return true;
	}

}
