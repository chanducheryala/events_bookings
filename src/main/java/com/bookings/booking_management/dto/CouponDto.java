package com.bookings.booking_management.dto;


import com.bookings.booking_management.enums.CouponType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.validation.annotation.Validated;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
@Validated
public class CouponDto {

    private Long id;

    @NotNull(message = "title cannot be null")
    private String title;

    @NotNull(message = "discount type cannot be null")
    private CouponType couponType;

    @NotNull(message = "discount cannot be null")
    @Positive(message = "discount cannot be negative")
    private float discount;
}
