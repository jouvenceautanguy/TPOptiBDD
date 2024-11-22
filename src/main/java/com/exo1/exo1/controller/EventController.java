package com.exo1.exo1.controller;

import com.exo1.exo1.dto.EventDto;
import com.exo1.exo1.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/events")
public class EventController {
    @Autowired
    private EventService eventService;

    @GetMapping
    public ResponseEntity<Page<EventDto>> findAll(@RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "5") int size) {
        return ResponseEntity.ok(eventService.findAll(PageRequest.of(page, size)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(eventService.findById(id));
    }

    @PostMapping
    public ResponseEntity<EventDto> save(@RequestBody EventDto eventDto) {
        return ResponseEntity.ok(eventService.save(eventDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventDto> update(@PathVariable Long id, @RequestBody EventDto eventDto) {
        return ResponseEntity.ok(eventService.update(id, eventDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        eventService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/cacheReset")
    public ResponseEntity<Void> cacheReset() {
        eventService.clearCache();
        return ResponseEntity.noContent().build();
    }
}
