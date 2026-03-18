package com.yourcollege.campus_events_backend.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.yourcollege.campus_events_backend.entity.UserInterest;

import java.util.List;

public interface UserInterestRepository extends JpaRepository<UserInterest, Long> {
	
	 List<UserInterest> findByUserId(Long userId);
	 
	 

}
