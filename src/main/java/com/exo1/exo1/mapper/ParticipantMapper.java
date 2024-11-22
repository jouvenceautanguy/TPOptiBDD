package com.exo1.exo1.mapper;

import com.exo1.exo1.dto.ParticipantDto;
import com.exo1.exo1.entity.Participant;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class, EventMapper.class})
public interface ParticipantMapper {
    ParticipantDto toDto(Participant participant);
    Participant toEntity(ParticipantDto participantDto);
    List<ParticipantDto> toDtos(List<Participant> participants);
    List<Participant> toEntities(List<ParticipantDto> participantDtos);
}
