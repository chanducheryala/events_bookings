package com.bookings.booking_management.strategy.discount;

public class PercentageDiscountStrategy implements DiscountStrategy {

    @Override
    public Long applyDiscount(Long cost, Long discount) {
        return Math.max(0L, cost - (discount / 100L));
    }
}
