package com.bookings.booking_management.factory.payment;

import com.bookings.booking_management.service.Payment;
import jakarta.transaction.Transactional;

@Transactional
public class CreditCardPayment implements Payment {

    @Override
    public boolean processPayment(Long amount) {
        // logic for credit card payment
        return true;
    }

    @Override
    public Long calculateAmount(Long capacity, Long ticketCost) {
       return capacity * ticketCost;
    }

}
