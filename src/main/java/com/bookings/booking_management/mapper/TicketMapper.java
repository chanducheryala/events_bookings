package com.bookings.booking_management.mapper;

import com.bookings.booking_management.builder.ticket.TicketBuilder;
import com.bookings.booking_management.dto.TicketDto;
import com.bookings.booking_management.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TicketMapper {

    private final TicketBuilder ticketBuilder;

    @Autowired
    public TicketMapper(TicketBuilder ticketBuilder) {
        this.ticketBuilder = ticketBuilder;
    }

    public Ticket toEntity(TicketDto ticketDto) {
        return ticketBuilder
                .setType(ticketDto.getType())
                .setCapacity(ticketDto.getCapacity())
                .setCost(ticketDto.getCost())
                .setEvent(ticketDto.getEvent())
                .build();
    }

    public TicketDto toDto(Ticket ticket) {
        return new TicketDto()
                .setId(ticket.getId())
                .setType(ticket.getType())
                .setCapacity(ticket.getCapacity())
                .setCost(ticket.getCost());
    }
}
