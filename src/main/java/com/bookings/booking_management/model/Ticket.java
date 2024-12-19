package com.bookings.booking_management.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import java.util.List;

@Entity
@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tickets")
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
    private float cost;

    @OneToMany(mappedBy = "reservedSeatType")
    @JsonManagedReference
    private List<EventBooking> eventBookings;

    @ManyToOne
//    @JsonBackReference
    @JoinColumn(name = "event")
    private Event event;

    public Ticket(String type, float cost, Long capacity, Event event) {
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
