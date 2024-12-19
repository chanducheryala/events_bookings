package com.bookings.booking_management.strategy.coupon;

import com.bookings.booking_management.enums.CouponType;
import com.bookings.booking_management.service.TicketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PercentageCouponStrategy implements CouponStrategy{

    private final TicketService ticketService;

    @Autowired
    public PercentageCouponStrategy(TicketService ticketService) {
        this.ticketService = ticketService;
    }
    @Override
    public float applyCoupon(CouponType couponType, Long reservedSeatId, Long reservedSeats, float discount) {
        float ticketCost = ticketService.getCostByEventIdAndTicketType(reservedSeatId);
        float bookingCost = (ticketCost * reservedSeats);
        log.info("ticket cost is {} and booking cost is {}", ticketCost, bookingCost);
        log.info("price after discount at percentage coupon is {}", (bookingCost - (bookingCost * (discount / 100))));
        return (bookingCost - (bookingCost * (discount / 100)));
    }
}
