package com.bookings.booking_management.mapper;

import com.bookings.booking_management.dto.CouponDto;
import com.bookings.booking_management.model.Coupon;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CouponMapper {

    public Coupon toEntity(CouponDto couponDto) {
        return new Coupon()
                .setTitle(couponDto.getTitle())
                .setDiscountType(couponDto.getDiscountType())
                .setDiscount(couponDto.getDiscount());
    }

    public CouponDto toDto(Coupon coupon) {
        return new CouponDto()
                .setId(coupon.getId())
                .setDiscount(coupon.getDiscount())
                .setDiscountType(coupon.getDiscountType())
                .setTitle(coupon.getTitle());
    }
}
