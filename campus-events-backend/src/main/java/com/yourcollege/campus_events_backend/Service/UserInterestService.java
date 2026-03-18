package com.yourcollege.campus_events_backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourcollege.campus_events_backend.entity.*;
import com.yourcollege.campus_events_backend.Repository.*;

import java.util.List;
import java.util.Optional;

@Service

public class UserInterestService {
	
	 @Autowired
	    private UserInterestRepository userInterestRepository;

	    @Autowired
	    private UserRepository userRepository;

	    // Add interest
	    public UserInterest addInterest(Long userId, String category) {

	        Optional<user> user = userRepository.findById(userId);

	        if (user.isPresent()) {

	            UserInterest interest = new UserInterest();
	            interest.setUser(user.get());
	            interest.setCategory(category);

	            return userInterestRepository.save(interest);
	        } else {
	            throw new RuntimeException("User not found");
	        }
	    }

	    // Get user interests
	    public List<UserInterest> getUserInterests(Long userId) {
	        return userInterestRepository.findByUserId(userId);
	    }

}
