package com.bookings.booking_management.strategy.coupon;

import com.bookings.booking_management.enums.CouponType;
import com.bookings.booking_management.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AmountCouponStrategy implements CouponStrategy {

    private final TicketService ticketService;

    @Autowired
    public AmountCouponStrategy(TicketService ticketService) {
        this.ticketService = ticketService;
    }
    @Override
    public float applyCoupon(CouponType couponType, Long reservedSeatId, Long reservedSeats, float discount) {
        float ticketCost = ticketService.getCostByEventIdAndTicketType(reservedSeatId);
        float bookingCost = (ticketCost * reservedSeats);
        return (bookingCost - discount);
    }
}
