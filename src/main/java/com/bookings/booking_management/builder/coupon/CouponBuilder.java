package com.bookings.booking_management.builder.coupon;

import com.bookings.booking_management.enums.CouponType;

public interface CouponBuilder {

    CouponBuilder setTitle(String title);

    CouponBuilder setDiscountType(CouponType couponType);

    CouponBuilder setDiscount(float discount);

}
