package com.bookings.booking_management.strategy.coupon;

import com.bookings.booking_management.enums.DiscountType;
import com.bookings.booking_management.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NonCouponApplyStrategy implements CouponStrategy{

    @Autowired
    private TicketService ticketTypeService;

    public NonCouponApplyStrategy(){};

    @Override
    public Long applyCoupon(DiscountType discountType, Long reservedTicketId, Long reservedSeats, Long discount) {
        return 0L;
    }
}
