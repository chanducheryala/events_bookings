package com.bookings.booking_management.service;

import com.bookings.booking_management.enums.TicketTypeEnum;
import com.bookings.booking_management.repository.TicketTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketTypeServiceImpl implements TicketTypeService{

    @Autowired
    private TicketTypeRepository ticketTypeRepository;

    @Override
    public Long getReservationCountByTicketType(Long eventId, TicketTypeEnum type) {
        return ticketTypeRepository.getReservationCountByTicketType(eventId, type);
    }
}
