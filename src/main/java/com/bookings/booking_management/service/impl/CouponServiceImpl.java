package com.bookings.booking_management.service.impl;

import com.bookings.booking_management.dto.CouponDto;
import com.bookings.booking_management.mapper.CouponMapper;
import com.bookings.booking_management.model.Coupon;
import com.bookings.booking_management.repository.CouponRepository;
import com.bookings.booking_management.service.CouponService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponServiceImpl implements CouponService {

    private final CouponMapper couponMapper;
    private CouponRepository couponRepository;

    @Autowired
    public CouponServiceImpl(CouponMapper couponMapper, CouponRepository couponRepository) {
        this.couponMapper = couponMapper;
        this.couponRepository = couponRepository;
    }

    @Transactional
    @Override
    public CouponDto create(CouponDto couponDto) {
        Coupon coupon = couponMapper.toEntity(couponDto);
        Coupon savedCoupon = couponRepository.save(coupon);
        return couponMapper.toDto(coupon);
    }

    @Override
    public Coupon getById(Long id) {
        return couponRepository.getById(id);
    }
}
