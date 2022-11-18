package com.cdsoft.integrator.mappers;

import com.cdsoft.integrator.dtos.CustomerDetailsDto;
import com.cdsoft.integrator.entities.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerToCustomerDetailsDtoMapper implements Mapper<CustomerDetailsDto, Customer> {

    @Override
    public CustomerDetailsDto map(Customer customer) {
        return CustomerDetailsDto.builder()
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .phoneNumber(customer.getAddresses().get(0).getMobilePhone())
                .gender(customer.getGender().name())
                .build();
    }
}
