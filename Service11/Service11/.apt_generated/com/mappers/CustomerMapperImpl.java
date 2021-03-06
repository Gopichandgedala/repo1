package com.mappers;

import com.model.Customer;
import com.model.CustomerVO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-18T17:46:21+0530",
    comments = "version: 1.5.2.Final, compiler: Eclipse JDT (IDE) 3.17.0.v20190306-2240, environment: Java 1.8.0_333 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer customerVoToCustomer(CustomerVO cvo) {
        if ( cvo == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setAddress( cvo.getAddress() );
        if ( cvo.getAge() != null ) {
            customer.setAge( Integer.parseInt( cvo.getAge() ) );
        }
        customer.setMobile( cvo.getMobile() );
        customer.setName( cvo.getName() );

        return customer;
    }

    @Override
    public CustomerVO customerToCustomerVo(Customer c) {
        if ( c == null ) {
            return null;
        }

        CustomerVO customerVO = new CustomerVO();

        customerVO.setAddress( c.getAddress() );
        customerVO.setAge( String.valueOf( c.getAge() ) );
        customerVO.setMobile( c.getMobile() );
        customerVO.setName( c.getName() );

        return customerVO;
    }
}
