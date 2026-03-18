package com.yourcollege.campus_events_backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.yourcollege.campus_events_backend.entity.Event;
import com.yourcollege.campus_events_backend.Service.RecommendationService;

import java.util.List;

@RestController
@RequestMapping("/recommendations")

public class RecommendationController {
	
	 @Autowired
	    private RecommendationService recommendationService;

	    @GetMapping("/{userId}")
	    public List<Event> getRecommendations(@PathVariable Long userId) {
	        return recommendationService.recommendEvents(userId);
	    }

}
