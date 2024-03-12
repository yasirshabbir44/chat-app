package com.example.demo.service;

import com.example.demo.model.ChatMessage;

import java.util.List;

public interface ChatService {
    List<ChatMessage> getAllMessages();
    void saveMessage(ChatMessage message);
}