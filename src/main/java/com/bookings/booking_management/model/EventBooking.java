package com.bookings.booking_management.model;


import com.bookings.booking_management.enums.PaymentType;
import com.bookings.booking_management.enums.TicketTypeEnum;
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "event_id")
    @JsonBackReference
    private Event event;

    @Column(name = "email")
    private String email;

    @Column(name = "reserved_seats")
    private Long reservedSeats;


    @Column(name = "reserved_seat_type")
    @Enumerated(EnumType.STRING)
    private TicketTypeEnum reserveSeatType;


    @Column(name = "payment_type")
    private PaymentType paymentType;


    @Override
    public String toString() {
        return "EventBooking{" +
                "id=" + id +
                ", event=" + event +
                ", email='" + email + '\'' +
                ", reservedSeats=" + reservedSeats +
                ", reserveSeatType=" + reserveSeatType +
                '}';
    }
}
