package com.cdsoft.integrator.controllers;

import com.cdsoft.integrator.dtos.FeatureValueDto;
import com.cdsoft.integrator.dtos.ProductsDetailsDto;
import com.cdsoft.integrator.services.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/similar-products")
@RequiredArgsConstructor
@Slf4j
public class SimilarProductsController {

    private final ProductService productService;
    private final ObjectMapper objectMapper;

    @GetMapping
    @ResponseBody
    public ProductsDetailsDto getSimilarProductsDetails(@RequestParam List<FeatureValueDto> featureValueDtoList) throws JsonProcessingException {
        log.info("SimilarProductsController.getSimilarProductsDetails\n featureValueDtoList is: " + featureValueDtoList.toString());
        ProductsDetailsDto productsDetailsDto = productService.getSimilarProductsDetails(featureValueDtoList);
        log.info("webhookResponse is: \n" + objectMapper.writeValueAsString(productsDetailsDto));
        return productsDetailsDto;
    }
}
