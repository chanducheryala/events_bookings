package com.bookings.booking_management.strategy.coupon;

import com.bookings.booking_management.enums.DiscountType;
import com.bookings.booking_management.factory.coupon.DiscountFactory;
import com.bookings.booking_management.service.TicketService;
import com.bookings.booking_management.strategy.discount.DiscountStrategy;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Slf4j
@Component
public class AmountCouponStrategy implements CouponStrategy{

    @Autowired
    private DiscountFactory discountFactory;
    @Autowired
    private TicketService ticketService;


    public AmountCouponStrategy(DiscountFactory discountFactory, TicketService ticketService) {
        this.discountFactory = discountFactory;
        this.ticketService = ticketService;
    }

    @Override
    public Long applyCoupon(DiscountType discountType, Long reservedTicketId, Long reservedSeats, Long discount) {
        log.info("discountType is {}, reservedTicketId is {}, reservedSeats is {}, discount is {}", discountType, reservedTicketId, reservedSeats, discount);
        Long ticketCost = ticketService.getCostByEventIdAndTicketType(reservedTicketId);
        return Math.max(0L, ((ticketCost * reservedSeats) - discount));
    }
}
