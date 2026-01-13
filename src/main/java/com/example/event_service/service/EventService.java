package com.example.event_service.service;

import com.example.event_service.dto.SkiEventDTO;
import com.example.event_service.model.SkiEvent;
import com.example.event_service.repository.EventRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {
    private final EventRepository repository;

    public EventService(EventRepository repository) {
        this.repository = repository;
        if (repository.count() == 0) {
            loadInitialData();
        }
    }

    private void loadInitialData() {

        repository.save(new SkiEvent("Night Skiing", "Outdoor", "Saturday", "20:00", "23:00", 450.0, "Slope 1", "Fun night riding"));
        repository.save(new SkiEvent("Snow Club Party", "Entertainment", "Friday", "22:00", "03:00", 250.0, "Peak Club", "Dress Code: White"));
        repository.save(new SkiEvent("Professional Ski Lesson", "Education", "Thursday", "10:00", "13:00", 1200.0, "Black Slope", "Advanced techniques"));
        repository.save(new SkiEvent("Summit Boozy Breakfast", "Gastro & Entertainment", "Sunday", "10:00", "13:00", 850.0, "Panorama Restaurant", "Luxury breakfast with unlimited Mimosas and local delicacies."));
        repository.save(new SkiEvent("Fire and Light Show on Snow", "Show", "Saturday", "21:00", "22:30", 200.0, "Main Square", "Breathtaking fire dance on snow by professional teams."));
        repository.save(new SkiEvent("Amateur Slalom Race", "Sports", "Sunday", "14:00", "17:00", 300.0, "Blue Slope", "Award-winning ski race open to all levels. Equipment not included."));
    }

    public List<SkiEvent> getEventsByCategory(String category) {
        List<SkiEvent> events = repository.findByCategoryIgnoreCase(category);

        events.forEach(event -> {
            System.out.println("Event: " + event.getTitle() +
                    " | Finish: " + event.getEndTime() +
                    " | Details: " + event.getDetails());
        });

        return events;
    }

    public List<SkiEventDTO> getAllEvents() {
        return repository.findAll().stream().map(event -> {
            SkiEventDTO dto = new SkiEventDTO();
            dto.setTitle(event.getTitle());
            dto.setDay(event.getDay());
            dto.setStartTime(event.getStartTime());
            dto.setPrice(event.getPrice());
            dto.setLocation(event.getLocation());
            return dto;
        }).collect(Collectors.toList());
    }
}