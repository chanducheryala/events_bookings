package com.bookings.booking_management.repository;

import com.bookings.booking_management.enums.TicketTypeEnum;
import com.bookings.booking_management.model.EventBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventBookingRepository extends JpaRepository<EventBooking, Long> {

    @Query(
            "SELECT SUM(eb.reservedSeats) FROM EventBooking eb WHERE eb.event.id = :eventId AND eb.reserveSeatType = :type"
    )
    Long getReservationSeatsCountByTicketTypes(@Param("eventId") Long eventId, @Param("type")TicketTypeEnum type);

    @Query(
            "SELECT eb FROM EventBooking eb WHERE eb.email = :email"
    )
    List<EventBooking> getEventBookingsByEmail(@Param("email") String email);
}
