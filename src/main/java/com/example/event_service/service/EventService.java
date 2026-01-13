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

        repository.save(new SkiEvent("Gece Kayağı", "Dış Mekan", "Cumartesi", "20:00", "23:00", 450.0, "Pist 1", "Eğlenceli gece sürüşü"));
        repository.save(new SkiEvent("Kar Club Partisi", "Eğlence", "Cuma", "22:00", "03:00", 250.0, "Peak Club", "Dress Code: Beyaz"));
        repository.save(new SkiEvent("Profesyonel Kayak Dersi", "Eğitim", "Perşembe", "10:00", "13:00", 1200.0, "Siyah Pist", "İleri teknikler"));
        repository.save(new SkiEvent("Zirvede Alkollü Kahvaltı","Gastro & Entertainment","Pazar","10:00", "13:00",850.0, "Panorama Restoran","Sınırsız Mimosa ve yerel lezzetler eşliğinde lüks kahvaltı."));
        repository.save(new SkiEvent("Karda Ateş ve Işık Gösterisi", "Show", "Cumartesi", "21:00", "22:30", 200.0, "Ana Meydan", "Profesyonel ekiplerden kar üzerinde nefes kesen ateş dansı."));
        repository.save(new SkiEvent("Amatörler Arası Slalom Yarışı", "Sports", "Pazar", "14:00", "17:00", 300.0, "Mavi Pist", "Her seviyeden katılıma açık, ödüllü kayak yarışması. Ekipman dahil değildir."));
    }

    public List<SkiEvent> getEventsByCategory(String category) {
        List<SkiEvent> events = repository.findByCategoryIgnoreCase(category);

        events.forEach(event -> {
            System.out.println("Etkinlik: " + event.getTitle() +
                    " | Bitiş: " + event.getEndTime() +
                    " | Detay: " + event.getDetails());
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