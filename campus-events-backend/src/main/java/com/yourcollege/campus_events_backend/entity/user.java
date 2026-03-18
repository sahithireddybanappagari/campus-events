package com.yourcollege.campus_events_backend.entity;

import jakarta.persistence.*;



import java.util.List;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class user {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false, length = 255)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    private String department;

    private LocalDateTime createdAt;
    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Registration> registrations;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Feedback> feedbacks;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserInterest> interests;
    // Default constructor
    public user() {
    }

    // Parameterized constructor
    public user(Long id, String name, String email, String password, Role role, String department, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.department = department;
        this.createdAt = createdAt;
    }

    // Automatically set createdAt before insert
    @PrePersist
    public void setCreatedAt() {
        this.createdAt = LocalDateTime.now();
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public void setId(Long id) {
		this.id = id;
	}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
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
    public java.util.List<UserInterest> getInterests() {
        return interests;
    }

    public void setInterests(java.util.List<UserInterest> interests) {
        this.interests = interests;
    }
}