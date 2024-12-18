package com.bookings.booking_management.service;

import com.bookings.booking_management.dto.TicketDto;
import com.bookings.booking_management.model.Ticket;

public interface TicketService {
    Long getTicketTypeCapacityByEventId(Long eventId, Ticket type);
    Long getTicketCostByEventAndTicketType(Long eventId, Ticket ticketTypeEnum);
    Ticket create(TicketDto ticketDto);
}
