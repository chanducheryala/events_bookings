package com.bookings.booking_management.strategy.discount;

public interface DiscountStrategy {
    Long applyDiscount(Long cost, Long discount);
}
