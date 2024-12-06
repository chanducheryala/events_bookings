package com.bookings.booking_management.service;

import com.bookings.booking_management.enums.TicketTypeEnum;

public interface TicketTypeService {
    Long getReservationCountByTicketType(Long eventId, TicketTypeEnum type);
}
