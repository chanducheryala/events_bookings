package com.bookings.booking_management.dto;

import com.bookings.booking_management.model.Event;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import lombok.experimental.Accessors;


@AllArgsConstructor
@NotNull
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Accessors(chain = true)
public class TicketDto {

    private Long id;

    @NotNull(message = "ticket type cannot be empty")
    private String type;

    @NotNull(message = "capacity cannot be empty")
    @Positive(message = "capacity cannot be negative")
    private Long capacity;

    @NotNull(message = "cost cannot be empty")
    @Positive(message = "cost cannot be negative")
    private Long cost;

    private Event event;

}
