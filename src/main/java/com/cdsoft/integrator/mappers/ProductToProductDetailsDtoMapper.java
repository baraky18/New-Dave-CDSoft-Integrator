package com.cdsoft.integrator.mappers;

import com.cdsoft.integrator.dtos.ProductCategoryDetailsDto;
import com.cdsoft.integrator.dtos.ProductDetailsDto;
import com.cdsoft.integrator.entities.ProductCategoryDetails;
import com.cdsoft.integrator.entities.ProductDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;

import static com.cdsoft.integrator.util.Constants.PRODUCT;

@Component
@RequiredArgsConstructor
public class ProductToProductDetailsDtoMapper implements Mapper<ProductDetailsDto, ProductDetails> {

    private final ManufacturerToManufacturerDtoMapper manufacturerMapper;
    private final DeliveryTimeToDeliveryDetailsDtoMapper deliveryDetailsMapper;
    private final ProductFeaturesValuesToFeatureValuesDtoMapper featureValuesMapper;

    @Override
    public ProductDetailsDto map(ProductDetails productDetails) {
        return ProductDetailsDto.builder()
                .productName(productDetails.getProductName())
                .productDescription(productDetails.getProductDescription())
                .productShortDescription(productDetails.getProductShortDescription())
                .isInStock(productDetails.getIsInStock())
                .productCategoryDetails(getProductCategoryDetailsDto(productDetails.getProductCategoryDetails()))
                .manufacturer(manufacturerMapper.map(productDetails.getManufacturer()))
                .price(productDetails.getPrice())
                .deliveryDetails(deliveryDetailsMapper.map(productDetails.getProductCarrierDelivery().get(0).getDeliveryTime()))
                .featuresValues(featureValuesMapper.map(productDetails.getProductFeaturesValues()))
                .build();
    }

    private ProductCategoryDetailsDto getProductCategoryDetailsDto(Set<ProductCategoryDetails> productCategoriesDetails){
        Optional<ProductCategoryDetails> optionalCategory =
                productCategoriesDetails.stream()
                        .filter(p -> p.getProductCategoryParentId().intValue() == 2)
                        .findFirst();
        String categoryName = optionalCategory.isPresent() ? optionalCategory.get().getCategoryName() : PRODUCT;
        return ProductCategoryDetailsDto.builder()
                .categoryName(categoryName)
                .build();
    }
}
