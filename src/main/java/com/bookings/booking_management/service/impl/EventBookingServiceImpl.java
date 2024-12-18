package com.bookings.booking_management.service.impl;

import com.bookings.booking_management.service.EventBookingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EventBookingServiceImpl implements EventBookingService {

//    private final EventBookingRepository eventBookingRepository;
//    private final EventService eventService;
//    private final TicketTypeService ticketTypeService;
//    private final PaymentFactory paymentFactory;
//    private final EventBookingValidator eventBookingValidator;
//    private final EventBookingMapper eventBookingMapper;
//    private final CouponFactory couponFactory;
//
//    @Autowired
//    public EventBookingServiceImpl(
//            EventBookingRepository eventBookingRepository,
//            EventService eventService,
//            @Lazy TicketTypeService ticketTypeService,
//            PaymentFactory paymentFactory,
//            EventBookingValidator eventBookingValidator,
//            EventBookingMapper eventBookingMapper,
//            CouponFactory couponFactory
//    ) {
//        this.eventBookingRepository = eventBookingRepository;
//        this.eventService = eventService;
//        this.ticketTypeService = ticketTypeService;
//        this.paymentFactory = paymentFactory;
//        this.eventBookingValidator = eventBookingValidator;
//        this.eventBookingMapper = eventBookingMapper;
//        this.couponFactory = couponFactory;
//    }
//
//    @Override
//    public EventBookingDto create(Long eventId, EventBookingDto eventBookingDto) {
//        Event event = eventService.getEventById(eventId);
//        eventBookingValidator.validateTicketAvailability(eventId, eventBookingDto);
//        setBookingDiscountTypeIfNull(eventBookingDto);
//        applyCoupon(eventBookingDto);
//        processPayment(eventId, eventBookingDto);
//        EventBooking eventBooking = eventBookingMapper.toEntity(event, eventBookingDto);
//        EventBooking savedEventBooking = eventBookingRepository.save(eventBooking);
//        return eventBookingMapper.toDto(savedEventBooking);
//    }
//
//    private void setBookingDiscountTypeIfNull(EventBookingDto eventBookingDto) {
//        if(eventBookingDto.getDiscountType() == null) {
//            eventBookingDto.setDiscountType(DiscountType.NON_COUPON);
//        }
//    }
//
//    private void applyCoupon(EventBookingDto eventBookingDto) {
//        CouponStrategy couponStrategy = couponFactory.getCouponFactory(eventBookingDto.getDiscountType());
//        couponStrategy.applyCoupon(eventBookingDto);
//    }
//
//    private void processPayment(Long eventId, EventBookingDto eventBookingDto) {
//        Payment payment = paymentFactory.getPayment(eventBookingDto.getPaymentType());
////        Long ticketCost = ticketTypeService.getTicketCostByEventAndTicketType(eventId, eventBookingDto.getReserveSeatType());
////        Long amount = payment.calculateAmount(eventBookingDto.getReservedSeats(), ticketCost);
////        if (!payment.processPayment(amount)) {
////            throw new RuntimeException("Payment failed for event ID " + eventId);
////        }
//    }
//
//    public Long getReservationSeatsCountByTicketTypes(Long eventId, Ticket type) {
//        log.info("eventId and ticketType is {}, {}", eventId, type);
//        return eventBookingRepository.getReservationSeatsCountByTicketTypes(eventId, type);
//    }
//
//    @Override
//    public List<EventBooking> getEventBookingsByEmail(String email) {
//        return eventBookingRepository.getEventBookingsByEmail(email);
//    }
}
