package com.mappers;

import com.model.Customer;
import com.model.CustomerVO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-09T16:30:21+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_333 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer customerVoToCustomer(CustomerVO cvo) {
        if ( cvo == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setName( cvo.getName() );
        customer.setAddress( cvo.getAddress() );
        customer.setMobile( cvo.getMobile() );
        if ( cvo.getAge() != null ) {
            customer.setAge( Integer.parseInt( cvo.getAge() ) );
        }

        return customer;
    }

    @Override
    public CustomerVO customerToCustomerVo(Customer c) {
        if ( c == null ) {
            return null;
        }

        CustomerVO customerVO = new CustomerVO();

        customerVO.setName( c.getName() );
        customerVO.setAddress( c.getAddress() );
        customerVO.setMobile( c.getMobile() );
        customerVO.setAge( String.valueOf( c.getAge() ) );

        return customerVO;
    }
}
