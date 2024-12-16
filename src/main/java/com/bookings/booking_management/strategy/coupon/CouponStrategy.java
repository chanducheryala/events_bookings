package com.bookings.booking_management.strategy.coupon;

import com.bookings.booking_management.dto.EventBookingDto;

public interface CouponStrategy {
    void applyCoupon(EventBookingDto eventBookingDto);
}
