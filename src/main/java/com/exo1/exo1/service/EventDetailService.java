package com.exo1.exo1.service;

import com.exo1.exo1.dto.EventDetailDto;
import com.exo1.exo1.entity.EventDetail;
import com.exo1.exo1.mapper.EventDetailMapper;
import com.exo1.exo1.repository.EventDetailRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import java.util.List;

@Service
@AllArgsConstructor
public class EventDetailService {
    private final EventDetailRepository eventDetailRepository;
    private final EventDetailMapper eventDetailMapper;

    public List<EventDetailDto> findAll() {
        return eventDetailMapper.toDtos(eventDetailRepository.findAll());
    }

    public EventDetailDto findById(Long id) {
        EventDetail eventDetail = eventDetailRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("EventDetail not found with id " + id));
        return eventDetailMapper.toDto(eventDetail);
    }
    @Transactional
    public EventDetailDto save(EventDetailDto eventDetailDto) {
        EventDetail eventDetail = eventDetailMapper.toEntity(eventDetailDto);
        return eventDetailMapper.toDto(eventDetailRepository.save(eventDetail));
    }

    public EventDetailDto update(Long id, EventDetailDto eventDetailDto) {
        EventDetail existingEventDetail = eventDetailRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("EventDetail not found with id " + id));
        eventDetailDto.setId(existingEventDetail.getId());
        EventDetail eventDetailUpdated = eventDetailMapper.toEntity(eventDetailDto);
        return eventDetailMapper.toDto(eventDetailRepository.save(eventDetailUpdated));
    }
    @Transactional
    public void delete(Long id) {
        eventDetailRepository.deleteById(id);
    }
}
