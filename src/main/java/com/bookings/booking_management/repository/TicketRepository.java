package com.bookings.booking_management.repository;

import com.bookings.booking_management.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Query(
            "SELECT t.capacity FROM Ticket t WHERE t.id = :ticketTypeId"
    )
    Long getCapacityByEventIdAndTicketType(@Param("ticketTypeId") Long ticketTypeId);


    @Query(
            "SELECT tt FROM Ticket tt WHERE tt.event.id = :eventId"
    )
    List<Ticket> getEventTicketTypes(@Param("eventId") Long eventId);


    @Query(
            "SELECT tt.cost FROM Ticket tt WHERE tt.id = :ticketTypeId"
    )
    Long getTicketCostByEventAndTicketType(@Param("ticketTypeId") Long ticketTypeId);
}
