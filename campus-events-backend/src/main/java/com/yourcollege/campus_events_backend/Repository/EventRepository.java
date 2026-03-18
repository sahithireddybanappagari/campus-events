package com.yourcollege.campus_events_backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.yourcollege.campus_events_backend.entity.Event;

public interface EventRepository extends JpaRepository<Event, Long> {

}
