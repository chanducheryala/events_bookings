package com.bookings.booking_management.strategy.coupon;

import com.bookings.booking_management.dto.EventBookingDto;
import com.bookings.booking_management.enums.DiscountType;

public interface CouponStrategy {
    Long applyCoupon(DiscountType discountType, Long reservedTicketId, Long reservedSeats, Long discount);
}
