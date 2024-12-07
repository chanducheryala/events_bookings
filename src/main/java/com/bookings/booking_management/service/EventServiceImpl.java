package com.bookings.booking_management.service;

import com.bookings.booking_management.dto.EventDto;
import com.bookings.booking_management.dto.TicketTypeDto;
import com.bookings.booking_management.enums.TicketTypeEnum;
import com.bookings.booking_management.exception.NoEventFoundException;
import com.bookings.booking_management.model.Event;
import com.bookings.booking_management.model.TicketType;
import com.bookings.booking_management.repository.EventRepository;
import com.bookings.booking_management.response.EventBookingResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;
    private EventBookingService eventBookingService;

    public EventServiceImpl(
            EventRepository eventRepository,
           @Lazy EventBookingService eventBookingService
    ) {
        this.eventRepository = eventRepository;
        this.eventBookingService = eventBookingService;
    }

    @Override
    public EventDto create(EventDto eventDto) {
        Event event = convertEventToEventDto(eventDto);

        Event savedEvent = eventRepository.save(event);
        eventDto.setId(savedEvent.getId());
        return eventDto;
    }

    @Override
    public Event getEventById(Long eventId) {
        return eventRepository.findById(eventId).orElseThrow(() -> new NoEventFoundException(String.format("No Event found with eventId %d", eventId)));
    }

    @Override
    public List<EventBookingResponse> getEventsFromDate(LocalDate date) {
        List<Event> events = eventRepository.getEventsFromDate(date);
        log.info("eventBookingService", eventBookingService);
        List<EventBookingResponse> response = new ArrayList<>();
        for(Event event : events) {
            HashMap<TicketTypeEnum, HashMap<String, Long>> eventTicketType = new HashMap<>();
            for(TicketType ticketType: event.getTicketTypes()) {
                HashMap<String, Long> ticketTypeStats = new HashMap<>();
                log.info("eventId", event.getId());
                log.info("ticketType", ticketType.getTicketType());
                Long bookingsOfTicketType = Optional.ofNullable(eventBookingService.getReservationSeatsCountByTicketTypes(event.getId(), ticketType.getTicketType())).orElse(0L);
                log.info("bookingsOfTicketType", bookingsOfTicketType);
               ticketTypeStats.put("availableTickets", ticketType.getCapacity() - bookingsOfTicketType);
               ticketTypeStats.put("capacity", ticketType.getCapacity());
               ticketTypeStats.put("cost", ticketType.getCost());
               eventTicketType.put(ticketType.getTicketType(), ticketTypeStats);
            }
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
                            .setEventDetails(eventTicketType)
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
        List<TicketType> ticketTypes = new ArrayList<>();
        for(TicketTypeDto ticketTypeDto: eventDto.getTicketTypes()) {
            TicketType ticketType = new TicketType()
                    .setEvent(event)
                    .setTicketType(ticketTypeDto.getTicketType())
                    .setCost(ticketTypeDto.getCost())
                    .setCapacity(ticketTypeDto.getCapacity());
            ticketTypes.add(ticketType);
        }
        event.setTicketTypes(ticketTypes);
        return event;
    }
}
