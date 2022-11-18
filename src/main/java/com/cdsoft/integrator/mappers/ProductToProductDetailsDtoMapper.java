package com.cdsoft.integrator.mappers;

import com.cdsoft.integrator.dtos.ProductCategoryDetailsDto;
import com.cdsoft.integrator.dtos.ProductDetailsDto;
import com.cdsoft.integrator.entities.ProductDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductToProductDetailsDtoMapper implements Mapper<ProductDetailsDto, ProductDetails> {

    private final ProductCategoryDetailsToProductCategoryDetailsDtoMapper productCategoryMapper;


    @Override
    public ProductDetailsDto map(ProductDetails productDetails) {
        List<ProductCategoryDetailsDto> productCategoryDetailsDtoList = new ArrayList<>();
        productDetails.getProductCategoryDetails().forEach(category -> productCategoryDetailsDtoList.add(productCategoryMapper.map(category)));

        return ProductDetailsDto.builder()
                .productName(productDetails.getProductName())
                .productDescription(productDetails.getProductDescription())
                .productShortDescription(productDetails.getProductShortDescription())
                .isInStock(productDetails.getIsInStock())
                .productCategoriesDetails(productCategoryDetailsDtoList)
                .build();
    }
}
