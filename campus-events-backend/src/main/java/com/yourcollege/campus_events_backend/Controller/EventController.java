package com.yourcollege.campus_events_backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.yourcollege.campus_events_backend.entity.Event;
import com.yourcollege.campus_events_backend.Service.EventService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/events")

public class EventController {
	@Autowired
    private EventService eventService;

    // Create Event
    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        return eventService.createEvent(event);
    }

    // Get All Events
    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    // Get Event By ID
    @GetMapping("/{id}")
    public Optional<Event> getEventById(@PathVariable Long id) {
        return eventService.getEventById(id);
    }

    // Delete Event
    @DeleteMapping("/{id}")
    public String deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return "Event deleted successfully";
    }

}
