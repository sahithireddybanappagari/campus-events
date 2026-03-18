package com.yourcollege.campus_events_backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_interests")

public class UserInterest {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    // Many interests belong to one user
	    @ManyToOne
	    @JoinColumn(name = "user_id", nullable = false)
	    private user user;

	    @Column(nullable = false)
	    private String category;

	    // Default Constructor
	    public UserInterest() {
	    }

	    // Constructor
	    public UserInterest(user user, String category) {
	        this.user = user;
	        this.category = category;
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

	    public String getCategory() {
	        return category;
	    }

	    public void setCategory(String category) {
	        this.category = category;
	    }

}
