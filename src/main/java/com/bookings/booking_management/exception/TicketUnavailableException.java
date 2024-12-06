package com.bookings.booking_management.exception;

import jakarta.validation.constraints.NotNull;

public class TicketUnavailableException extends RuntimeException{
    public TicketUnavailableException(
            @NotNull String message
    ) {
        super(message);
    }
}
