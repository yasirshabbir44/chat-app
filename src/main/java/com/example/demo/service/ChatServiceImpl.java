package com.example.demo.service;

import com.example.demo.model.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    @Override
    public List<ChatMessage> getAllMessages() {
        return chatMessageRepository.findAll();
    }

    @Override
    public void saveMessage(ChatMessage message) {
        chatMessageRepository.save(message);
    }
}
