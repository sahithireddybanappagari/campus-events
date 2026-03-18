package com.yourcollege.campus_events_backend.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "registrations")

public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many registrations can belong to one user
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private user user;

    // Many registrations can belong to one event
    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    private LocalDateTime registrationDate;

    // Default Constructor
    public Registration() {
        this.registrationDate = LocalDateTime.now();
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public user getUser() {
        return user;
    }

    public void setUser(user user) {
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }


}
