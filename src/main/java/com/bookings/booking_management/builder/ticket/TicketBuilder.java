package com.bookings.booking_management.builder.ticket;

import com.bookings.booking_management.builder.event.EventBuilder;
import com.bookings.booking_management.model.Ticket;

public interface TicketBuilder {
    TicketBuilder setType(String type);
    TicketBuilder setCapacity(Long capacity);
    TicketBuilder setCost(Long cost);
    TicketBuilder setEvent(EventBuilder eventBuilder);
    Ticket build();
}
