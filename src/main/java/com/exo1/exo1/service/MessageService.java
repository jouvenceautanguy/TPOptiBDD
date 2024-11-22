package com.exo1.exo1.service;

import com.exo1.exo1.dto.MessageDto;
import com.exo1.exo1.entity.Message;
import com.exo1.exo1.mapper.MessageMapper;
import com.exo1.exo1.repository.MessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
@AllArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;

    public List<MessageDto> findAll() {
        return messageMapper.toDtos(messageRepository.findAll());
    }

    public MessageDto findById(Long id) {
        Message message = messageRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Message not found with id " + id));
        return messageMapper.toDto(message);
    }

    public MessageDto save(MessageDto messageDto) {
        Message message = messageMapper.toEntity(messageDto);
        return messageMapper.toDto(messageRepository.save(message));
    }

    public void delete(Long id) {
        messageRepository.deleteById(id);
    }
}
