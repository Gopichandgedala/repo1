package com.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.model.Customer;
import com.model.CustomerVO;

@Mapper(componentModel="spring")
public interface CustomerMapper {

	
	public Customer customerVoToCustomer(CustomerVO cvo);
	public CustomerVO customerToCustomerVo(Customer c);
	
}
