package com.exo1.exo1.mapper;

import com.exo1.exo1.dto.EventDto;
import com.exo1.exo1.entity.Event;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class, AddressMapper.class})
public interface EventMapper {
    EventDto toDto(Event event);
    Event toEntity(EventDto eventDto);
    List<EventDto> toDtos(List<Event> events);
    List<Event> toEntities(List<EventDto> eventDtos);
}
