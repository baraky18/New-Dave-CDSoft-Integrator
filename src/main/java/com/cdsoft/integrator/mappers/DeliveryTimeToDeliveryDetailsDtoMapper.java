package com.cdsoft.integrator.mappers;

import com.cdsoft.integrator.mappers.enums.DeliverType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

import static com.cdsoft.integrator.mappers.enums.DeliverType.*;
import static com.cdsoft.integrator.util.Constants.*;
import static com.cdsoft.integrator.util.Constants.DELIVERY_DISTRIBUTION_POINT;

@Component
@RequiredArgsConstructor
public class DeliveryTimeToDeliveryDetailsDtoMapper implements Mapper<String, String>{

    @Override
    public String map(String deliveryTime) {
        if(deliveryTime.contains(DELIVERY_TILL)) return getDeliveryDetailsDto(TILL, deliveryTime);
        else if(deliveryTime.contains(DELIVERY_BUSINESS_DAYS)) return getDeliveryDetailsDto(IN, deliveryTime);
        else if(deliveryTime.equalsIgnoreCase(DELIVERY_PICK_UP)) return DELIVERY_PICK_UP_STATEMENT;
        else if(deliveryTime.equalsIgnoreCase(DELIVERY_NEXT_DAY)) return DELIVERY_NEXT_DAY_STATEMENT;
        else if(deliveryTime.equalsIgnoreCase(DELIVERY_SAME_DAY)) return DELIVERY_SAME_DAY_STATEMENT;
        else if(deliveryTime.equalsIgnoreCase(DELIVERY_DISTRIBUTION_POINT)) return DELIVERY_DISTRIBUTION_POINT_STATEMENT;
        return DELIVERY_E_POST_STATEMENT;
    }

    private String getDeliveryDetailsDto(DeliverType deliverType, String deliveryTime) {
        int deliverDays = Integer.parseInt(deliveryTime.replaceAll("[^0-9]", ""));
        return deliverType.equals(TILL) ? String.format(DELIVERY_TILL_STATEMENT, deliverDays) : String.format(DELIVERY_IN_STATEMENT, deliverDays);
    }
}
