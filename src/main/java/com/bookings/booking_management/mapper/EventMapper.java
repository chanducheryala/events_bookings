package com.bookings.booking_management.mapper;

import com.bookings.booking_management.builder.event.EventBuilder;
import com.bookings.booking_management.dto.EventDto;
import com.bookings.booking_management.model.Event;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventMapper {

    private final EventBuilder eventBuilder;
    public Event toEntity(EventDto eventDto) {
        return eventBuilder
                .setTitle(eventDto.getTitle())
                .setAbout(eventDto.getAbout())
                .setDate(eventDto.getDate())
                .setTime(eventDto.getTime())
                .setDuration(eventDto.getDuration())
                .setLanguage(eventDto.getLanguage())
                .setVenue(eventDto.getVenue())
                .build();
    }

    public EventDto toDto(Event event) {
        return new EventDto()
                .setId(event.getId())
                .setTitle(event.getTitle())
                .setDate(event.getDate())
                .setDuration(event.getDuration())
                .setAbout(event.getAbout())
                .setLanguage(event.getLanguage())
                .setVenue(event.getVenue())
                .setTime(event.getTime());
    }
}
