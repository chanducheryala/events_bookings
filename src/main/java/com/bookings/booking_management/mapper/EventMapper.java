package com.bookings.booking_management.mapper;


import com.bookings.booking_management.dto.EventDto;
import com.bookings.booking_management.model.Event;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventMapper {

    public Event toEntity(EventDto eventDto) {
        return new Event()
                .setTitle(eventDto.getTitle())
                .setDate(eventDto.getDate())
                .setDuration(eventDto.getDuration())
                .setAbout(eventDto.getAbout())
                .setLanguage(eventDto.getLanguage())
                .setVenue(eventDto.getVenue())
                .setTime(eventDto.getTime());
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
