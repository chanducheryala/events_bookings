package com.bookings.booking_management.strategy.coupon;

import com.bookings.booking_management.enums.DiscountType;
import com.bookings.booking_management.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NonCouponStrategy implements CouponStrategy {

    private final TicketService ticketService;

    @Autowired
    public NonCouponStrategy(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @Override
    public float applyCoupon(DiscountType discountType, Long reservedSeatId, Long reservedSeats, float discount) {
        float ticketCost = ticketService.getCostByEventIdAndTicketType(reservedSeatId);
        float bookingCost = (ticketCost * reservedSeats);
        return bookingCost;
    }
}
