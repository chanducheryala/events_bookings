package com.bookings.booking_management.exception;

import jakarta.validation.constraints.NotNull;

public class NoEventFoundException extends RuntimeException{
    public NoEventFoundException(
            @NotNull String message
    ) {
        super(message);
    }
}
