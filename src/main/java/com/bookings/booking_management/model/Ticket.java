package com.bookings.booking_management.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

@Entity
@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "capacity")
    private Long capacity;

    @Column(name = "cost")
    private Long cost;

    @ManyToOne
    @JoinColumn(name = "event_id")
    @JsonBackReference
    private Event event;

    public Ticket(String type, Long cost, Long capacity, Event event) {
        this.type = type;
        this.cost = cost;
        this.capacity = capacity;
        this.event = event;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", type" + type +
                ", capacity=" + capacity +
                ", cost=" + cost +
                ", event=" + event +
                '}';
    }
}
