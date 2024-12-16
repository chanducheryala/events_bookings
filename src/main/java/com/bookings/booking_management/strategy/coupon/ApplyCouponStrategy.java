package com.bookings.booking_management.strategy.coupon;

import com.bookings.booking_management.dto.EventBookingDto;
import com.bookings.booking_management.factory.coupon.CouponFactory;
import com.bookings.booking_management.factory.coupon.DiscountFactory;
import com.bookings.booking_management.model.TicketType;
import com.bookings.booking_management.service.TicketTypeService;
import com.bookings.booking_management.strategy.discount.DiscountStrategy;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;


public class ApplyCouponStrategy implements CouponStrategy{

    private  DiscountFactory discountFactory;
    private TicketTypeService ticketTypeService;

    public ApplyCouponStrategy(){};

    @Autowired
    public ApplyCouponStrategy(DiscountFactory discountFactory, TicketTypeService ticketTypeService) {
        this.discountFactory = discountFactory;
        this.ticketTypeService = ticketTypeService;
    }

    @Override
    public void applyCoupon(EventBookingDto eventBookingDto) {
        DiscountStrategy discountStrategy = discountFactory.getCouponFactory(eventBookingDto.getDiscountType());
        Long ticketCost = ticketTypeService.getTicketCostByEventAndTicketType(eventBookingDto.getId(), eventBookingDto.getReserveSeatType());
        Long bookingPrice = discountStrategy.applyDiscount((ticketCost * eventBookingDto.getReservedSeats()), eventBookingDto.getDiscount());
        eventBookingDto.setPrice(bookingPrice);
    }
}
