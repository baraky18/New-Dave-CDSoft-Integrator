package com.cdsoft.integrator.mappers;

import com.cdsoft.integrator.dtos.ProductCategoryDetailsDto;
import com.cdsoft.integrator.entities.ProductCategoryDetails;
import org.springframework.stereotype.Component;

@Component
public class ProductCategoryDetailsToProductCategoryDetailsDtoMapper implements Mapper<ProductCategoryDetailsDto, ProductCategoryDetails> {

    @Override
    public ProductCategoryDetailsDto map(ProductCategoryDetails productCategoryDetails) {
        return ProductCategoryDetailsDto.builder()
                .categoryName(productCategoryDetails.getCategoryName())
                .build();
    }
}
