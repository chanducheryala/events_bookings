package com.bookings.booking_management.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@NotNull
@Getter
@Setter
public class GoldDto {

    @NotNull(message = "capacity cannot be empty")
    @Positive(message = "capacity cannot be negative")
    private Long capacity;

    @NotNull(message = "cost cannot be empty")
    @Positive(message = "cost cannot be negative")
    private Long cost;

}
