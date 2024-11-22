package com.exo1.exo1.mapper;

import com.exo1.exo1.dto.MessageDto;
import com.exo1.exo1.entity.Message;
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
public class MessageMapperImpl implements MessageMapper {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private EventMapper eventMapper;

    @Override
    public MessageDto toDto(Message message) {
        if ( message == null ) {
            return null;
        }

        MessageDto messageDto = new MessageDto();

        messageDto.setId( message.getId() );
        messageDto.setSender( userMapper.toDto( message.getSender() ) );
        messageDto.setEvent( eventMapper.toDto( message.getEvent() ) );
        messageDto.setContent( message.getContent() );

        return messageDto;
    }

    @Override
    public Message toEntity(MessageDto messageDto) {
        if ( messageDto == null ) {
            return null;
        }

        Message message = new Message();

        message.setId( messageDto.getId() );
        message.setSender( userMapper.toEntity( messageDto.getSender() ) );
        message.setEvent( eventMapper.toEntity( messageDto.getEvent() ) );
        message.setContent( messageDto.getContent() );

        return message;
    }

    @Override
    public List<MessageDto> toDtos(List<Message> messages) {
        if ( messages == null ) {
            return null;
        }

        List<MessageDto> list = new ArrayList<MessageDto>( messages.size() );
        for ( Message message : messages ) {
            list.add( toDto( message ) );
        }

        return list;
    }

    @Override
    public List<Message> toEntities(List<MessageDto> messageDtos) {
        if ( messageDtos == null ) {
            return null;
        }

        List<Message> list = new ArrayList<Message>( messageDtos.size() );
        for ( MessageDto messageDto : messageDtos ) {
            list.add( toEntity( messageDto ) );
        }

        return list;
    }
}
