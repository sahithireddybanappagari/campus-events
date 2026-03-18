package com.yourcollege.campus_events_backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "event_tags")

public class EventTag {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    // Many tags belong to one event
	    @ManyToOne
	    @JoinColumn(name = "event_id", nullable = false)
	    private Event event;

	    @Column(nullable = false)
	    private String tag;

	    // Default constructor
	    public EventTag() {
	    }

	    public EventTag(Event event, String tag) {
	        this.event = event;
	        this.tag = tag;
	    }

	    // Getters and Setters

	    public Long getId() {
	        return id;
	    }

	    public Event getEvent() {
	        return event;
	    }

	    public void setEvent(Event event) {
	        this.event = event;
	    }

	    public String getTag() {
	        return tag;
	    }

	    public void setTag(String tag) {
	        this.tag = tag;
	    }

}
