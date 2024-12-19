package com.bookings.booking_management.builder.coupon;

import com.bookings.booking_management.enums.DiscountType;

public interface CouponBuilder {

    CouponBuilder setTitle(String title);

    CouponBuilder setDiscountType(DiscountType discountType);

    CouponBuilder setDiscount(float discount);

}
