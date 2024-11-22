package com.exo1.exo1.controller;

import com.exo1.exo1.dto.ParticipantDto;
import com.exo1.exo1.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/participants")
public class ParticipantController {
    @Autowired
    private ParticipantService participantService;

    @GetMapping
    public ResponseEntity<List<ParticipantDto>> findAll() {
        return ResponseEntity.ok(participantService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParticipantDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(participantService.findById(id));
    }

    @GetMapping("/participants/{eventId}")
    public ResponseEntity<List<ParticipantDto>> findParticipantsByEventId(@PathVariable Long eventId) {
        return ResponseEntity.ok(participantService.findParticipantsByEventId(eventId));
    }

    @PostMapping
    public ResponseEntity<ParticipantDto> save(@RequestBody ParticipantDto participantDto) {
        return ResponseEntity.ok(participantService.save(participantDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParticipantDto> update(@PathVariable Long id, @RequestBody ParticipantDto participantDto) {
        return ResponseEntity.ok(participantService.update(id, participantDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        participantService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
