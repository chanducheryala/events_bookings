package com.bookings.booking_management.repository;

import com.bookings.booking_management.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
}
