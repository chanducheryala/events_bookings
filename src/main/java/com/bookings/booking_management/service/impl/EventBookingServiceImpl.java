package com.bookings.booking_management.service.impl;

import com.bookings.booking_management.dto.EventBookingDto;
import com.bookings.booking_management.enums.TicketTypeEnum;
import com.bookings.booking_management.exception.NoEventFoundException;
import com.bookings.booking_management.exception.TicketUnavailableException;
import com.bookings.booking_management.model.Event;
import com.bookings.booking_management.model.EventBooking;
import com.bookings.booking_management.repository.EventBookingRepository;
import com.bookings.booking_management.service.EventBookingService;
import com.bookings.booking_management.service.EventService;
import com.bookings.booking_management.service.TicketTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
public class EventBookingServiceImpl implements EventBookingService {


    private final EventBookingRepository eventBookingRepository;
    private final EventService eventService;
    private final TicketTypeService ticketTypeService;

    @Autowired
    public EventBookingServiceImpl(
            EventBookingRepository eventBookingRepository,
            EventService eventService,
            @Lazy TicketTypeService ticketTypeService
    ) {
        this.eventBookingRepository = eventBookingRepository;
        this.eventService = eventService;
        this.ticketTypeService = ticketTypeService;
    }

    @Override
    public EventBookingDto create(Long eventId, EventBookingDto eventBookingDto) {
        Event event = eventService.getEventById(eventId);
        log.info("event", event.toString());
        if(event == null) {
            throw new NoEventFoundException(String.format("No Event found with eventId %d", eventId));
        }
        Long eventTicketTypeCapacity = ticketTypeService.getTicketTypeCapacityByEventId(
                eventId, eventBookingDto.getReserveSeatType()
        );
        log.info("eventTicketTypeCapacity : {}", eventTicketTypeCapacity);
        Long currentEventTicketTypeCount = getReservationSeatsCountByTicketTypes(eventId, eventBookingDto.getReserveSeatType());
        log.info("currentEventTicketTypeCount is {} ", currentEventTicketTypeCount);
        if(currentEventTicketTypeCount + eventBookingDto.getReservedSeats() > eventTicketTypeCapacity) {
            throw new TicketUnavailableException("Tickets are Unavailable");
        }
        EventBooking eventBooking = convertToEventBooking(event, eventBookingDto);
        log.info("eventBooking is {}", eventBooking.toString());
        EventBooking savedEventBooking = eventBookingRepository.save(eventBooking);
        log.info("savedEventBooking is {}", savedEventBooking.toString());
        eventBooking.setId(savedEventBooking.getId());
        return eventBookingDto;
    }

    public EventBooking convertToEventBooking(Event event, EventBookingDto eventBookingDto) {
        return new EventBooking()
                .setEvent(event)
                .setEmail(eventBookingDto.getEmail())
                .setReservedSeats(eventBookingDto.getReservedSeats())
                .setReserveSeatType(eventBookingDto.getReserveSeatType());
    }

    public Long getReservationSeatsCountByTicketTypes(Long eventId, TicketTypeEnum type) {
        log.info("eventId and ticketType is {}, {}", eventId, type);
        return eventBookingRepository.getReservationSeatsCountByTicketTypes(eventId, type);
    }

    @Override
    public List<EventBooking> getEventBookingsByEmail(String email) {
        return eventBookingRepository.getEventBookingsByEmail(email);
    }
}
