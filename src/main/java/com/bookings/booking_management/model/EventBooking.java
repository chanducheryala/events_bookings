package com.bookings.booking_management.model;


import com.bookings.booking_management.enums.DiscountType;
import com.bookings.booking_management.enums.PaymentType;
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

    @Column(name = "discount_type")
    private DiscountType discountType;

    @Column(name = "payment_type")
    private PaymentType paymentType;

    @Column(name = "price")
    private Long price;

    @ManyToOne
    @JoinColumn(name = "coupon", referencedColumnName = "id")
    private Coupon coupon;

    public EventBooking(
            Event event,
            String email,
            Long reservedSeats,
            Ticket reservedSeatType,
            PaymentType paymentType,
            Coupon coupon,
            Long price
    ) {
        this.event = event;
        this.email = email;
        this.reservedSeats = reservedSeats;
        this.paymentType = paymentType;
        this.reservedSeatType = reservedSeatType;
        this.coupon = coupon;
        this.price = price;
    }

    @Override
    public String toString() {
        return "EventBooking{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", reservedSeats=" + reservedSeats +
                ", event=" + event +
                ", reservedSeatType=" + reservedSeatType +
                ", discountType=" + discountType +
                ", paymentType=" + paymentType +
                ", price=" + price +
                ", coupon=" + coupon +
                '}';
    }
}










