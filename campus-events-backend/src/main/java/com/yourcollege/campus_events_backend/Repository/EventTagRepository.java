package com.yourcollege.campus_events_backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.yourcollege.campus_events_backend.entity.EventTag;

import java.util.List;

public interface EventTagRepository extends JpaRepository<EventTag, Long> {
	
	List<EventTag> findByEventId(Long eventId);

}
