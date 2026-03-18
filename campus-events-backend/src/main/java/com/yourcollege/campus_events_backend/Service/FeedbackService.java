package com.yourcollege.campus_events_backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourcollege.campus_events_backend.entity.*;
import com.yourcollege.campus_events_backend.Repository.*;

import java.util.List;
import java.util.Optional;

@Service

public class FeedbackService {
	@Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventRepository eventRepository;

    // Add feedback
    public Feedback addFeedback(Long userId, Long eventId, Feedback feedback) {

        Optional<user> user = userRepository.findById(userId);
        Optional<Event> event = eventRepository.findById(eventId);

        if (user.isPresent() && event.isPresent()) {

            feedback.setUser(user.get());
            feedback.setEvent(event.get());

            return feedbackRepository.save(feedback);
        } else {
            throw new RuntimeException("User or Event not found");
        }
    }

    // Get all feedbacks
    public List<Feedback> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }

}
