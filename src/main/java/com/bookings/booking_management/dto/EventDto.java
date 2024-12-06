package com.bookings.booking_management.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class EventDto {

    private Long id;

    @NotNull(message = "title cannot be empty")
    private String title;

    @NotNull(message = "about cannot be empty")
    private String about;

    @NotNull(message = "date cannot be empty")
    private LocalDate date;


    @NotNull(message = "time cannot be empty")
    private LocalTime time;

    @NotNull(message = "duration cannot be empty")
    private Duration duration;

    @NotNull(message = "venue cannot be empty")
    private String venue;

    @NotNull(message = "language cannot be empty")
    private String language;

    @Valid
    private PlatinumDto platinum;

    @Valid
    private GoldDto gold;

    @Valid
    private SilverDto silver;
}
