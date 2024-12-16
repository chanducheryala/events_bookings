package com.bookings.booking_management.strategy.discount;

public class AmountDiscountStrategy implements DiscountStrategy {

    @Override
    public Long applyDiscount(Long cost, Long discount) {
        return Math.max(0L, cost - discount);
    }
}
