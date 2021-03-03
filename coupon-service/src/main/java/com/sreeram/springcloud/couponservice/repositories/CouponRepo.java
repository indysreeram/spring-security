package com.sreeram.springcloud.couponservice.repositories;

import com.sreeram.springcloud.couponservice.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepo extends JpaRepository<Coupon,Long> {
    Coupon findByCode(String code);
}
