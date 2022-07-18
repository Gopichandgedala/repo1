package com.processor.customer;

import org.springframework.batch.item.ItemProcessor;

import com.model.Customer;

public class CustomerProcessor  implements ItemProcessor<Customer,Customer>{

	@Override
	public Customer process(Customer item) throws Exception {
		// TODO Auto-generated method stub
		if(item.getAge()<18)
		{
			item.setAge(0);
			
		}
		
		return item;
	}
	
	

}
