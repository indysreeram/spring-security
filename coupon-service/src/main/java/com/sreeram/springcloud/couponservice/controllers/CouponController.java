package com.sreeram.springcloud.couponservice.controllers;

import com.sreeram.springcloud.couponservice.model.Coupon;
import com.sreeram.springcloud.couponservice.repositories.CouponRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value ="/couponapi")
public class CouponController {

    @Autowired
    private CouponRepo couponRepo;

    @PostMapping(value ="/coupons")
    public Coupon create(@RequestBody  Coupon coupon){
        return couponRepo.save(coupon);
    }

    @GetMapping(value ="/coupons/{code}")
    public Coupon getCoupon(@PathVariable("code")  String code) {
        return couponRepo.findByCode(code);
    }

}
