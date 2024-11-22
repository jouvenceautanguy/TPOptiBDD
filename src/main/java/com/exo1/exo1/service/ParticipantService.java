package com.exo1.exo1.service;

import com.exo1.exo1.dto.ParticipantDto;
import com.exo1.exo1.entity.Participant;
import com.exo1.exo1.mapper.ParticipantMapper;
import com.exo1.exo1.repository.ParticipantRepository;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import java.util.List;

@Service
@AllArgsConstructor
public class ParticipantService {
    private final ParticipantRepository participantRepository;
    private final ParticipantMapper participantMapper;

    @Cacheable("participants")
    public List<ParticipantDto> findAll() {

        return participantMapper.toDtos(participantRepository.findAll());
    }
    @Cacheable("participants")
    public List<ParticipantDto> findParticipantsByEventId(Long eventId) {
        return participantMapper.toDtos(participantRepository.findParticipantsByEventId(eventId));
    }

    public ParticipantDto findById(Long id) {
        Participant participant = participantRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Participant not found with id " + id));
        return participantMapper.toDto(participant);
    }
    @Transactional
    public ParticipantDto save(ParticipantDto participantDto) {
        Participant participant = participantMapper.toEntity(participantDto);
        return participantMapper.toDto(participantRepository.save(participant));
    }

    public ParticipantDto update(Long id, ParticipantDto participantDto) {
        Participant existingParticipant = participantRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Participant not found with id " + id));
        participantDto.setId(existingParticipant.getId());
        Participant participantUpdated = participantMapper.toEntity(participantDto);
        return participantMapper.toDto(participantRepository.save(participantUpdated));
    }
    @Transactional
    public void delete(Long id) {
        participantRepository.deleteById(id);
    }

    @CacheEvict(value = "participants", allEntries = true)
    public void clearCache() {
    }
}
