package com.bookings.booking_management.validator;

import com.bookings.booking_management.dto.EventBookingDto;
import com.bookings.booking_management.exception.TicketUnavailableException;
import com.bookings.booking_management.service.EventBookingService;
import com.bookings.booking_management.service.TicketTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class EventBookingValidator {

    @Autowired
    private final TicketTypeService ticketTypeService;
    private final EventBookingService eventBookingService;

    public EventBookingValidator(TicketTypeService ticketTypeService, EventBookingService eventBookingService) {
        this.ticketTypeService = ticketTypeService;
        this.eventBookingService = eventBookingService;
    }

    public void validateTicketAvailability(Long eventId, EventBookingDto eventBookingDto) {
        Long capacity = ticketTypeService.getTicketTypeCapacityByEventId(eventId, eventBookingDto.getReservedSeatType());
        Long reserved = eventBookingService.getReservationSeatsCountByTicketTypes(eventId, eventBookingDto.getReservedSeatType());

        if (reserved + eventBookingDto.getReservedSeats() > capacity) {
            throw new TicketUnavailableException(String.format(
                    "Requested %d seats exceed available %d seats for event ID %d",
                    eventBookingDto.getReservedSeats(), capacity - reserved, eventId
            ));
        }
    }
}
