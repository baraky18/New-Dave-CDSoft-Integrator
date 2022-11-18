package com.cdsoft.integrator.dtos;

import com.cdsoft.integrator.entities.ProductCategoryDetails;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDetailsDto {

    private String productName;
    private String productDescription;
    private String productShortDescription;
    private int isInStock;
    private List<ProductCategoryDetailsDto> productCategoriesDetails;
}
