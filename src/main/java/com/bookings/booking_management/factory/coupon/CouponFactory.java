package com.bookings.booking_management.factory.coupon;

import com.bookings.booking_management.enums.DiscountType;
import com.bookings.booking_management.strategy.coupon.AmountCouponStrategy;
import com.bookings.booking_management.strategy.coupon.CouponStrategy;
import com.bookings.booking_management.strategy.coupon.NonCouponStrategy;
import com.bookings.booking_management.strategy.coupon.PercentageCouponStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class CouponFactory {

    private final AmountCouponStrategy amountCouponStrategy;
    private final PercentageCouponStrategy percentageCouponStrategy;
    private final NonCouponStrategy nonCouponStrategy;

    @Autowired
    public CouponFactory(
            @Lazy AmountCouponStrategy amountCouponStrategy,
            @Lazy PercentageCouponStrategy percentageCouponStrategy,
            @Lazy NonCouponStrategy nonCouponStrategy) {
        this.amountCouponStrategy = amountCouponStrategy;
        this.percentageCouponStrategy = percentageCouponStrategy;
        this.nonCouponStrategy = nonCouponStrategy;
    }

    public CouponStrategy getCouponStrategy(DiscountType discountType) {
        switch(discountType) {
            case AMOUNT:
                return amountCouponStrategy;
            case PERCENTAGE:
                return percentageCouponStrategy;
            case NON_COUPON:
                return nonCouponStrategy;
            default:
                throw new RuntimeException("No CouponType Found");
        }
    }
}
