package com.bookings.booking_management.strategy.coupon;

import com.bookings.booking_management.enums.CouponType;

public interface CouponStrategy {
    float applyCoupon(CouponType couponType, Long reservedSeatId, Long reservedSeats, float discount);
}


/*
*     CouponStrategy().
*
*      AmountCoupon();
*      PercentageCoupon();
*      NonCoupon();
*
* */