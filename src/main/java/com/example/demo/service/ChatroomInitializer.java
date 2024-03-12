package com.example.demo.service;

import com.example.demo.model.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

;

@Component
public class ChatroomInitializer implements ApplicationRunner {

    @Autowired
    private ChatService chatService;

    @Override
    public void run(ApplicationArguments args) {
        // Initialize chat room with some default messages
        chatService.saveMessage(ChatMessage.builder().sender("Admin").message("Welcome to the chat room!").build());
        chatService.saveMessage(ChatMessage.builder().sender("Admin").message("Feel free to start chatting!").build());
    }
}
