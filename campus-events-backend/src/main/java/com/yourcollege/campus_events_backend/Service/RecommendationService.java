package com.yourcollege.campus_events_backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourcollege.campus_events_backend.Repository.*;
import com.yourcollege.campus_events_backend.entity.*;

import java.util.*;


@Service

public class RecommendationService {
	
	 @Autowired
	    private EventRepository eventRepository;

	    @Autowired
	    private RegistrationRepository registrationRepository;

	    @Autowired
	    private FeedbackRepository feedbackRepository;
	    @Autowired
	    private UserInterestRepository userInterestRepository;

	    public List<Event> recommendEvents(Long userId) {

	    	    List<Registration> registrations =
	    	            registrationRepository.findByUserId(userId);

	    	    List<Long> registeredEventIds = registrations.stream()
	    	            .map(r -> r.getEvent().getId())
	    	            .toList();

	    	    List<UserInterest> interests =
	    	            userInterestRepository.findByUserId(userId);

	    	    List<String> userTags = interests.stream()
	    	            .map(UserInterest::getCategory)
	    	            .toList();

	    	    List<Event> allEvents = eventRepository.findAll();

	    	    List<Event> sortedEvents = allEvents.stream()
	    	            .filter(event -> !registeredEventIds.contains(event.getId()))
	    	            .sorted((e1, e2) ->
	    	                    Double.compare(
	    	                            calculateScore(e2, userTags),
	    	                            calculateScore(e1, userTags)
	    	                    ))
	    	            .toList();

	    	    return sortedEvents;
	    	}
	    private double calculateScore(Event event, List<String> userTags) {

	        Double avgRating =
	                feedbackRepository.findAverageRatingByEventId(event.getId());
	        if (avgRating == null) avgRating = 0.0;

	        Long feedbackCount =
	                feedbackRepository.countFeedbackByEventId(event.getId());
	        if (feedbackCount == null) feedbackCount = 0L;

	        double interestScore = 0;

	        if (event.getTags() != null) {   // ✅ SAFE CHECK
	            for (EventTag tag : event.getTags()) {
	                if (userTags.contains(tag.getTag())) {
	                    interestScore += 5;
	                }
	            }
	        }

	        return (interestScore * 5) + (avgRating * 3) + (feedbackCount * 1);
	    }
}
