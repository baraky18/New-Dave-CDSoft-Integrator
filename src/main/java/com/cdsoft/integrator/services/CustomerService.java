package com.cdsoft.integrator.services;

import com.cdsoft.integrator.dtos.CustomerDetailsDto;
import com.cdsoft.integrator.entities.Address;
import com.cdsoft.integrator.mappers.CustomerToCustomerDetailsDtoMapper;
import com.cdsoft.integrator.repositories.AddressRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {

    private final AddressRepository addressRepository;
    private final CustomerToCustomerDetailsDtoMapper customerToCustomerDtoMapper;

    public CustomerDetailsDto getCustomerDetails(String phoneNumber) {
        Optional<Address> addressOptional = addressRepository.findByPhone(phoneNumber);
        if(addressOptional.isEmpty()) return CustomerDetailsDto.builder().build();
        return customerToCustomerDtoMapper.map(addressOptional.get().getCustomerId());
    }
}
