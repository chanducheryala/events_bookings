package com.bookings.booking_management.builder.eventBookingBuilder;

import com.bookings.booking_management.enums.PaymentType;
import com.bookings.booking_management.model.Event;
import com.bookings.booking_management.model.EventBooking;


public interface EventBookingBuilder {

    EventBookingBuilder setEvent(Event event);

    EventBookingBuilder setEmail(String email);

    EventBookingBuilder setReservedSeats(Long reservedSeats);

    EventBookingBuilder setReservedSeatType(Long reservedSeatType);

    EventBookingBuilder setPaymentType (PaymentType paymentType);

    EventBookingBuilder setCoupon(Long couponId);

    EventBookingBuilder applyCoupon();

    EventBooking build();
}
