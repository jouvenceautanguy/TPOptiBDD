package com.exo1.exo1.mapper;

import com.exo1.exo1.dto.ParticipantDto;
import com.exo1.exo1.entity.Participant;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-22T14:39:39+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.13 (Amazon.com Inc.)"
)
@Component
public class ParticipantMapperImpl implements ParticipantMapper {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private EventMapper eventMapper;

    @Override
    public ParticipantDto toDto(Participant participant) {
        if ( participant == null ) {
            return null;
        }

        ParticipantDto participantDto = new ParticipantDto();

        participantDto.setId( participant.getId() );
        participantDto.setUser( userMapper.toDto( participant.getUser() ) );
        participantDto.setEvent( eventMapper.toDto( participant.getEvent() ) );
        participantDto.setStatus( participant.getStatus() );
        participantDto.setPaid( participant.getPaid() );
        participantDto.setRating( participant.getRating() );
        participantDto.setComment( participant.getComment() );

        return participantDto;
    }

    @Override
    public Participant toEntity(ParticipantDto participantDto) {
        if ( participantDto == null ) {
            return null;
        }

        Participant participant = new Participant();

        participant.setId( participantDto.getId() );
        participant.setUser( userMapper.toEntity( participantDto.getUser() ) );
        participant.setEvent( eventMapper.toEntity( participantDto.getEvent() ) );
        participant.setStatus( participantDto.getStatus() );
        participant.setPaid( participantDto.getPaid() );
        participant.setRating( participantDto.getRating() );
        participant.setComment( participantDto.getComment() );

        return participant;
    }

    @Override
    public List<ParticipantDto> toDtos(List<Participant> participants) {
        if ( participants == null ) {
            return null;
        }

        List<ParticipantDto> list = new ArrayList<ParticipantDto>( participants.size() );
        for ( Participant participant : participants ) {
            list.add( toDto( participant ) );
        }

        return list;
    }

    @Override
    public List<Participant> toEntities(List<ParticipantDto> participantDtos) {
        if ( participantDtos == null ) {
            return null;
        }

        List<Participant> list = new ArrayList<Participant>( participantDtos.size() );
        for ( ParticipantDto participantDto : participantDtos ) {
            list.add( toEntity( participantDto ) );
        }

        return list;
    }
}
