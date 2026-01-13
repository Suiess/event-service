package com.example.event_service.controller;

import com.example.event_service.dto.SkiEventDTO;
import com.example.event_service.model.SkiEvent;
import com.example.event_service.service.EventService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public List<SkiEventDTO> getEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/category/{cat}")
    public List<SkiEvent> getByCategory(@PathVariable String cat) {
        return eventService.getEventsByCategory(cat);
    }

}