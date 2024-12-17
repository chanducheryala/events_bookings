package com.bookings.booking_management.builder.ticket;
import com.bookings.booking_management.builder.event.EventBuilder;
import com.bookings.booking_management.model.Event;
import com.bookings.booking_management.model.Ticket;

public class TicketBuilderImpl implements TicketBuilder{
    private String type;
    private Long capacity;
    private Long cost;
    private Event event;

    private final TicketBuilder ticketBuilder;

    public TicketBuilderImpl(TicketBuilder ticketBuilder) {
        this.ticketBuilder = ticketBuilder;
    }

    @Override
    public TicketBuilder setType(String type) {
        this.type = type;
        return this.ticketBuilder;
    }

    @Override
    public TicketBuilder setCapacity(Long capacity) {
        this.capacity = capacity;
        return this.ticketBuilder;
    }

    @Override
    public TicketBuilder setCost(Long cost) {
        this.cost = cost;
        return this.ticketBuilder;
    }

    @Override
    public TicketBuilder setEvent(EventBuilder eventBuilder) {
        this.event =
    }

    @Override
    public Ticket build() {
        return new Ticket(type, cost, capacity);
    }
}
