package com.bookings.booking_management.service;

import com.bookings.booking_management.model.Ticket;
import com.bookings.booking_management.util.TicketTypeDetails;

import java.util.List;

public interface TicketTypeService {
    Long getTicketTypeCapacityByEventId(Long eventId, Ticket type);
    List<TicketTypeDetails> getTicketTypeStats(Long eventId);
    Long getTicketCostByEventAndTicketType(Long eventId, Ticket ticketTypeEnum);
}
