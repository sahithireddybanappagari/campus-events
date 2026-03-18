package com.yourcollege.campus_events_backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.yourcollege.campus_events_backend.entity.UserInterest;
import com.yourcollege.campus_events_backend.Service.UserInterestService;

import java.util.List;

@RestController
@RequestMapping("/interests")


public class UserInterestController {
	
	 @Autowired
	    private UserInterestService userInterestService;

	    // Add interest
	    @PostMapping("/add")
	    public UserInterest addInterest(@RequestParam Long userId,
	                                    @RequestParam String category) {

	        return userInterestService.addInterest(userId, category);
	    }

	    // Get user interests
	    @GetMapping("/{userId}")
	    public List<UserInterest> getUserInterests(@PathVariable Long userId) {
	        return userInterestService.getUserInterests(userId);
	    }

}
