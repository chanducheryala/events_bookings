package com.bookings.booking_management.service;

import com.bookings.booking_management.enums.TicketTypeEnum;

public interface Payment {
    boolean processPayment(Long amount);
    Long calculateAmount(Long capacity, Long ticketCost);
}
