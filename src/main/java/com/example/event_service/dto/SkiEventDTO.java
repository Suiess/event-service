package com.example.event_service.dto;

public class SkiEventDTO {
    private String title;
    private String day;
    private String startTime;
    private double price;
    private String location;


    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDay() { return day; }
    public void setDay(String day) { this.day = day; }
    public String getStartTime() { return startTime; }
    public void setStartTime(String startTime) { this.startTime = startTime; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}