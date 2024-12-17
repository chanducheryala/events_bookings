package com.bookings.booking_management.mapper;

import com.bookings.booking_management.dto.EventBookingDto;
import com.bookings.booking_management.model.Event;
import com.bookings.booking_management.model.EventBooking;
import org.springframework.stereotype.Component;

@Component
public class EventBookingMapper {
    public EventBooking toEntity(Event event, EventBookingDto eventBookingDto) {
        return new EventBooking()
                .setEvent(event)
                .setEmail(eventBookingDto.getEmail())
                .setReservedSeats(eventBookingDto.getReservedSeats())
                .setReserveSeatType(eventBookingDto.getReservedSeatType());
    }

    public EventBookingDto toDto(EventBooking eventBooking) {
        return new EventBookingDto()
                .setEmail(eventBooking.getEmail())
                .setReservedSeats(eventBooking.getReservedSeats())
                .setReservedSeatType(eventBooking.getReserveSeatType())
                .setPaymentType(eventBooking.getPaymentType());
    }
}
