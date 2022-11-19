package com.cdsoft.integrator.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDetailsDto {

    private String productName;
    private String productDescription;
    private String productShortDescription;
    private int isInStock;
    private ProductCategoryDetailsDto productCategoryDetails;
    private ManufacturerDto manufacturer;
}
