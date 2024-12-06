package com.bookings.booking_management.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Getter
@Setter
@Table(name = "events", indexes = {
        @Index(name = "idx_event_date", columnList = "date")
})
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "about")
    private String about;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "time")
    private LocalTime time;

    @Column(name = "duration")
    private Duration duration;

    @Column(name = "venue")
    private String venue;

    @Column(name = "language")
    private String language;

    @Embedded
    private Platinum platinum;

    @Embedded
    private Gold gold;

    @Embedded
    private Silver silver;
}
