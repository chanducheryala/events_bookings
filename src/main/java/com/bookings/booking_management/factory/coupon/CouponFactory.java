package com.bookings.booking_management.factory.coupon;

import com.bookings.booking_management.enums.DiscountType;
import com.bookings.booking_management.strategy.coupon.AmountCouponStrategy;
import com.bookings.booking_management.strategy.coupon.CouponStrategy;
import org.springframework.stereotype.Component;

@Component
public class CouponFactory {
    public CouponStrategy getCouponStrategy(DiscountType discountType) {
        switch (discountType) {
            case AMOUNT:
                return new AmountCouponStrategy();
            case PERCENTAGE:
                return new AmountCouponStrategy();
            case NON_COUPON:
                return new AmountCouponStrategy();
            default:
                throw new IllegalArgumentException("Error! Invalid discount type.");
        }
    }
}
