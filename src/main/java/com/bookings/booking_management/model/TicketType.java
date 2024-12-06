package com.bookings.booking_management.model;

import com.bookings.booking_management.enums.TicketTypeEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

@Entity
@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ticket_type")
public class TicketType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "ticket_type")
    @Enumerated(EnumType.STRING)
    private TicketTypeEnum ticketType;

    @Column(name = "capacity")
    private Long capacity;

    @Column(name = "cost")
    private Long cost;

    @ManyToOne
    @JoinColumn(name = "event_id")
    @JsonBackReference
    private Event event;

    @Override
    public String toString() {
        return "TicketType{" +
                "id=" + id +
                ", ticketType=" + ticketType +
                ", capacity=" + capacity +
                ", cost=" + cost +
                '}';
    }
}
