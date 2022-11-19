package com.cdsoft.integrator.controllers;

import com.cdsoft.integrator.dtos.ProductDetailsDto;
import com.cdsoft.integrator.dtos.ProductRequestDto;
import com.cdsoft.integrator.services.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/product")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final ProductService productService;

    @PostMapping(path = "/name") //it's POST and not GET simply because the product name is too long
    @ResponseBody
    public ProductDetailsDto getProductDetails(@RequestBody ProductRequestDto productRequestDto) {
        log.info("ProductController.getProductDetails\n productName is: " + productRequestDto.getProductName());
        return productService.getProductDetails(productRequestDto.getProductName());
    }
}
