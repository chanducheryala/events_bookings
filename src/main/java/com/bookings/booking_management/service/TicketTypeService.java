package com.bookings.booking_management.service;

import com.bookings.booking_management.util.TicketTypeDetails;
import com.bookings.booking_management.enums.TicketTypeEnum;

import java.util.HashMap;
import java.util.List;

public interface TicketTypeService {
    Long getTicketTypeCapacityByEventId(Long eventId, TicketTypeEnum type);
    List<TicketTypeDetails> getTicketTypeStats(Long eventId);
    Long getTicketCostByEventAndTicketType(Long eventId, TicketTypeEnum ticketTypeEnum);
}
