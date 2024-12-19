package com.bookings.booking_management.factory.payment;

import com.bookings.booking_management.service.Payment;
import jakarta.transaction.Transactional;


public class CreditCardPayment implements Payment {

    @Transactional
    @Override
    public boolean processPayment(float amount) {
        // logic for credit card payment
        return true;
    }
}
