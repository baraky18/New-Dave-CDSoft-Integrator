package com.cdsoft.integrator.controllers;

import com.cdsoft.integrator.dtos.ProductDetailsDto;
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

    @GetMapping(path = "/name/{productName}")
    @ResponseBody
    public ProductDetailsDto getProductDetails(@PathVariable String productName) {
        log.info("ProductController.getProductDetails\n productName is: " + productName);
        return productService.getProductDetails(productName);
    }
}
