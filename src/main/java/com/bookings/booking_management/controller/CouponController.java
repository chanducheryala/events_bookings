package com.bookings.booking_management.controller;

import com.bookings.booking_management.dto.CouponDto;
import com.bookings.booking_management.model.Coupon;
import com.bookings.booking_management.service.CouponService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CouponController {

    @Autowired
    private CouponService couponService;

    @PostMapping("/api/v1/coupons")
    public ResponseEntity<CouponDto> create(@Valid @RequestBody CouponDto couponDto)  {
        return new ResponseEntity<>(couponService.create(couponDto), HttpStatus.CREATED);
    }
}
