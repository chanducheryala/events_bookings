package com.bookings.booking_management.repository;

import com.bookings.booking_management.enums.TicketTypeEnum;
import com.bookings.booking_management.model.TicketType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketTypeRepository extends JpaRepository<TicketType, Long> {

    @Query(
            "SELECT t.capacity FROM TicketType t WHERE t.event.id = :eventId AND t.ticketType = :type"
    )
    Long getReservationCountByTicketType(@Param("eventId") Long eventId, @Param("type") TicketTypeEnum type);

}
