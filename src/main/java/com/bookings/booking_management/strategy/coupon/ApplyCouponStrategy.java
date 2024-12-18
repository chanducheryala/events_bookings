package com.bookings.booking_management.strategy.coupon;

import com.bookings.booking_management.dto.EventBookingDto;
import com.bookings.booking_management.enums.DiscountType;
import com.bookings.booking_management.factory.coupon.DiscountFactory;
import com.bookings.booking_management.service.TicketService;
import com.bookings.booking_management.strategy.discount.DiscountStrategy;
import org.springframework.beans.factory.annotation.Autowired;


public class ApplyCouponStrategy implements CouponStrategy{

    private  DiscountFactory discountFactory;
    private TicketService ticketService;

    public ApplyCouponStrategy(){};

    @Autowired
    public ApplyCouponStrategy(DiscountFactory discountFactory, TicketService ticketService) {
        this.discountFactory = discountFactory;
        this.ticketService = ticketService;
    }

    @Override
    public Long applyCoupon(DiscountType discountType, Long reservedTicketId, Long reservedSeats, Long discount) {
        DiscountStrategy discountStrategy = discountFactory.getCouponFactory(discountType);
        Long ticketCost = ticketService.getCostByEventIdAndTicketType(reservedTicketId);
        return discountStrategy.applyDiscount((ticketCost * reservedSeats), discount);
    }
}
