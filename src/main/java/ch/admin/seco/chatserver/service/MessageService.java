package ch.admin.seco.chatserver.service;

import ch.admin.seco.chatserver.data.messages.MessageEntity;
import ch.admin.seco.chatserver.data.messages.MessageRepository;
import ch.admin.seco.chatserver.dto.messages.CreateMessageDto;
import ch.admin.seco.chatserver.dto.messages.MessageDto;
import ch.admin.seco.chatserver.dto.messages.UpdateMessageDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }

    private static List<MessageDto> mapToDto(final List<MessageEntity> messageEntities) {
        final List<MessageDto> messages = new ArrayList<>();
        for (final MessageEntity messageEntity : messageEntities) {
            messages.add(mapToDto(messageEntity));
        }
        return messages;
    }

    private static MessageDto mapToDto(final MessageEntity messageEntity) {
        return new MessageDto(messageEntity.getId(), messageEntity.getMessage(), messageEntity.getUser_id());
    }

    public List<MessageDto> getAllMessages() {
        return mapToDto(messageRepository.findAll());
    }

    public MessageDto getMessageById(final int id){
        return mapToDto(messageRepository.getOne(id));
    }

    public int createMessage(CreateMessageDto messageDto) {
        final MessageEntity messageEntity = messageRepository.save(new MessageEntity(messageDto.getMessage(), messageDto.getUser_id()));
        return messageEntity.getId();
    }

    public MessageDto updateMessage(final int id, UpdateMessageDto messageDto){
        final MessageEntity messageEntity = messageRepository.getOne(id);
        if(messageDto.getMessage() != null){
            messageEntity.setMessage(messageDto.getMessage());
        }
        if(messageDto.getUser_id() != null){
            messageEntity.setUser_id(messageDto.getUser_id());
        }
        return mapToDto(messageRepository.save(messageEntity));
    }
}