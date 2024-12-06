package com.bookings.booking_management.service;

import com.bookings.booking_management.dto.EventDto;
import com.bookings.booking_management.dto.GoldDto;
import com.bookings.booking_management.dto.PlatinumDto;
import com.bookings.booking_management.dto.SilverDto;
import com.bookings.booking_management.exception.NoEventFoundException;
import com.bookings.booking_management.model.Event;
import com.bookings.booking_management.model.Gold;
import com.bookings.booking_management.model.Platinum;
import com.bookings.booking_management.model.Silver;
import com.bookings.booking_management.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public EventDto create(EventDto eventDto) {
        Event event = convertEventToEventDto(eventDto);
        Event savedEvent = eventRepository.save(event);
        eventDto.setId(savedEvent.getId());
        return eventDto;
    }

    @Override
    public Event getEventById(Long eventId) {
        return eventRepository.findById(eventId).orElseThrow(() -> new NoEventFoundException(String.format("No Event found with eventId %d", eventId)));
    }

    @Override
    public List<Event> getEventsFromDate(LocalDate date) {
        return eventRepository.getEventsFromDate(date);
    }

    private Event convertEventToEventDto(EventDto eventDto) {
        return new Event()
                .setTitle(eventDto.getTitle())
                .setAbout(eventDto.getAbout())
                .setDate(eventDto.getDate())
                .setTime(eventDto.getTime())
                .setDuration(eventDto.getDuration())
                .setLanguage(eventDto.getLanguage())
                .setVenue(eventDto.getVenue())
                .setPlatinum(convertPlatinumDtoPlatinum(Optional.ofNullable(eventDto.getPlatinum())))
                .setGold(convertGoldDtoGold(Optional.ofNullable(eventDto.getGold())))
                .setSilver(convertSilverDtoSilver(Optional.ofNullable(eventDto.getSilver())));
    }

    private Platinum convertPlatinumDtoPlatinum(Optional<PlatinumDto> platinumDto) {
        return platinumDto.map(dto -> new Platinum()
                        .setCapacity(dto.getCapacity())
                        .setCost(dto.getCost()))
                .orElse(new Platinum());
    }

    private Gold convertGoldDtoGold(Optional<GoldDto> goldDto) {
        return goldDto.map(dto -> new Gold()
                        .setCapacity(dto.getCapacity())
                        .setCost(dto.getCost()))
                .orElse(new Gold());
    }

    private Silver convertSilverDtoSilver(Optional<SilverDto> silverDto) {
        return silverDto.map(dto -> new Silver()
                        .setCapacity(dto.getCapacity())
                        .setCost(dto.getCost()))
                .orElse(new Silver());
    }
}
