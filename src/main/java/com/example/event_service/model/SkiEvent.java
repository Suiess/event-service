package com.example.event_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "events")
public class SkiEvent {

    @Id
    private String id;

    private String title;
    private String category;
    private String day;
    private String startTime;
    private String endTime;
    private double price;
    private String location;
    private String details;

    public SkiEvent() {
    }

    public SkiEvent(String title, String category, String day, String startTime, String endTime, double price, String location, String details) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.category = category;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
        this.location = location;
        this.details = details;
    }


    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public String getDay() { return day; }
    public String getStartTime() { return startTime; }
    public String getEndTime() { return endTime; }
    public double getPrice() { return price; }
    public String getLocation() { return location; }
    public String getDetails() { return details; }


}