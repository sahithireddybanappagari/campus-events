package com.yourcollege.campus_events_backend.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourcollege.campus_events_backend.entity.Event;
import com.yourcollege.campus_events_backend.Repository.EventRepository;

import java.util.List;
import java.util.Optional;

@Service

public class EventService {
	@Autowired
    private EventRepository eventRepository;

    // Create Event
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    // Get All Events
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    // Get Event By ID
    public Optional<Event> getEventById(Long id) {
        return eventRepository.findById(id);
    }

    // Delete Event
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

}
