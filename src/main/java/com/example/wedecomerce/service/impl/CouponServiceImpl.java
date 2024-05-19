package com.example.wedecomerce.service.impl;

import com.example.wedecomerce.domain.Coupon;
import com.example.wedecomerce.repository.CouponRepository;
import com.example.wedecomerce.service.ICouponService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Transactional
@Service
@Slf4j
@RequiredArgsConstructor
public class CouponServiceImpl implements ICouponService {

    private final CouponRepository couponRepository;

    @Override
    public Coupon getCoupon(String code, BigDecimal price) {
        Optional<Coupon> coupon = couponRepository.findByCode(code);
        if (coupon.isEmpty()) {
            return null;
        }
        if (price.compareTo(coupon.get().getMinSpend()) > 0 && price.compareTo(coupon.get().getMaxSpend()) < 0) {
            return coupon.get();
        }
        return null;
    }
}
