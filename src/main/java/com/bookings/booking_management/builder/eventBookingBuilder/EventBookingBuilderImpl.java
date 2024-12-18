package com.bookings.booking_management.builder.eventBookingBuilder;

import com.bookings.booking_management.enums.DiscountType;
import com.bookings.booking_management.enums.PaymentType;
import com.bookings.booking_management.factory.coupon.CouponFactory;
import com.bookings.booking_management.model.Coupon;
import com.bookings.booking_management.model.Event;
import com.bookings.booking_management.model.EventBooking;
import com.bookings.booking_management.model.Ticket;
import com.bookings.booking_management.service.CouponService;
import com.bookings.booking_management.service.EventService;
import com.bookings.booking_management.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class EventBookingBuilderImpl implements EventBookingBuilder{

    private Event event;
    private String email;
    private Long reservedSeats;
    private Ticket reservedSeatType;
    private PaymentType paymentType;
    private Coupon coupon;
    private Long price;

    private final TicketService ticketService;
    private final CouponFactory couponFactory;
    private final CouponService couponService;
    private final EventService eventService;

    @Autowired
    public EventBookingBuilderImpl(
            TicketService ticketService,
            CouponFactory couponFactory,
            CouponService couponService,
            EventService eventService
    ) {
        this.ticketService = ticketService;
        this.couponFactory = couponFactory;
        this.couponService = couponService;
        this.eventService = eventService;
    }

    @Override
    public EventBookingBuilder setEvent(Long eventId) {
        this.event = eventService.getEventById(eventId);
        return this;
    }

    @Override
    public EventBookingBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public EventBookingBuilder setReservedSeats(Long reservedSeats) {
        this.reservedSeats = reservedSeats;
        return this;
    }

    @Override
    public EventBookingBuilder setReservedSeatType(Long reservedSeatType) {
        this.reservedSeatType = ticketService.getTicketById(reservedSeatType);
        return this;
    }

    @Override
    public EventBookingBuilder setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
        return null;
    }


    @Override
    public EventBookingBuilder setCoupon(Long couponId) {
        this.coupon = couponService.getById(couponId);
        return this;
    }


    @Override
    public EventBookingBuilder applyCoupon() {
        this.price = couponFactory.getCouponFactory(coupon.getDiscountType()).applyCoupon(
                coupon.getDiscountType(),
                reservedSeatType.getId(),
                reservedSeats,
                coupon.getDiscount()
        );
        return this;
    }

    public EventBooking build() {
        return new EventBooking(event, email, reservedSeats, reservedSeatType, paymentType, coupon, price);
    }
}
