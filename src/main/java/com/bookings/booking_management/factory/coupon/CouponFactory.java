package com.bookings.booking_management.factory.coupon;

import com.bookings.booking_management.dto.EventBookingDto;
import com.bookings.booking_management.enums.DiscountType;
import com.bookings.booking_management.strategy.coupon.ApplyCouponStrategy;
import com.bookings.booking_management.strategy.coupon.CouponStrategy;
import com.bookings.booking_management.strategy.coupon.NonCouponApplyStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CouponFactory {

    public CouponStrategy getCouponFactory(DiscountType discountType) throws IllegalArgumentException{
        switch (discountType) {
            case AMOUNT:
                return new ApplyCouponStrategy();
            case PERCENTAGE:
                return new ApplyCouponStrategy();
            case NON_COUPON:
                return new NonCouponApplyStrategy();
            default:
                throw new IllegalArgumentException("Error ! TODO");
        }
    }
}
