package com.exo1.exo1.mapper;

import com.exo1.exo1.dto.EventDetailDto;
import com.exo1.exo1.entity.EventDetail;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-22T13:31:12+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.13 (Amazon.com Inc.)"
)
@Component
public class EventDetailMapperImpl implements EventDetailMapper {

    @Autowired
    private EventMapper eventMapper;

    @Override
    public EventDetailDto toDto(EventDetail eventDetail) {
        if ( eventDetail == null ) {
            return null;
        }

        EventDetailDto eventDetailDto = new EventDetailDto();

        eventDetailDto.setId( eventDetail.getId() );
        eventDetailDto.setEvent( eventMapper.toDto( eventDetail.getEvent() ) );
        eventDetailDto.setKey( eventDetail.getKey() );
        eventDetailDto.setValue( eventDetail.getValue() );

        return eventDetailDto;
    }

    @Override
    public EventDetail toEntity(EventDetailDto eventDetailDto) {
        if ( eventDetailDto == null ) {
            return null;
        }

        EventDetail eventDetail = new EventDetail();

        eventDetail.setId( eventDetailDto.getId() );
        eventDetail.setKey( eventDetailDto.getKey() );
        eventDetail.setValue( eventDetailDto.getValue() );

        return eventDetail;
    }

    @Override
    public List<EventDetailDto> toDtos(List<EventDetail> eventDetails) {
        if ( eventDetails == null ) {
            return null;
        }

        List<EventDetailDto> list = new ArrayList<EventDetailDto>( eventDetails.size() );
        for ( EventDetail eventDetail : eventDetails ) {
            list.add( toDto( eventDetail ) );
        }

        return list;
    }

    @Override
    public List<EventDetail> toEntities(List<EventDetailDto> eventDetailDtos) {
        if ( eventDetailDtos == null ) {
            return null;
        }

        List<EventDetail> list = new ArrayList<EventDetail>( eventDetailDtos.size() );
        for ( EventDetailDto eventDetailDto : eventDetailDtos ) {
            list.add( toEntity( eventDetailDto ) );
        }

        return list;
    }
}
