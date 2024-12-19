package com.bookings.booking_management.strategy.coupon;

import com.bookings.booking_management.enums.DiscountType;

public interface CouponStrategy {
    float applyCoupon(DiscountType discountType, Long reservedSeatId, Long reservedSeats, float discount);
}


/*
*     CouponStrategy().
*
*      AmountCoupon();
*      PercentageCoupon();
*      NonCoupon();
*
* */