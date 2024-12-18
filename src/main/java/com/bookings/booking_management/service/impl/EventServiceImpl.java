package com.bookings.booking_management.service.impl;

import com.bookings.booking_management.dto.EventDto;
import com.bookings.booking_management.dto.TicketDto;
import com.bookings.booking_management.exception.NoEventFoundException;
import com.bookings.booking_management.mapper.EventMapper;
import com.bookings.booking_management.mapper.TicketMapper;
import com.bookings.booking_management.model.Event;
import com.bookings.booking_management.model.Ticket;
import com.bookings.booking_management.repository.EventRepository;
import com.bookings.booking_management.service.EventService;
import com.bookings.booking_management.service.TicketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final TicketService ticketService;
    private final EventMapper eventMapper;
    private final TicketMapper ticketMapper;

    @Autowired
    public EventServiceImpl(
            EventRepository eventRepository,
            @Lazy TicketService ticketService,
            EventMapper eventMapper,
            TicketMapper ticketMapper
    ) {
        this.eventRepository = eventRepository;
        this.ticketService = ticketService;
        this.eventMapper = eventMapper;
        this.ticketMapper = ticketMapper;
    }

    @Override
    public EventDto create(EventDto eventDto) {
        Event event = createEvent(eventDto);
        log.info("created event is {}", event);
        List<TicketDto> savedTickets = createEventTickets(eventDto, event);
        log.info("savedTickets is {}", savedTickets);
        eventDto.setTickets(savedTickets);
        eventDto.setId(event.getId());
        return eventDto;
    }

    @Override
    public Event getEventById(Long eventId) {
        return eventRepository.findById(eventId).orElseThrow(() -> new NoEventFoundException(String.format("No Event found with eventId %d", eventId)));
    }

    private Event createEvent(EventDto eventDto) {
        Event event = eventMapper.toEntity(eventDto);
        return eventRepository.save(event);
    }

    private List<TicketDto> createEventTickets(EventDto eventDto, Event event) {
        return eventDto.getTickets()
                .stream()
                .map(ticketDto -> {
                     ticketDto.setEvent(event);
                     Ticket ticket = ticketService.create(ticketDto);
                     return ticketMapper.toDto(ticket);
                })
                .collect(Collectors.toList());
    }
}
