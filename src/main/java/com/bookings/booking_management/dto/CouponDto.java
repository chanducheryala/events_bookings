package com.bookings.booking_management.dto;


import com.bookings.booking_management.enums.DiscountType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class CouponDto {

    private Long id;

    @NotNull(message = "title cannot be null")
    private String title;

    @NotNull(message = "discount type cannot be null")
    @Positive(message = "discount type cannot be negative")
    private DiscountType discountType;

    @NotNull(message = "discount cannot be null")
    @Positive(message = "discount cannot be negative")
    private Long discount;
}
