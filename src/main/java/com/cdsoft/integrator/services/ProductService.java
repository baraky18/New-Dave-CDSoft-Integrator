package com.cdsoft.integrator.services;

import com.cdsoft.integrator.dtos.FeatureValueDto;
import com.cdsoft.integrator.dtos.ProductDetailsDto;
import com.cdsoft.integrator.dtos.ProductsDetailsDto;
import com.cdsoft.integrator.entities.ProductDetails;
import com.cdsoft.integrator.mappers.ProductToProductDetailsDtoMapper;
import com.cdsoft.integrator.repositories.ProductDetailsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductDetailsRepository productDetailsRepository;
    private final ProductToProductDetailsDtoMapper productToProductDetailsDtoMapper;

    public ProductDetailsDto getProductDetails(String productName) {
        log.info("ProductService.getProductDetails");
        Optional<ProductDetails> productDetailsOptional = productDetailsRepository.getByProductName(productName);
        ProductDetails productDetails = productDetailsOptional.orElseGet(ProductDetails::new);
        return productToProductDetailsDtoMapper.map(productDetails);
    }

    public ProductsDetailsDto getSimilarProductsDetails(List<FeatureValueDto> featureValueDtoList) {
        log.info("ProductService.getSimilarProductsDetails");
        Optional<List<ProductDetails>> productsDetailsOptional = productDetailsRepository.getAllByProductFeaturesValues(featureValueDtoList);
        List<ProductDetails> productsDetails = productsDetailsOptional.orElseGet(ArrayList::new);
        List<ProductDetailsDto> productDetailsDtoList = productsDetails.stream()
                .map(productToProductDetailsDtoMapper::map)
                .collect(Collectors.toList());
        return ProductsDetailsDto.builder().productsDetailsDto(productDetailsDtoList).build();
    }
}
