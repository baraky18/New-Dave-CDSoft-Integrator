package com.cdsoft.integrator.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDetailsDto {

    private String phoneNumber;
    private String firstName;
    private String lastName;
    private String gender;
}
