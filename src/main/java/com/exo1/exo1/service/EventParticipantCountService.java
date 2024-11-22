package com.exo1.exo1.service;

import com.exo1.exo1.entity.EventParticipantCount;
import com.exo1.exo1.repository.EventParticipantCountRepository;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EventParticipantCountService {

    private final EventParticipantCountRepository eventParticipantCountRepository; ;
    private final JdbcTemplate jdbcTemplate;


    public List<EventParticipantCount> getAllEventCounts() {
        return eventParticipantCountRepository.findAll();
    }


    public EventParticipantCount getEventCountById(Long eventId) {
        return eventParticipantCountRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found with id: " + eventId));
    }


    public void refreshMaterializedView() {
        jdbcTemplate.execute("REFRESH MATERIALIZED VIEW event_participant_count");
    }
}

