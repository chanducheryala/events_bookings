package com.bookings.booking_management.service.impl;

import com.bookings.booking_management.dto.TicketDto;
import com.bookings.booking_management.mapper.TicketMapper;
import com.bookings.booking_management.model.Ticket;
import com.bookings.booking_management.repository.TicketRepository;
import com.bookings.booking_management.service.EventBookingService;
import com.bookings.booking_management.service.TicketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final EventBookingService eventBookingService;
    private final TicketMapper ticketMapper;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository, TicketMapper ticketMapper, EventBookingService eventBookingService) {
        this.ticketRepository = ticketRepository;
        this.ticketMapper = ticketMapper;
        this.eventBookingService = eventBookingService;
    }

    @Override
    public Long getCapacityByEventIdAndTicketType(Long ticketTypeId) {
        log.info("ticketTypeId is {}", ticketTypeId);
        return ticketRepository.getCapacityByEventIdAndTicketType(ticketTypeId);
    }

    @Override
    public Long getCostByEventIdAndTicketType(Long ticketTypeId) {
        log.info("ticketTypeId is {}", ticketTypeId);
        return ticketRepository.getTicketCostByEventAndTicketType(ticketTypeId);
    }


    @Override
    public Ticket create(TicketDto ticketDto) {
        Ticket ticket = ticketMapper.toEntity(ticketDto);
        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket getTicketById(Long id) {
        return ticketRepository.getById(id);
    }
}
