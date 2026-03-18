package com.yourcollege.campus_events_backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.yourcollege.campus_events_backend.entity.Registration;
import com.yourcollege.campus_events_backend.Service.RegistrationService;

import java.util.List;

@RestController
@RequestMapping("/registrations")

public class RegistrationController {
	 @Autowired
	    private RegistrationService registrationService;

	    // Register user to event
	    @PostMapping("/register")
	    public Registration registerUser(@RequestParam Long userId,
	                                     @RequestParam Long eventId) {

	        return registrationService.registerUser(userId, eventId);
	    }

	    // Get all registrations
	    @GetMapping
	    public List<Registration> getAllRegistrations() {
	        return registrationService.getAllRegistrations();
	    }

}
