package com.bookings.booking_management.builder.ticket;

import com.bookings.booking_management.model.Event;
import com.bookings.booking_management.model.Ticket;

public class TicketBuilderImpl implements TicketBuilder {
    private String type;
    private Long capacity;
    private Long cost;
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
    public TicketBuilder setCost(Long cost) {
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
