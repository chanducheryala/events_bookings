package com.bookings.booking_management.factory.payment;

import com.bookings.booking_management.service.Payment;
import jakarta.transaction.Transactional;

public class CreditsPayment implements Payment {

    @Transactional
    @Override
    public boolean processPayment(Long amount) {
        // add logic with credit card payment
        return true;
    }
}
