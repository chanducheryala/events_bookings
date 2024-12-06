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
public class Gold {

    @Column(name = "gold_seats_capacity")
    private Long capacity;

    @Column(name = "gold_ticket_cost")
    private Long cost;
}
