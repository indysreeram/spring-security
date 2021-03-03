package com.sreeram.springcloud.couponservice.controllers;

import com.sreeram.springcloud.couponservice.model.Coupon;
import com.sreeram.springcloud.couponservice.repositories.CouponRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CouponWebController {

    @Autowired
    private CouponRepo couponRepo;

//    @GetMapping("/")
//    public String index() {
//        return "index";
//    }

    @GetMapping("/showCreateCoupon")
    public String showCreateCoupon() {
        return "createCoupon";
    }

    @PostMapping("/saveCoupon")
    public String save(Coupon coupon) {
        couponRepo.save(coupon);
        System.out.println("I am being called from the form");
        return "createResponse";
    }

    @GetMapping("/showGetCoupon")
    public String getCoupon(){
        return "getCoupon";
    }

    @PostMapping("/getCoupon")
    public ModelAndView getCoupon(String code) {
        ModelAndView mav = new ModelAndView("couponDetails");
        mav.addObject(couponRepo.findByCode(code));
        return mav;
    }

}
