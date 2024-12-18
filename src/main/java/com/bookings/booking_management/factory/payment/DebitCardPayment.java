package com.bookings.booking_management.factory.payment;

import com.bookings.booking_management.service.Payment;
import jakarta.transaction.Transactional;

public class DebitCardPayment implements Payment {

    @Transactional
    @Override
    public boolean processPayment(Long amount) {
        // add logic with credit card payment
        return true;
    }

    @Override
    public Long calculateAmount(Long capacity, Long ticketCost) {
        return capacity * ticketCost;
    }
}
