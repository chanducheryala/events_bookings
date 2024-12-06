package com.bookings.booking_management.enums;

public enum TicketTypeEnum {
    PLATINUM("Platinum"),
    GOLD("Gold"),
    SILVER("Silver");

    private final String displayName;

    TicketTypeEnum(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
