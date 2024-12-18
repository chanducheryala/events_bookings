package com.bookings.booking_management.strategy.coupon;

import com.bookings.booking_management.enums.DiscountType;
import com.bookings.booking_management.factory.coupon.DiscountFactory;
import com.bookings.booking_management.service.TicketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Slf4j
@Component
public class PercentageCouponStrategy implements CouponStrategy{

    private final DiscountFactory discountFactory;
    private final TicketService ticketService;

    @Autowired
    public PercentageCouponStrategy( DiscountFactory discountFactory, TicketService ticketService) {
        this.discountFactory = discountFactory;
        this.ticketService = ticketService;
    }

    @Override
    public Long applyCoupon(DiscountType discountType, Long reservedTicketId, Long reservedSeats, Long discount) {
        log.info("discountType is {}, reservedTicketId is {}, reservedSeats is {}, discount is {}", discountType, reservedTicketId, reservedSeats, discount);
        Long ticketCost = ticketService.getCostByEventIdAndTicketType(reservedTicketId);
        Long cost = (ticketCost * reservedSeats);
        return Math.max(0L, (cost - (cost / 100)));
    }
}
