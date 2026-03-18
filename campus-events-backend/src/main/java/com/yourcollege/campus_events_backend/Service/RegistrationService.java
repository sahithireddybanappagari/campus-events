package com.yourcollege.campus_events_backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourcollege.campus_events_backend.entity.*;
import com.yourcollege.campus_events_backend.Repository.*;

import java.util.List;
import java.util.Optional;

@Service

public class RegistrationService {
	 @Autowired
	    private RegistrationRepository registrationRepository;

	    @Autowired
	    private UserRepository userRepository;

	    @Autowired
	    private EventRepository eventRepository;

	    // Register a user for event
	    public Registration registerUser(Long userId, Long eventId) {

	        Optional<user> user = userRepository.findById(userId);
	        Optional<Event> event = eventRepository.findById(eventId);

	        if (user.isPresent() && event.isPresent()) {

	            Registration registration = new Registration();
	            registration.setUser(user.get());
	            registration.setEvent(event.get());

	            return registrationRepository.save(registration);
	        } else {
	            throw new RuntimeException("User or Event not found");
	        }
	    }

	    // Get all registrations
	    public List<Registration> getAllRegistrations() {
	        return registrationRepository.findAll();
	    }

}
