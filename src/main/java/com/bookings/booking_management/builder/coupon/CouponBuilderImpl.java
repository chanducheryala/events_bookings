package com.bookings.booking_management.builder.coupon;

import com.bookings.booking_management.enums.DiscountType;

public class CouponBuilderImpl implements CouponBuilder{

    private String title;
    private DiscountType discountType;
    private Long discount;

    @Override
    public CouponBuilder setTitle(String title) {
        this.title = title;
        return null;
    }

    @Override
    public CouponBuilder setDiscountType(DiscountType discountType) {
        this.discountType = discountType;
        return null;
    }

    @Override
    public CouponBuilder setDiscount(Long discount) {
        this.discount = discount;
        return null;
    }
}
