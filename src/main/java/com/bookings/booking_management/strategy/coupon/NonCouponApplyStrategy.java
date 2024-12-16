package com.bookings.booking_management.strategy.coupon;

import com.bookings.booking_management.dto.EventBookingDto;
import com.bookings.booking_management.service.TicketTypeService;
import org.springframework.beans.factory.annotation.Autowired;

public class NonCouponApplyStrategy implements CouponStrategy{

    private TicketTypeService ticketTypeService;

    public NonCouponApplyStrategy(){};

    @Autowired
    public NonCouponApplyStrategy(TicketTypeService ticketTypeService) {
        this.ticketTypeService = ticketTypeService;
    }

    @Override
    public void applyCoupon(EventBookingDto eventBookingDto) {
        Long ticketCost = ticketTypeService.getTicketCostByEventAndTicketType(eventBookingDto.getId(), eventBookingDto.getReserveSeatType());
        Long bookingsPrice = ticketCost * eventBookingDto.getReservedSeats();
        eventBookingDto.setPrice(bookingsPrice);
    }
}
