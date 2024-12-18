package com.bookings.booking_management.service.impl;

import com.bookings.booking_management.dto.EventBookingDto;
import com.bookings.booking_management.factory.coupon.CouponFactory;
import com.bookings.booking_management.factory.payment.PaymentFactory;
import com.bookings.booking_management.mapper.EventBookingMapper;
import com.bookings.booking_management.model.EventBooking;
import com.bookings.booking_management.repository.EventBookingRepository;
import com.bookings.booking_management.service.EventBookingService;
import com.bookings.booking_management.service.EventService;
import com.bookings.booking_management.service.Payment;
import com.bookings.booking_management.service.TicketService;
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
    private final TicketService ticketService;
    private final PaymentFactory paymentFactory;
    private final EventBookingValidator eventBookingValidator;
    private final EventBookingMapper eventBookingMapper;
    private final CouponFactory couponFactory;

    @Autowired
    public EventBookingServiceImpl(
            EventBookingRepository eventBookingRepository,
            EventService eventService,
            @Lazy TicketService ticketService,
            PaymentFactory paymentFactory,
            @Lazy EventBookingValidator eventBookingValidator,
            @Lazy EventBookingMapper eventBookingMapper,
            CouponFactory couponFactory
    ) {
        this.eventBookingRepository = eventBookingRepository;
        this.eventService = eventService;
        this.ticketService = ticketService;
        this.paymentFactory = paymentFactory;
        this.eventBookingValidator = eventBookingValidator;
        this.eventBookingMapper = eventBookingMapper;
        this.couponFactory = couponFactory;
    }

    @Override
    public EventBooking create(Long eventId, EventBookingDto eventBookingDto) {
        eventBookingValidator.validateTicketAvailability(eventId, eventBookingDto);
        eventBookingDto.setEvent(eventId);
        EventBooking eventBooking = eventBookingMapper.toEntity(eventBookingDto);
        processPayment(eventId, eventBooking);
        EventBooking savedEventBooking = eventBookingRepository.save(eventBooking);
        log.info(eventBooking.toString());
        return savedEventBooking;
    }

    private void processPayment(Long eventId, EventBooking eventBooking) {
        Payment payment = paymentFactory.getPayment(eventBooking.getPaymentType());
        if (!payment.processPayment(eventBooking.getPrice())) {
            throw new RuntimeException("Payment failed for event ID " + eventId);
        }
    }

    public Long getReservationSeatsCountByTicketTypeId(Long ticketTypeId) {
        log.info("ticketTypeId is {}", ticketTypeId);
        return eventBookingRepository.getReservationSeatsCountByTicketId(ticketTypeId);
    }

    @Override
    public List<EventBooking> getEventBookingsByEmail(String email) {
        return eventBookingRepository.getEventBookingsByEmail(email);
    }
}
