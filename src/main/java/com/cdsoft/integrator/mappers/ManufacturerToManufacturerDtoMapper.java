package com.cdsoft.integrator.mappers;

import com.cdsoft.integrator.dtos.ManufacturerDto;
import com.cdsoft.integrator.entities.Manufacturer;
import org.springframework.stereotype.Component;

@Component
public class ManufacturerToManufacturerDtoMapper implements Mapper<ManufacturerDto, Manufacturer> {

    @Override
    public ManufacturerDto map(Manufacturer manufacturer) {
        return ManufacturerDto.builder()
                .manufacturerName(manufacturer.getManufacturerName())
                .build();
    }
}
