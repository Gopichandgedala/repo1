package com.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CustomerRowMapper implements RowMapper<Customer>{
	  @Override
	  public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
	    Customer user = new Customer();
	    user.setId(rs.getLong("ID"));
	    user.setName(rs.getString("name"));
	    user.setAddress(rs.getString("address"));
	    user.setMobile(rs.getString("mobile"));
	    user.setAge(rs.getInt("age"));
	    return user;
	  }
	}