package com.exo1.exo1.controller;

import com.exo1.exo1.entity.EventParticipantCount;
import com.exo1.exo1.service.EventParticipantCountService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events/counts")
@AllArgsConstructor
public class EventParticipantCountController {

    private final EventParticipantCountService eventParticipantCountService;

    @GetMapping
    public ResponseEntity<List<EventParticipantCount>> getAllEventCounts() {
        return ResponseEntity.ok(eventParticipantCountService.getAllEventCounts());
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<EventParticipantCount> getEventCountById(@PathVariable Long eventId) {
        return ResponseEntity.ok(eventParticipantCountService.getEventCountById(eventId));
    }

    @PostMapping("/refresh")
    public ResponseEntity<Void> refreshMaterializedView() {
        eventParticipantCountService.refreshMaterializedView();
        return ResponseEntity.noContent().build();
    }
}
