package com.exo1.exo1.controller;

import com.exo1.exo1.dto.MessageDto;
import com.exo1.exo1.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping
    public ResponseEntity<List<MessageDto>> findAll() {
        return ResponseEntity.ok(messageService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessageDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(messageService.findById(id));
    }

    @PostMapping
    public ResponseEntity<MessageDto> save(@RequestBody MessageDto messageDto) {
        return ResponseEntity.ok(messageService.save(messageDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        messageService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
