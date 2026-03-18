package com.yourcollege.campus_events_backend.Repository;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import com.yourcollege.campus_events_backend.entity.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long>{
	
	@Query("SELECT AVG(f.rating) FROM Feedback f WHERE f.event.id = :eventId")
	Double findAverageRatingByEventId(@Param("eventId") Long eventId);

	@Query("SELECT COUNT(f) FROM Feedback f WHERE f.event.id = :eventId")
	Long countFeedbackByEventId(@Param("eventId") Long eventId);

}
