package com.bookings.booking_management.strategy.coupon;


import com.bookings.booking_management.enums.DiscountType;
import com.bookings.booking_management.factory.coupon.DiscountFactory;
import com.bookings.booking_management.service.TicketService;
import com.bookings.booking_management.strategy.discount.DiscountStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class ApplyCouponStrategy implements CouponStrategy{

    private final DiscountFactory discountFactory;
    private final TicketService ticketService;

    @Autowired
    public ApplyCouponStrategy( DiscountFactory discountFactory, TicketService ticketService) {
        this.discountFactory = discountFactory;
        this.ticketService = ticketService;
    }

    @Override
    public Long applyCoupon(DiscountType discountType, Long reservedTicketId, Long reservedSeats, Long discount) {
        log.info("discountType is {}, reservedTicketId is {}, reservedSeats is {}, discount is {}", discountType, reservedTicketId, reservedSeats, discount);
        DiscountStrategy discountStrategy = discountFactory.getCouponFactory(discountType);
        Long ticketCost = ticketService.getCostByEventIdAndTicketType(reservedTicketId);
        return discountStrategy.applyDiscount((ticketCost * reservedSeats), discount);
    }
}
