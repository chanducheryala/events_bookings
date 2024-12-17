package com.bookings.booking_management.service;

public interface Payment {
    boolean processPayment(Long amount);
    Long calculateAmount(Long capacity, Long ticketCost);
}
