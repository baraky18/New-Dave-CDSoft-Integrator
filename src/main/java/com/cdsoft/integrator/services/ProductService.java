package com.cdsoft.integrator.services;

import com.cdsoft.integrator.dtos.ProductDetailsDto;
import com.cdsoft.integrator.entities.ProductDetails;
import com.cdsoft.integrator.mappers.ProductToProductDetailsDtoMapper;
import com.cdsoft.integrator.repositories.ProductDetailsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductDetailsRepository productDetailsRepository;
    private final ProductToProductDetailsDtoMapper productToProductDetailsDtoMapper;

    public ProductDetailsDto getProductDetails(String productName) {
        log.info("ProductService.getProductDetails");
        Optional<ProductDetails> productDetailsOptional = productDetailsRepository.findByProductName(productName);
        ProductDetails productDetails = productDetailsOptional.orElseGet(ProductDetails::new);
        return productToProductDetailsDtoMapper.map(productDetails);
    }
}
