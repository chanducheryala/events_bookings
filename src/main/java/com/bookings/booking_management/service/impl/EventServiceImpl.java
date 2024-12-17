package com.bookings.booking_management.service.impl;

import com.bookings.booking_management.dto.EventDto;
import com.bookings.booking_management.dto.TicketDto;
import com.bookings.booking_management.exception.NoEventFoundException;
import com.bookings.booking_management.mapper.EventMapper;
import com.bookings.booking_management.model.Event;
import com.bookings.booking_management.model.Ticket;
import com.bookings.booking_management.repository.EventRepository;
import com.bookings.booking_management.response.EventBookingResponse;
import com.bookings.booking_management.service.EventService;
import com.bookings.booking_management.service.TicketTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final TicketTypeService ticketTypeService;
    private final EventMapper eventMapper;

    @Autowired
    public EventServiceImpl(
            EventRepository eventRepository,
            @Lazy TicketTypeService ticketTypeService,
            EventMapper eventMapper
    ) {
        this.eventRepository = eventRepository;
        this.ticketTypeService = ticketTypeService;
        this.eventMapper = eventMapper;
    }

    @Override
    public EventDto create(EventDto eventDto) {
        Event event = eventMapper.toEntity(eventDto);
        Event savedEvent = eventRepository.save(event);
        return eventMapper.toDto(savedEvent);
    }

    @Override
    public Event getEventById(Long eventId) {
        return eventRepository.findById(eventId).orElseThrow(() -> new NoEventFoundException(String.format("No Event found with eventId %d", eventId)));
    }

    @Override
    public List<EventBookingResponse> getEventsFromDate(LocalDate date) {
        List<Event> events = eventRepository.getEventsFromDate(date);
        List<EventBookingResponse> response = new ArrayList<>();
        for(Event event : events) {
            response.add(
                    new EventBookingResponse()
                            .setId(event.getId())
                            .setTitle(event.getTitle())
                            .setAbout(event.getAbout())
                            .setDate(event.getDate())
                            .setTime(event.getTime())
                            .setDuration(event.getDuration())
                            .setLanguage(event.getLanguage())
                            .setVenue(event.getVenue())
                            .setEventDetails(Optional.ofNullable(ticketTypeService.getTicketTypeStats(event.getId())).orElse(new ArrayList<>()))
            );
        }
        return response;
    }


    private Event convertEventToEventDto(EventDto eventDto) {
        Event event = new Event()
                 .setTitle(eventDto.getTitle())
                .setAbout(eventDto.getAbout())
                .setDate(eventDto.getDate())
                .setTime(eventDto.getTime())
                .setDuration(eventDto.getDuration())
                .setLanguage(eventDto.getLanguage())
                .setVenue(eventDto.getVenue());
        List<Ticket> tickets = new ArrayList<>();
        for(TicketDto ticketTypeDto: eventDto.getTicketTypes()) {
            Ticket ticket = new Ticket()
                    .setEvent(event)
                    .setType(ticketTypeDto.getType())
                    .setCost(ticketTypeDto.getCost())
                    .setCapacity(ticketTypeDto.getCapacity());
            tickets.add(ticket);
        }
        event.setTickets(tickets);
        return event;
    }
}
