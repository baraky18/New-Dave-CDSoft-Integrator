package com.cdsoft.integrator.mappers;

import com.cdsoft.integrator.dtos.ProductDetailsDto;
import com.cdsoft.integrator.entities.ProductDetails;
import org.springframework.stereotype.Component;

@Component
public class ProductToProductDetailsDtoMapper implements Mapper<ProductDetailsDto, ProductDetails> {

    @Override
    public ProductDetailsDto map(ProductDetails productDetails) {
        return ProductDetailsDto.builder()
                .productName(productDetails.getProductName())
                .productDescription(productDetails.getProductDescription())
                .productShortDescription(productDetails.getProductShortDescription())
                .build();
    }
}
