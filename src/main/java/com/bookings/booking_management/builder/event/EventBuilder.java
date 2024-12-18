package com.bookings.booking_management.builder.event;

import com.bookings.booking_management.model.Event;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;


public interface EventBuilder {
    EventBuilder setTitle(String title);
    EventBuilder setAbout(String about);
    EventBuilder setDate(LocalDate date);
    EventBuilder setTime(LocalTime time);
    EventBuilder setDuration(Duration duration);
    EventBuilder setVenue(String venue);
    EventBuilder setLanguage(String language);
    Event build();
}
