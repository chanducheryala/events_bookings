package com.bookings.booking_management.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

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


    @OneToMany(mappedBy = "event", fetch = FetchType.LAZY)
//    @JsonManagedReference
    private List<EventBooking> eventBookings;

    @OneToMany(mappedBy = "event", fetch = FetchType.LAZY)
//    @JsonManagedReference
    private List<Ticket> tickets;


    public Event(String title, String about, LocalDate date, LocalTime time, Duration duration, String venue, String language) {
        this.title = title;
        this.about = about;
        this.date = date;
        this.time = time;
        this.duration = duration;
        this.venue = venue;
        this.language = language;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", about='" + about + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", duration=" + duration +
                ", venue='" + venue + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
