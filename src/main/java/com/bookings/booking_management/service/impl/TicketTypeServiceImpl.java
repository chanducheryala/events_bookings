package com.bookings.booking_management.service.impl;

import com.bookings.booking_management.util.TicketTypeDetails;
import com.bookings.booking_management.enums.TicketTypeEnum;
import com.bookings.booking_management.model.TicketType;
import com.bookings.booking_management.repository.TicketTypeRepository;
import com.bookings.booking_management.service.EventBookingService;
import com.bookings.booking_management.service.TicketTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TicketTypeServiceImpl implements TicketTypeService {

    private final TicketTypeRepository ticketTypeRepository;
    private final EventBookingService eventBookingService;

    @Autowired
    public TicketTypeServiceImpl(TicketTypeRepository ticketTypeRepository, EventBookingService eventBookingService) {
        this.ticketTypeRepository = ticketTypeRepository;
        this.eventBookingService = eventBookingService;
    }

    @Override
    public Long getTicketTypeCapacityByEventId(Long eventId, TicketTypeEnum type) {
        return ticketTypeRepository.getTicketTypeCapacityByEventId(eventId, type);
    }

    @Override
    public List<TicketTypeDetails> getTicketTypeStats(Long eventId) {
        List<TicketType> eventTicketTypes = ticketTypeRepository.getEventTicketTypes(eventId);
        return eventTicketTypes.stream().map(ticketType -> {
          return new TicketTypeDetails()
                    .setType(ticketType.getTicketType())
                    .setCapacity(ticketType.getCapacity())
                    .setCost(ticketType.getCost())
                    .setAvailableSeats(ticketType.getCapacity() - Optional.ofNullable(eventBookingService.getReservationSeatsCountByTicketTypes(eventId, ticketType.getTicketType())).orElse(0L));
        }).collect(Collectors.toList());
    }
}
