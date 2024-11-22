package com.exo1.exo1.mapper;

import com.exo1.exo1.dto.MessageDto;
import com.exo1.exo1.entity.Message;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class, EventMapper.class})
public interface MessageMapper {
    MessageDto toDto(Message message);
    Message toEntity(MessageDto messageDto);
    List<MessageDto> toDtos(List<Message> messages);
    List<Message> toEntities(List<MessageDto> messageDtos);
}
