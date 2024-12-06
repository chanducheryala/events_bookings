package com.bookings.booking_management.controller;

import com.bookings.booking_management.dto.EventBookingDto;
import com.bookings.booking_management.service.EventBookingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventBookingController {

    @Autowired
    private EventBookingService eventBookingService;

    @PostMapping("/api/v1/event-bookings/{eventId}")
    public ResponseEntity<EventBookingDto> create(@PathVariable("eventId") Long eventId, @Valid @RequestBody EventBookingDto eventBookingDto) {
        return new ResponseEntity<>(eventBookingService.create(eventId, eventBookingDto), HttpStatus.CREATED);
    }
}
