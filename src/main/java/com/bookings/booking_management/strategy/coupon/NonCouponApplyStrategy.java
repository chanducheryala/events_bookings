package com.bookings.booking_management.strategy.coupon;

import com.bookings.booking_management.dto.EventBookingDto;
import com.bookings.booking_management.enums.DiscountType;
import com.bookings.booking_management.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;

public class NonCouponApplyStrategy implements CouponStrategy{

    private TicketService ticketTypeService;

    public NonCouponApplyStrategy(){};

    @Autowired
    public NonCouponApplyStrategy(TicketService ticketTypeService) {
        this.ticketTypeService = ticketTypeService;
    }

    @Override
    public Long applyCoupon(DiscountType discountType, Long reservedTicketId, Long reservedSeats, Long discount) {
        return 0L;
    }
}
