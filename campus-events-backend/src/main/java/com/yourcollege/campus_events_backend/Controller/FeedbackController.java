package com.yourcollege.campus_events_backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.yourcollege.campus_events_backend.entity.Feedback;
import com.yourcollege.campus_events_backend.Service.FeedbackService;

import java.util.List;

@RestController
@RequestMapping("/feedbacks")

public class FeedbackController {
	 @Autowired
	    private FeedbackService feedbackService;
	 

	    // Add feedback
	    @PostMapping("/add")
	    public Feedback addFeedback(@RequestParam Long userId,
	                                @RequestParam Long eventId,
	                                @RequestBody Feedback feedback) {

	        return feedbackService.addFeedback(userId, eventId, feedback);
	    }

	    // Get all feedbacks
	    @GetMapping
	    public List<Feedback> getAllFeedbacks() {
	        return feedbackService.getAllFeedbacks();
	    }

}
