package com.abhi.chatbotservice.controller;

import com.abhi.chatbotservice.model.ChatRequest;
import com.abhi.chatbotservice.model.ChatResponse;
import com.abhi.chatbotservice.service.ChatBotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chatbot")
public class ChatBotController {

  private final ChatBotService chatBotService;

  @Autowired
  public ChatBotController(ChatBotService chatBotService) {
    this.chatBotService = chatBotService;
  }

  // Constructor injection of our service


  /**
   * Endpoint that receives customer queries and returns AI-generated responses
   *
   * @param request The chat request containing the user's query
   * @return A response with the AI-generated answer
   */
  @PostMapping("/chat")
  public ChatResponse chat(@RequestBody ChatRequest request) {
    // Validate the incoming request
    if (request.getQuery() == null || request.getQuery().trim().isEmpty()) {
      return new ChatResponse("Please provide a valid question or message.");
    }

    // Get a response from the Gemini AI service
    String aiResponse = chatBotService.generateResponse(request.getQuery());

    // Return the response to the client
    return new ChatResponse(aiResponse);
  }

}
