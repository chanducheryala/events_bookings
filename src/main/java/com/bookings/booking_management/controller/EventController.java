package com.bookings.booking_management.controller;


import com.bookings.booking_management.dto.EventDto;
import com.bookings.booking_management.model.Event;
import com.bookings.booking_management.service.EventService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping("/api/v1/events")
    private ResponseEntity<EventDto> create(
            @Valid @RequestBody EventDto eventDto
    ) {
        return new ResponseEntity<>(eventService.create(eventDto), HttpStatus.CREATED);
    }

    @GetMapping("/api/v1/events/{eventId}")
    private ResponseEntity<?> getById(@PathVariable("eventId") Long eventId) {
        log.info("event id is {}", eventId);
        Event event = eventService.getEventById(eventId);
        log.info("event is {}", event);
        if (event == null) {
            return new ResponseEntity<>("Event Not Found", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(event, HttpStatus.OK);
    }
}
