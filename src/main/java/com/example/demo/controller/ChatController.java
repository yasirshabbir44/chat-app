package com.example.demo.controller;

import com.example.demo.model.ChatMessage;
import com.example.demo.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @GetMapping("/messages")
    public List<ChatMessage> getAllMessages() {
        return chatService.getAllMessages();
    }

    @PostMapping("/messages")
    public void sendMessage(@RequestBody ChatMessage message) {
        chatService.saveMessage(message);
    }
}
