package com.bookings.booking_management.builder.coupon;

import com.bookings.booking_management.enums.CouponType;
import org.springframework.stereotype.Component;

@Component
public class CouponBuilderImpl implements CouponBuilder{

    private String title;
    private CouponType couponType;
    private float discount;

    @Override
    public CouponBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public CouponBuilder setDiscountType(CouponType couponType) {
        this.couponType = couponType;
        return this;
    }

    @Override
    public CouponBuilder setDiscount(float discount) {
        this.discount = discount;
        return this;
    }
}
