package com.bookings.booking_management.util;


import com.bookings.booking_management.model.Ticket;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class TicketTypeDetails {
    private Ticket type;
    private Long capacity;
    private Long availableSeats;
    private Long cost;
}
