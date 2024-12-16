package com.bookings.booking_management.service.impl;

import com.bookings.booking_management.dto.EventBookingDto;
import com.bookings.booking_management.enums.TicketTypeEnum;
import com.bookings.booking_management.exception.NoEventFoundException;
import com.bookings.booking_management.exception.TicketUnavailableException;
import com.bookings.booking_management.factory.payment.PaymentFactory;
import com.bookings.booking_management.mapper.EventBookingMapper;
import com.bookings.booking_management.model.Event;
import com.bookings.booking_management.model.EventBooking;
import com.bookings.booking_management.repository.EventBookingRepository;
import com.bookings.booking_management.service.EventBookingService;
import com.bookings.booking_management.service.EventService;
import com.bookings.booking_management.service.Payment;
import com.bookings.booking_management.service.TicketTypeService;
import com.bookings.booking_management.validator.EventBookingValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
public class EventBookingServiceImpl implements EventBookingService {


    private final EventBookingRepository eventBookingRepository;
    private final EventService eventService;
    private final TicketTypeService ticketTypeService;
    private final PaymentFactory paymentFactory;
    private final EventBookingValidator eventBookingValidator;
    private final EventBookingMapper eventBookingMapper;

    @Autowired
    public EventBookingServiceImpl(
            EventBookingRepository eventBookingRepository,
            EventService eventService,
            @Lazy TicketTypeService ticketTypeService,
            PaymentFactory paymentFactory,
            EventBookingValidator eventBookingValidator,
            EventBookingMapper eventBookingMapper
    ) {
        this.eventBookingRepository = eventBookingRepository;
        this.eventService = eventService;
        this.ticketTypeService = ticketTypeService;
        this.paymentFactory = paymentFactory;
        this.eventBookingValidator = eventBookingValidator;
        this.eventBookingMapper = eventBookingMapper;
    }

    @Override
    public EventBookingDto create(Long eventId, EventBookingDto eventBookingDto) {
        Event event = eventService.getEventById(eventId);
        eventBookingValidator.validateTicketAvailability(eventId, eventBookingDto);
        processPayment(eventId, eventBookingDto);
        EventBooking eventBooking = eventBookingMapper.toEntity(event, eventBookingDto);
        EventBooking savedEventBooking = eventBookingRepository.save(eventBooking);
        return eventBookingMapper.toDto(savedEventBooking);
    }


    private void processPayment(Long eventId, EventBookingDto eventBookingDto) {
        Payment payment = paymentFactory.getPayment(eventBookingDto.getPaymentType());
        Long ticketCost = ticketTypeService.getTicketCostByEventAndTicketType(eventId, eventBookingDto.getReserveSeatType());
        Long amount = payment.calculateAmount(eventBookingDto.getReservedSeats(), ticketCost);

        if (!payment.processPayment(amount)) {
            throw new RuntimeException("Payment failed for event ID " + eventId);
        }
    }

    public Long getReservationSeatsCountByTicketTypes(Long eventId, TicketTypeEnum type) {
        log.info("eventId and ticketType is {}, {}", eventId, type);
        return eventBookingRepository.getReservationSeatsCountByTicketTypes(eventId, type);
    }

    @Override
    public List<EventBooking> getEventBookingsByEmail(String email) {
        return eventBookingRepository.getEventBookingsByEmail(email);
    }
}
