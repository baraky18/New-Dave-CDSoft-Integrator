package com.cdsoft.integrator.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeliveryDetailsDto {

    private LocalDateTime deliveryDate;
    private String deliveryMethod;
}
