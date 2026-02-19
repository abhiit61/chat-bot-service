package com.abhi.chatbotservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatBotService {

  private final GeminiAIService geminiAIService;

  @Autowired
  public ChatBotService(GeminiAIService geminiAIService) {
    this.geminiAIService = geminiAIService;
  }

  public String generateResponse(String query) {
    return geminiAIService.generateResponse(query);
  }
}
