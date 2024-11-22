package com.exo1.exo1.mapper;

import com.exo1.exo1.dto.EventDetailDto;
import com.exo1.exo1.dto.EventDto;
import com.exo1.exo1.entity.Event;
import com.exo1.exo1.entity.EventDetail;
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
public class EventMapperImpl implements EventMapper {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AddressMapper addressMapper;

    @Override
    public EventDto toDto(Event event) {
        if ( event == null ) {
            return null;
        }

        EventDto eventDto = new EventDto();

        eventDto.setId( event.getId() );
        eventDto.setOrganizer( userMapper.toDto( event.getOrganizer() ) );
        eventDto.setEventDetail( eventDetailToEventDetailDto( event.getEventDetail() ) );
        eventDto.setName( event.getName() );
        eventDto.setType( event.getType() );
        eventDto.setAddress( addressMapper.toDto( event.getAddress() ) );
        eventDto.setDateTime( event.getDateTime() );
        eventDto.setCapacity( event.getCapacity() );
        eventDto.setIsPaid( event.getIsPaid() );
        eventDto.setPrice( event.getPrice() );
        eventDto.setDescription( event.getDescription() );

        return eventDto;
    }

    @Override
    public Event toEntity(EventDto eventDto) {
        if ( eventDto == null ) {
            return null;
        }

        Event event = new Event();

        event.setId( eventDto.getId() );
        event.setOrganizer( userMapper.toEntity( eventDto.getOrganizer() ) );
        event.setName( eventDto.getName() );
        event.setType( eventDto.getType() );
        event.setEventDetail( eventDetailDtoToEventDetail( eventDto.getEventDetail() ) );
        event.setAddress( addressMapper.toEntity( eventDto.getAddress() ) );
        event.setDateTime( eventDto.getDateTime() );
        event.setCapacity( eventDto.getCapacity() );
        event.setIsPaid( eventDto.getIsPaid() );
        event.setPrice( eventDto.getPrice() );
        event.setDescription( eventDto.getDescription() );

        return event;
    }

    @Override
    public List<EventDto> toDtos(List<Event> events) {
        if ( events == null ) {
            return null;
        }

        List<EventDto> list = new ArrayList<EventDto>( events.size() );
        for ( Event event : events ) {
            list.add( toDto( event ) );
        }

        return list;
    }

    @Override
    public List<Event> toEntities(List<EventDto> eventDtos) {
        if ( eventDtos == null ) {
            return null;
        }

        List<Event> list = new ArrayList<Event>( eventDtos.size() );
        for ( EventDto eventDto : eventDtos ) {
            list.add( toEntity( eventDto ) );
        }

        return list;
    }

    protected EventDetailDto eventDetailToEventDetailDto(EventDetail eventDetail) {
        if ( eventDetail == null ) {
            return null;
        }

        EventDetailDto eventDetailDto = new EventDetailDto();

        eventDetailDto.setId( eventDetail.getId() );
        eventDetailDto.setEvent( toDto( eventDetail.getEvent() ) );
        eventDetailDto.setKey( eventDetail.getKey() );
        eventDetailDto.setValue( eventDetail.getValue() );

        return eventDetailDto;
    }

    protected EventDetail eventDetailDtoToEventDetail(EventDetailDto eventDetailDto) {
        if ( eventDetailDto == null ) {
            return null;
        }

        EventDetail eventDetail = new EventDetail();

        eventDetail.setId( eventDetailDto.getId() );
        eventDetail.setEvent( toEntity( eventDetailDto.getEvent() ) );
        eventDetail.setKey( eventDetailDto.getKey() );
        eventDetail.setValue( eventDetailDto.getValue() );

        return eventDetail;
    }
}
