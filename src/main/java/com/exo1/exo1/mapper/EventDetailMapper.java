package com.exo1.exo1.mapper;

import com.exo1.exo1.dto.EventDetailDto;
import com.exo1.exo1.entity.EventDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {EventMapper.class})
public interface EventDetailMapper {
    EventDetailDto toDto(EventDetail eventDetail);
    @Mapping(target = "event", ignore = true)
    EventDetail toEntity(EventDetailDto eventDetailDto);
    List<EventDetailDto> toDtos(List<EventDetail> eventDetails);
    List<EventDetail> toEntities(List<EventDetailDto> eventDetailDtos);
}
