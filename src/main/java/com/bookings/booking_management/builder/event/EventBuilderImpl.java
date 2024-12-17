package com.bookings.booking_management.builder.event;

import com.bookings.booking_management.model.Event;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public class EventBuilderImpl implements EventBuilder {
    private String title;
    private String about;
    private LocalDate date;
    private LocalTime time;
    private Duration duration;
    private String venue;
    private String language;

    @Override
    public EventBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public EventBuilder setAbout(String about) {
        this.about = about;
        return this;
    }

    @Override
    public EventBuilder setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    @Override
    public EventBuilder setTime(LocalTime time) {
        this.time = time;
        return this;
    }

    @Override
    public EventBuilder setDuration(Duration duration) {
        this.duration = duration;
        return this;
    }

    @Override
    public EventBuilder setVenue(String venue) {
        this.venue = venue;
        return this;
    }

    @Override
    public EventBuilder setLanguage(String language) {
        this.language = language;
        return this;
    }

    @Override
    public Event build() {
        return new Event(title, about, date, time, duration, venue, language);
    }
}
