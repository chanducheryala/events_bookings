package com.bookings.booking_management.factory.coupon;

import com.bookings.booking_management.enums.DiscountType;
import com.bookings.booking_management.strategy.discount.AmountDiscountStrategy;
import com.bookings.booking_management.strategy.discount.DiscountStrategy;
import com.bookings.booking_management.strategy.discount.PercentageDiscountStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DiscountFactory {

    public DiscountStrategy getDiscountStrategy(DiscountType discountType) {
        log.info("discountType is {}", discountType);
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
