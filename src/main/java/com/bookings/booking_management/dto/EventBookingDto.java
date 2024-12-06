package com.bookings.booking_management.dto;

import com.bookings.booking_management.enums.TicketTypeEnum;
import com.bookings.booking_management.model.Event;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EventBookingDto {
    private Long id;

//    @NotNull(message = "event cannot be null")
    private Event event;

    @NotNull(message = "email cannot be null")
    private String email;

    @NotNull(message = "reserved seats cannot be null")
    @Positive(message = "reserved seats cannot be negative")
    private Long reservedSeats;

    @NotNull(message = "reserved seat type should one of PLATINUM / GOLD / SILVER")
    private TicketTypeEnum reserveSeatType;
}
