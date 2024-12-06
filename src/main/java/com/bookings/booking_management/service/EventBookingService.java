package com.bookings.booking_management.service;

import com.bookings.booking_management.dto.EventBookingDto;
import com.bookings.booking_management.enums.TicketTypeEnum;

public interface EventBookingService {
    EventBookingDto create(Long EventId, EventBookingDto eventBookingDto);
    Long getReservationSeatsCountByTicketTypes(Long eventId, TicketTypeEnum type);
}
