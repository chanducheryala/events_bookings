package com.bookings.booking_management.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;
import lombok.experimental.Accessors;

@Embeddable
@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class Platinum {

    @Column(name = "platinum_seats_capacity")
    private Long capacity;

    @Column(name = "platinum_ticket_cost")
    private Long cost;
}
