package com.bookings.booking_management.validator;

import com.bookings.booking_management.dto.EventBookingDto;
import com.bookings.booking_management.exception.TicketUnavailableException;
import com.bookings.booking_management.service.EventBookingService;
import com.bookings.booking_management.service.TicketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class EventBookingValidator {

    @Autowired
    private final TicketService ticketTypeService;
    private final EventBookingService eventBookingService;

    public EventBookingValidator(TicketService ticketTypeService, @Lazy  EventBookingService eventBookingService) {
        this.ticketTypeService = ticketTypeService;
        this.eventBookingService = eventBookingService;
    }

    public void validateTicketAvailability(Long eventId, EventBookingDto eventBookingDto) {
        Long capacity = ticketTypeService.getCapacityByEventIdAndTicketType(eventBookingDto.getReservedSeatType());
        Long reservedSeats = eventBookingService.getReservationSeatsCountByTicketTypeId(eventBookingDto.getReservedSeatType());
        log.info("capacity is {}", capacity);
        log.info("reserved seats is {}", reservedSeats);
        if (reservedSeats + eventBookingDto.getReservedSeats() > capacity) {
            throw new TicketUnavailableException(String.format(
                    "Requested %d seats exceed available %d seats for event ID %d",
                    eventBookingDto.getReservedSeats(), capacity - reservedSeats, eventId
            ));
        }
    }
}
