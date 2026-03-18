package com.yourcollege.campus_events_backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.yourcollege.campus_events_backend.entity.EventTag;
import com.yourcollege.campus_events_backend.Service.EventTagService;

import java.util.List;

@RestController
@RequestMapping("/tags")

public class EventTagController {
	
	@Autowired
    private EventTagService eventTagService;

    @PostMapping("/add")
    public EventTag addTag(@RequestParam Long eventId,
                           @RequestParam String tag) {

        return eventTagService.addTag(eventId, tag);
    }

    @GetMapping("/{eventId}")
    public List<EventTag> getTags(@PathVariable Long eventId) {
        return eventTagService.getTagsByEvent(eventId);
    }

}
