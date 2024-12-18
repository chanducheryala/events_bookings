package com.bookings.booking_management.service;

import com.bookings.booking_management.dto.CouponDto;
import com.bookings.booking_management.model.Coupon;

public interface CouponService {
    CouponDto create(CouponDto couponDto);
    Coupon getById(Long id);
}
