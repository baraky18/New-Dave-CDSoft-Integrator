package com.cdsoft.integrator.controllers;

import com.cdsoft.integrator.dtos.ProductDetailsDto;
import com.cdsoft.integrator.dtos.ProductRequestDto;
import com.cdsoft.integrator.services.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/product")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final ProductService productService;
    private final ObjectMapper objectMapper;

    @PostMapping(path = "/name") //it's POST and not GET simply because the product name is too long
    @ResponseBody
    public ProductDetailsDto getProductDetails(@RequestBody ProductRequestDto productRequestDto) throws JsonProcessingException {
        log.info("ProductController.getProductDetails\n productName is: " + productRequestDto.getProductName());
        ProductDetailsDto productDetailsDto = productService.getProductDetails(productRequestDto.getProductName());
        log.info("webhookResponse is: \n" + objectMapper.writeValueAsString(productDetailsDto));
        return productDetailsDto;
    }
}
