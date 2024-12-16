package com.bookings.booking_management.factory.payment;

import com.bookings.booking_management.enums.PaymentType;
import com.bookings.booking_management.service.Payment;

public class PaymentFactory {
    public static Payment getPayment(PaymentType paymentType) {
        switch (paymentType) {
            case CREDIT_CARD:
                return new CreditCardPayment();
            case DEBIT_CARD:
                return new DebitCardPayment();
            case CREDITS:
                return new CreditsPayment();
            default:
                throw new IllegalArgumentException("Unsupported Payment Type: " + paymentType);
        }
    }
}
