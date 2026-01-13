package com.example.event_service.repository;

import com.example.event_service.model.SkiEvent;

import java.util.List;


@org.springframework.stereotype.Repository
public interface EventRepository extends org.springframework.data.jpa.repository.JpaRepository<SkiEvent, String> {

    List<SkiEvent> findByCategoryIgnoreCase( String category);
}

