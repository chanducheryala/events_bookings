package com.bookings.booking_management.builder.ticket;

import com.bookings.booking_management.model.Event;
import com.bookings.booking_management.model.Ticket;
import jakarta.persistence.Column;
import org.springframework.stereotype.Component;


@Component
public class TicketBuilderImpl implements TicketBuilder {
    private String type;
    private Long capacity;
    private float cost;
    private Event event;

    @Override
    public TicketBuilder setType(String type) {
        this.type = type;
        return this;
    }

    @Override
    public TicketBuilder setCapacity(Long capacity) {
        this.capacity = capacity;
        return this;
    }

    @Override
    public TicketBuilder setCost(float cost) {
        this.cost = cost;
        return this;
    }

    @Override
    public TicketBuilder setEvent(Event event) {
        this.event = event;
        return this;
    }

    @Override
    public Ticket build() {
        return new Ticket(type, cost, capacity, event);
    }
}
