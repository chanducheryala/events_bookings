package com.bookings.booking_management.service.impl;

import com.bookings.booking_management.dto.TicketDto;
import com.bookings.booking_management.mapper.TicketMapper;
import com.bookings.booking_management.model.Ticket;
import com.bookings.booking_management.repository.TicketRepository;
import com.bookings.booking_management.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {

//    private final TicketTypeRepository ticketTypeRepository;
//    private final EventBookingService eventBookingService;
    private final TicketRepository ticketRepository;
    private final TicketMapper ticketMapper;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository, TicketMapper ticketMapper) {
        this.ticketRepository = ticketRepository;
        this.ticketMapper = ticketMapper;
    }

    @Override
    public Long getTicketTypeCapacityByEventId(Long eventId, Ticket type) {
//        return ticketTypeRepository.getTicketTypeCapacityByEventId(eventId, type);
        return 0L;
    }

    @Override
    public Long getTicketCostByEventAndTicketType(Long eventId, Ticket ticketType) {
//        return ticketTypeRepository.getTicketCostByEventAndTicketType(eventId, ticketType);
        return 0L;
    }


    @Override
    public Ticket create(TicketDto ticketDto) {
        Ticket ticket = ticketMapper.toEntity(ticketDto);
        return ticketRepository.save(ticket);
    }
}
