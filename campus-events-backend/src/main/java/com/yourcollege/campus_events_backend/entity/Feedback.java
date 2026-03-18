package com.yourcollege.campus_events_backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "feedbacks")

public class Feedback {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    // Many feedbacks can belong to one user
	    @ManyToOne
	    @JoinColumn(name = "user_id", nullable = false)
	    private user user;

	    // Many feedbacks can belong to one event
	    @ManyToOne
	    @JoinColumn(name = "event_id", nullable = false)
	    private Event event;

	    @Column(nullable = false)
	    private int rating; // 1 to 5

	    @Column(length = 1000)
	    private String comment;

	    private LocalDateTime feedbackDate;

	    // Default Constructor
	    public Feedback() {
	        this.feedbackDate = LocalDateTime.now();
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

	    public int getRating() {
	        return rating;
	    }

	    public void setRating(int rating) {
	        this.rating = rating;
	    }

	    public String getComment() {
	        return comment;
	    }

	    public void setComment(String comment) {
	        this.comment = comment;
	    }

	    public LocalDateTime getFeedbackDate() {
	        return feedbackDate;
	    }

	    public void setFeedbackDate(LocalDateTime feedbackDate) {
	        this.feedbackDate = feedbackDate;
	    }

}
