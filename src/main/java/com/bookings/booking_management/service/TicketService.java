package com.bookings.booking_management.service;

import com.bookings.booking_management.dto.TicketDto;
import com.bookings.booking_management.model.Ticket;

public interface TicketService {
    Long getCapacityByEventIdAndTicketType(Long ticketTypeId);
    Long getCostByEventIdAndTicketType(Long ticketTypeId);
    Ticket create(TicketDto ticketDto);
    Ticket getTicketById(Long id);
}
