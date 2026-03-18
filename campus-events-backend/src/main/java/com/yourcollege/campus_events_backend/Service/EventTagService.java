package com.yourcollege.campus_events_backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourcollege.campus_events_backend.entity.*;
import com.yourcollege.campus_events_backend.Repository.*;

import java.util.List;
import java.util.Optional;

@Service

public class EventTagService {
	
	 @Autowired
	    private EventTagRepository eventTagRepository;

	    @Autowired
	    private EventRepository eventRepository;

	    public EventTag addTag(Long eventId, String tag) {

	        Optional<Event> event = eventRepository.findById(eventId);

	        if (event.isPresent()) {

	            EventTag eventTag = new EventTag();
	            eventTag.setEvent(event.get());
	            eventTag.setTag(tag);

	            return eventTagRepository.save(eventTag);

	        } else {
	            throw new RuntimeException("Event not found");
	        }
	    }

	    public List<EventTag> getTagsByEvent(Long eventId) {
	        return eventTagRepository.findByEventId(eventId);
	    }

}
