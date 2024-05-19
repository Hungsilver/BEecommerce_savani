package com.example.wedecomerce.service;

import com.example.wedecomerce.domain.Coupon;

import java.math.BigDecimal;

public interface ICouponService {
    Coupon getCoupon(String code, BigDecimal price);
}
