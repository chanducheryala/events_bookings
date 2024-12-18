package com.bookings.booking_management.service;

import com.bookings.booking_management.dto.EventBookingDto;
import com.bookings.booking_management.model.EventBooking;
import com.bookings.booking_management.model.Ticket;

import java.util.List;

public interface EventBookingService {
    EventBookingDto create(Long EventId, EventBookingDto eventBookingDto);
    Long getReservationSeatsCountByTicketTypes(Long eventId, Ticket type);
    List<EventBooking> getEventBookingsByEmail(String email);
}
