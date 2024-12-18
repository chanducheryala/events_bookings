package com.bookings.booking_management.model;


import com.bookings.booking_management.enums.PaymentType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Setter
@Getter
@Table(name =  "event_bookings")

public class EventBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "email")
    private String email;

    @Column(name = "reserved_seats")
    private Long reservedSeats;


    @ManyToOne
    @JoinColumn(name = "event")
    private Event event;

    @OneToOne
    @JoinColumn(name = "ticket", referencedColumnName = "id")
    private Ticket reservedSeatType;


    @Column(name = "payment_type")
    private PaymentType paymentType;


}










