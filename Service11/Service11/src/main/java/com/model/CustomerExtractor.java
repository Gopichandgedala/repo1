package com.model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class CustomerExtractor implements ResultSetExtractor<Map<Long, Customer>>,Serializable{

	@Override
	public Map<Long, Customer> extractData(ResultSet rs) throws SQLException, DataAccessException {
		// TODO Auto-generated method stub
		
		
		Map<Long, Customer> customerMap = new HashMap<Long, Customer>();

		while (rs.next()) {
			
			
			 Customer user = new Customer();
			    user.setId(rs.getLong("ID"));
			    user.setName(rs.getString("name"));
			    user.setAddress(rs.getString("address"));
			    user.setMobile(rs.getString("mobile"));
			    user.setAge(rs.getInt("age"));
			   
			
			
			customerMap.put(user.getId(), user);
		        }
		        return customerMap;
		
		
		
	}

}
