package com.bookings.booking_management.service;


import com.bookings.booking_management.dto.EventDto;
import com.bookings.booking_management.enums.TicketTypeEnum;
import com.bookings.booking_management.model.Event;

import java.time.LocalDate;
import java.util.List;

public interface EventService {
    EventDto create(EventDto eventDto);
    Event getEventById(Long eventId);
    List<Event> getEventsFromDate(LocalDate startDate);
}
