package com.sreeram.springcloud.productservice.controllers;

import com.sreeram.springcloud.productservice.DTO.Coupon;
import com.sreeram.springcloud.productservice.model.Product;
import com.sreeram.springcloud.productservice.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/productapi")
public class ProductController {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private RestTemplate restTemplate;
    @Value("${coupon-service.url}")
    private String couponServiceUrl;

    @PostMapping(value = "/products")
    public Product create(@RequestBody Product product){
        Coupon coupon = restTemplate.getForObject(couponServiceUrl
                        +product.getCouponCode(),
                         Coupon.class);
        product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
        return productRepo.save(product);
    }

    @GetMapping(value="/products/{id}")
    public Product getProduct(@PathVariable("id") Long id) {
        return productRepo.findById(id).get();
    }


}
