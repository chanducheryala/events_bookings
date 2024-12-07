package com.bookings.booking_management.response;

import com.bookings.booking_management.enums.TicketTypeEnum;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class EventBookingResponse {
    private Long id;

    private String title;

    private String about;

    private LocalDate date;

    private LocalTime time;

    private Duration duration;

    private String venue;

    private String language;

    private  HashMap<TicketTypeEnum, HashMap<String, Long>> eventDetails;
}
