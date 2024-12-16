package com.bookings.booking_management.repository;

import com.bookings.booking_management.enums.TicketTypeEnum;
import com.bookings.booking_management.model.TicketType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketTypeRepository extends JpaRepository<TicketType, Long> {

    @Query(
            "SELECT t.capacity FROM TicketType t WHERE t.event.id = :eventId AND t.ticketType = :type"
    )
    Long getTicketTypeCapacityByEventId(@Param("eventId") Long eventId, @Param("type") TicketTypeEnum type);


    @Query(
            "SELECT tt FROM TicketType tt WHERE tt.event.id = :eventId"
    )
    List<TicketType> getEventTicketTypes(@Param("eventId") Long eventId);


    @Query(
            "SELECT tt.cost FROM TicketType tt WHERE tt.event.id = :eventId AND tt.ticketType = :ticketType"
    )
    Long getTicketCostByEventAndTicketType(@Param("eventId") Long eventId, @Param("ticketType") TicketTypeEnum ticketType);
}
