package com.bookings.booking_management.service;


import com.bookings.booking_management.dto.EventDto;
import com.bookings.booking_management.model.Event;

public interface EventService {
    EventDto create(EventDto eventDto);
    Event getEventById(Long eventId);
}
