package com.cdsoft.integrator.mappers;

import com.cdsoft.integrator.dtos.DeliveryDetailsDto;
import com.cdsoft.integrator.mappers.enums.DeliverType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

import static com.cdsoft.integrator.mappers.enums.DeliverType.*;
import static com.cdsoft.integrator.util.Constants.*;
import static com.cdsoft.integrator.util.Constants.DELIVERY_DISTRIBUTION_POINT;

@Component
@RequiredArgsConstructor
public class DeliveryTimeToDeliveryDetailsDtoMapper implements Mapper<DeliveryDetailsDto, String>{

    @Override
    public DeliveryDetailsDto map(String deliveryTime) {
        if(deliveryTime.contains(DELIVERY_TILL)) return getDeliveryDetailsDto(TILL, deliveryTime);
        else if(deliveryTime.contains(DELIVERY_BUSINESS_DAYS)) return getDeliveryDetailsDto(IN, deliveryTime);
        else if(deliveryTime.equalsIgnoreCase(DELIVERY_PICK_UP)) return getDeliveryDetailsDto(IN_STORE, deliveryTime);
        else if(deliveryTime.equalsIgnoreCase(DELIVERY_NEXT_DAY)) return getDeliveryDetailsDto(NEXT_DAY, deliveryTime);
        else if(deliveryTime.equalsIgnoreCase(DELIVERY_SAME_DAY)) return getDeliveryDetailsDto(SAME_DAY, deliveryTime);
        else if(deliveryTime.equalsIgnoreCase(DELIVERY_DISTRIBUTION_POINT)) return getDeliveryDetailsDto(DISTRIBUTION_POINT, deliveryTime);
        return getDeliveryDetailsDto(E_POST, deliveryTime);
    }

    private DeliveryDetailsDto getDeliveryDetailsDto(DeliverType deliverType, String deliveryTime) {
        LocalDateTime deliverTime = null;
        if(deliverType.equals(TILL) || deliverType.equals(IN)){
            deliverTime = LocalDateTime.now().plusDays(Long.parseLong(deliveryTime.replaceAll("[^0-9]", "")));
        }
        return DeliveryDetailsDto.builder()
                .deliveryDate(deliverTime)
                .deliveryMethod(deliverType.name())
                .build();
    }
}
