package com.exo1.exo1.controller;

import com.exo1.exo1.dto.EventDetailDto;
import com.exo1.exo1.service.EventDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event-details")
public class EventDetailController {
    @Autowired
    private EventDetailService eventDetailService;

    @GetMapping
    public ResponseEntity<List<EventDetailDto>> findAll() {
        return ResponseEntity.ok(eventDetailService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventDetailDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(eventDetailService.findById(id));
    }

    @PostMapping
    public ResponseEntity<EventDetailDto> save(@RequestBody EventDetailDto eventDetailDto) {
        return ResponseEntity.ok(eventDetailService.save(eventDetailDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventDetailDto> update(@PathVariable Long id, @RequestBody EventDetailDto eventDetailDto) {
        return ResponseEntity.ok(eventDetailService.update(id, eventDetailDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        eventDetailService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
