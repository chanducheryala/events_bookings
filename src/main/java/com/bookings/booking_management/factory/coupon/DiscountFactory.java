package com.bookings.booking_management.factory.coupon;

import com.bookings.booking_management.enums.DiscountType;
import com.bookings.booking_management.strategy.discount.AmountDiscountStrategy;
import com.bookings.booking_management.strategy.discount.DiscountStrategy;
import com.bookings.booking_management.strategy.discount.PercentageDiscountStrategy;
import org.springframework.stereotype.Component;

@Component
public class DiscountFactory {

    public DiscountStrategy getCouponFactory(DiscountType discountType) throws IllegalArgumentException{
        switch (discountType) {
            case AMOUNT:
                return new AmountDiscountStrategy();
            case PERCENTAGE:
                return new PercentageDiscountStrategy();
            default:
                throw new IllegalArgumentException("No discount type found");
        }
    }
}
