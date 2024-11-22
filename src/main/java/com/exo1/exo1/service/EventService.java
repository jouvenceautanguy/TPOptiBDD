package com.exo1.exo1.service;

import com.exo1.exo1.dto.EventDto;
import com.exo1.exo1.entity.Event;
import com.exo1.exo1.mapper.EventMapper;
import com.exo1.exo1.repository.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

@Service
@AllArgsConstructor
public class EventService {
    private final EventRepository eventRepository;
    private final EventMapper eventMapper;
    @Cacheable("events")
    public Page<EventDto> findAll(PageRequest pageRequest) {
        return eventRepository.findAll(pageRequest).map(eventMapper::toDto);
    }
    @Cacheable("events")
    public EventDto findById(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Event not found with id " + id));
        return eventMapper.toDto(event);
    }
    @Transactional
    public EventDto save(EventDto eventDto) {
        Event event = eventMapper.toEntity(eventDto);
        return eventMapper.toDto(eventRepository.save(event));
    }

    public EventDto update(Long id, EventDto eventDto) {
        Event existingEvent = eventRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Event not found with id " + id));
        eventDto.setId(existingEvent.getId());
        Event eventUpdated = eventMapper.toEntity(eventDto);
        return eventMapper.toDto(eventRepository.save(eventUpdated));
    }
    @Transactional
    public void delete(Long id) {
        eventRepository.deleteById(id);
    }
    @CacheEvict(value = "events", allEntries = true)
    public void clearCache() {
    }
}
