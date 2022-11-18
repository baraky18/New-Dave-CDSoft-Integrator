package com.cdsoft.integrator.controllers;

import com.cdsoft.integrator.dtos.CustomerDetailsDto;
import com.cdsoft.integrator.services.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/customer")
@RequiredArgsConstructor
@Slf4j
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping(path = "/phone-number/{phoneNumber}")
    @ResponseBody
    public CustomerDetailsDto getCustomerDetails(@PathVariable String phoneNumber) {
        log.info("CustomerController.getCustomerDetails\n phoneNumber is: " + phoneNumber);
        return customerService.getCustomerDetails(phoneNumber);
    }
}
