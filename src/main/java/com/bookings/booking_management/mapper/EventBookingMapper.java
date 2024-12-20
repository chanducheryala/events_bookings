package com.bookings.booking_management.mapper;

import com.bookings.booking_management.builder.eventBookingBuilder.EventBookingBuilder;
import com.bookings.booking_management.dto.EventBookingDto;
import com.bookings.booking_management.model.Event;
import com.bookings.booking_management.model.EventBooking;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventBookingMapper {

    private final EventBookingBuilder eventBookingBuilder;

    @Autowired
    public EventBookingMapper(EventBookingBuilder eventBookingBuilder) {
        this.eventBookingBuilder = eventBookingBuilder;
    }

    public EventBooking toEntity(EventBookingDto eventBookingDto) {
        return eventBookingBuilder
                .setEvent(eventBookingDto.getEvent())
                .setEmail(eventBookingDto.getEmail())
                .setReservedSeats(eventBookingDto.getReservedSeats())
                .setReservedSeatType(eventBookingDto.getReservedSeatType())
                .setPaymentType(eventBookingDto.getPaymentType())
                .setCoupon(eventBookingDto.getCoupon())
                .applyCoupon()
                .build();
    }


    public EventBookingDto toDto(EventBooking eventBooking) {
        return new EventBookingDto()
                .setEmail(eventBooking.getEmail())
                .setReservedSeats(eventBooking.getReservedSeats())
                .setPaymentType(eventBooking.getPaymentType());
    }
}
