package com.yourcollege.campus_events_backend.entity;
import jakarta.persistence.*;


import java.time.LocalDate;

import java.util.List;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "events")

public class Event {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false)
	    private String title;

	    @Column(length = 1000)
	    private String description;

	    private String category;

	    private LocalDate eventDate;

	    private String location;

	    private int capacity;
	    @JsonIgnore
	    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
	    private List<Registration> registrations;
	    @JsonIgnore
	    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
	    private List<Feedback> feedbacks;
	    @JsonIgnore
	    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
	    private List<EventTag> tags;

	    // Default Constructor
	    public Event() {
	    }

	    // Parameterized Constructor
	    public Event(String title, String description, String category,
	                 LocalDate eventDate, String location, int capacity) {
	        this.title = title;
	        this.description = description;
	        this.category = category;
	        this.eventDate = eventDate;
	        this.location = location;
	        this.capacity = capacity;
	    }

	    // Getters and Setters

	    public Long getId() {
	        return id;
	    }

	    public String getTitle() {
	        return title;
	    }

	    public void setTitle(String title) {
	        this.title = title;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public String getCategory() {
	        return category;
	    }

	    public void setCategory(String category) {
	        this.category = category;
	    }

	    public LocalDate getEventDate() {
	        return eventDate;
	    }

	    public void setEventDate(LocalDate eventDate) {
	        this.eventDate = eventDate;
	    }

	    public String getLocation() {
	        return location;
	    }

	    public void setLocation(String location) {
	        this.location = location;
	    }

	    public int getCapacity() {
	        return capacity;
	    }

	    public void setCapacity(int capacity) {
	        this.capacity = capacity;
	    }
	    public List<Registration> getRegistrations() {
	        return registrations;
	    }

	    public void setRegistrations(List<Registration> registrations) {
	        this.registrations = registrations;
	    }
	    public java.util.List<Feedback> getFeedbacks() {
	        return feedbacks;
	    }

	    public void setFeedbacks(java.util.List<Feedback> feedbacks) {
	        this.feedbacks = feedbacks;
	    }
	    public java.util.List<EventTag> getTags() {
	        return tags;
	    }

	    public void setTags(java.util.List<EventTag> tags) {
	        this.tags = tags;
	    }

}
