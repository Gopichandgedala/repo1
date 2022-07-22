package com.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mappers.CustomerMapper;
import com.model.Customer;
import com.model.CustomerExtractor;

import com.model.CustomerVO;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	/*final String INSERT_QUERY = "insert into test.customer (name, address,mobile,age) values (?,?,?,?)";
	final String GET_ALL="select* from test.customer";
	final String UPDATE_CUST="update test.customer set name=? where id=?";
	final String delete_CUST="delete from test.customer  where id=?";
	*/
	
	@Value("${INSERT_QUERY}")
    private String INSERT_QUERY;
	
	@Value("${GET_ALL}")
	private String GET_ALL;
	
	@Value("${UPDATE_CUST}")
	private String UPDATE_CUST;
	
	@Value("${DELETE_CUST}")
	private String delete_CUST;
	
	@Autowired
   private JdbcTemplate jdbctemplate1;
	
	
	
	
	
	
	
	@Override
	public Map getAllCust() {
		//return jdbctemplate1.query(GET_ALL,new CustomerRowMapper());
		
		return  jdbctemplate1.query(GET_ALL, new CustomerExtractor());
		//return  jdbctemplate1.queryForMap(GET_ALL);
		       
		
		
	}

	@Override
	public boolean addCust(Customer c) {
		// TODO Auto-generated method stub
		            
		jdbctemplate1.update(INSERT_QUERY, c.getName(),c.getAddress(),c.getMobile(),c.getAge());
		
		
		
		
		return true;
	}

	@Override
	public boolean deleteCust(int id) {
		// TODO Auto-generated method stub
		jdbctemplate1.update(delete_CUST, id);
		
		
		return true;
	}

	@Override
	public boolean updateCust(int id, String name) {
		// TODO Auto-generated method stub
		
		jdbctemplate1.update(UPDATE_CUST,name,id);
		
		return true;
	}

}
